package com.uflowertv.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.util.commons.ConstantHolder;
import com.uflowertv.dao.XxjOrderDaoI;
import com.uflowertv.model.dto.GetUserInfoDTO;
import com.uflowertv.model.dto.ProductDTO;
import com.uflowertv.model.dto.ProductOrderDTO;
import com.uflowertv.model.po.XxjOrder;
import com.uflowertv.model.po.XxjProduct;
import com.uflowertv.model.po.XxjRated;
import com.uflowertv.model.po.XxjUser;
import com.uflowertv.model.vo.OfferIdCompared;
import com.uflowertv.service.XxjOrderServiceI;
import com.uflowertv.service.XxjProductionServiceI;
import com.uflowertv.service.XxjRatedServiceI;
import com.uflowertv.service.XxjUserServiceI;
import com.util.MD5Util;
import com.util.StringEcodingUtil;
import com.util.commons.GuavaUtil;
import com.util.connection.DataBaseUtil;
import com.util.connection.HttpClientUtils;
import com.util.date.DateTimeUtil;
import com.util.json.JsonUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 
 * 版权所有：2017年3月9日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：订单业务
 * 类名称：com.uflowertv.service.impl.XxjOrderServiceImpl     
 * 创建人：liguoliang 
 * 创建时间：2017年3月9日 下午3:52:38   
 * 修改人：
 * 修改时间：2017年3月9日 下午3:52:38   
 * 修改备注：   
 * @version   V1.0
 */
@Service("xxjOrderService")
public class XxjOrderServiceImpl implements XxjOrderServiceI{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private XxjOrderDaoI xxjOrderDao;
	@Autowired
	private XxjUserServiceI xxjUserService;
	@Autowired
	private XxjRatedServiceI xxjRatedService;
	@Autowired
	private XxjProductionServiceI xxjProductionService;
		
	/**
	 * 获取用户有效订单列表
	 */
	@Override
	public List<XxjOrder> getUserOrderList(int platformId,int userId) {
		log.info("获取用户有效订单列表");
		Map<String, Object> params = Maps.newHashMap();
		checkArgument(platformId!=0,"平台ID为空");
		checkArgument(userId!=0,"用户ID为空");
		params.put("platformId", platformId);
		params.put("user_id", userId);
		params.put("order_status", ConstantHolder.ORDER_SUCCESS);
		String hql = "from XxjOrder WHERE platformId=:platformId AND user_id =:user_id AND order_status =:order_status AND NOW() BETWEEN effective AND expires";
		List<XxjOrder> list = find(hql,params);
		checkArgument(!CollectionUtils.isEmpty(list),"该用户下无产品列表");
		return list;
	}
	
	/**
	 * 送书二维码
	 */
	@Override
	public String getQrcodeUrl(int platformId, int orderId){
		log.info("生成送书二维码");
		checkArgument(platformId!=0,"平台ID为空");
		checkArgument(orderId!=0,"订单ID为空");
		XxjOrder xxjOrder = getById(orderId);
		checkNotNull(xxjOrder,"订单"+orderId+"不存在");
		int userId = xxjOrder.getUser_id();
        int product_id = xxjOrder.getProduct_id();
        int buy_type = xxjOrder.getBuy_type();
        String check_code = "1c10ffa8e53b40d34cf94e6d76b4709ddb9f29cee7b06a2461614521dc323f9b";
        String md5 = MD5Util.MD5("p="+platformId+"&c="+product_id+"&t="+buy_type+"&o="+orderId+"&u="+userId+"&k="+check_code);
    	String url = String.format(ConstantHolder.QRCODE_URL, platformId,product_id,buy_type,orderId,userId,md5);
    	return url;
	}

	/**
	 * 更新支付接口订单信息
	 */
	@Override
	public void updateOrderInfo(String orderId, String paySeq, String payState, String payDesc, String payType) {
		log.info("更新支付接口订单信息");
		Map<String, Object> params = Maps.newHashMap();
		checkArgument(StringUtils.isNotBlank(orderId),"订单ID为空");
		checkArgument(StringUtils.isNotBlank(paySeq),"支付流水号为空");
		checkArgument(StringUtils.isNotBlank(payState),"支付状态为空");
		checkArgument(StringUtils.isNotBlank(payDesc),"支付描述为空");
		checkArgument(StringUtils.isNotBlank(payType),"支付类型为空");
		payDesc = StringEcodingUtil.ecodingTransform(payDesc, CharEncoding.ISO_8859_1);
		String sql = "update xxj_order set serial_number=:serial_number,pay_desc=:pay_desc,order_status=:order_status,pay_type=:pay_type where order_id=:order_id";
		params.put("serial_number", paySeq);
		params.put("pay_desc", payDesc);
		params.put("order_status", Integer.valueOf(payState));
		params.put("pay_type", payType);
		params.put("order_id", Integer.valueOf(orderId));
		int num = executeBySql(sql, params);
		log.info("支付订单回调:{}",num>0?"success":"fail");
	}
	
	/**
	 * 更新订购接口订单信息
	 */
	@Override
	public Map<String, Object> updateOrderInfo(int userId,String comboId, String order_status, String order_desc) {
		log.info("用户订购套餐回调详情");
		Map<String, Object> params = Maps.newHashMap();
		checkArgument(userId!=0,"用户ID为空");
		checkArgument(StringUtils.isNotBlank(comboId),"套餐ID为空");
		checkArgument(StringUtils.isNotBlank(order_status),"订单状态为空");
		checkArgument(StringUtils.isNotBlank(order_desc),"订单描述为空");
		params.put("oper_comboId", comboId);
		params.put("user_id", userId);
		String hql = "from XxjOrder where oper_comboId=:oper_comboId and user_id=:user_id";
		XxjOrder xxjOrder = xxjOrderDao.getByHql(hql, params);
		checkNotNull(xxjOrder,"用户ID或套餐ID不存在");
		int status = Integer.valueOf(order_status);
		switch (status) {
			case 0:
				status = ConstantHolder.ORDER_SUCCESS;
				break;
			case 1:
				status = ConstantHolder.ORDER_FAIL;
				break;
			default:
				break;
		}
		String sql = "update xxj_order set order_status=:order_status,order_desc=:order_desc where order_id=:order_id";
		params.clear();
		params.put("order_status", status);
		params.put("order_desc", order_desc);
		params.put("order_id", xxjOrder.getOrder_id());
		executeBySql(sql, params);
		params.clear();
		params.put("code", 200);
		params.put("message", "OK");
		params.put("data", xxjOrder);
		return params;
	}
	
	/**
	 *  用户已购买产品
	 * @
	 */
	@Override
	public void updateUserPurchaseProduction(int userId) {
		log.info("开始与Boss接口进行用户产品列表同步");
		Map<String, Object> params = Maps.newHashMap();
		checkArgument(userId!=0,"用户ID为空");
		//获取用户ID前先获取用户已购买产品
		String queryType = ConstantHolder.QUERY_TYPE;//智能卡号类型
		XxjUser xxjUser = xxjUserService.getById(userId);
		checkNotNull(xxjUser,"用户不存在");
		String card = xxjUser.getCard();
		int platformId = xxjUser.getPlatformId();
		//获取用户ID
		String url = String.format(ConstantHolder.USER_INFO_URL, card,queryType);
 		String json = HttpClientUtils.get(url);
		GetUserInfoDTO getUserInfo = JsonUtils.json2Bean(json, GetUserInfoDTO.class);
//			GetUserInfoDTO getUserInfo = JsonUtils.json2Bean(json(), GetUserInfoDTO.class);
		checkNotNull(getUserInfo,"系统繁忙，请稍候再试！");
		// 获取用户所有已订购所有套餐ID列表
		List<ProductOrderDTO> productOrderList = getUserInfo.getCustInfo().getUserList().get(0).getProductOrderList();
		checkArgument(!CollectionUtils.isEmpty(productOrderList),"用户无订购任何产品");
		ArrayList<OfferIdCompared> oper_combo = Lists.newArrayList();
		ArrayList<OfferIdCompared> xxj_combo = Lists.newArrayList();
		productOrderList.forEach(productOrder -> {
			ProductDTO product = productOrder.getProductLs().get(0);
			OfferIdCompared offerIdCompared = new OfferIdCompared(productOrder.getOfferId(), productOrder.getOfferName(),
					product.getExpireDate(), product.getProductId(), product.getProductName(), product.getStatus(),
					product.getValidDate());
			oper_combo.add(offerIdCompared);
		});
		// 获取用户所有学习佳套餐ID列表
		String hql = "select new XxjRated(offer_id) from XxjRated";
		List<XxjRated> rated_list = xxjRatedService.find(hql);
		checkArgument(!CollectionUtils.isEmpty(rated_list),"查询套餐信息失败");
		rated_list.forEach(rated_obj -> {
			xxj_combo.add(new OfferIdCompared(rated_obj.getOffer_id()));
		});
		// 获取用户订购学习佳产品列表
		List<OfferIdCompared> productList = GuavaUtil.getListIntersection(oper_combo, xxj_combo);//交集
		checkArgument(!CollectionUtils.isEmpty(productList),"该用户没有订购学习佳产品");
		//预处理产品列表
		List<XxjOrder> preparedProductList = Lists.newArrayList();
		//学习佳产品列表
		for (OfferIdCompared product : productList) {
			DateTime dateTime = DateTimeUtil.transStringToDateTime(product.getValidDate());
			// 通过生效时间与用户ID生成产品订单号
			String offerId = product.getOfferId();// 运营商套餐ID
			preparedProductList.add(new XxjOrder(offerId));
			String operOrderId = new DateTime(dateTime.toDate()).toString("yyyyMMddHHmmss") +userId;
			String offerName = product.getOfferName();//运营商套餐名称
			String operProductId = product.getProductId();//运营商产品ID
			String operProductName = product.getProductName();//运营商产品名称
			// 通过套餐ID查询出订价信息
			params.clear();
			params.put("offer_id", offerId);
			hql = "from XxjRated where offer_id=:offer_id";
			XxjRated xxjRated = xxjRatedService.getByHql(hql,params);
			String oper_comboId = xxjRated.getCombo_id();
			int productId = xxjRated.getProduct_id();//学习佳产品ID
			String showPrice = xxjRated.getShow_price();//学习佳套餐价格
			int buyType = xxjRated.getProduct_type();//学习佳购买类型
			// 通过产品ID查询出产品名称
			XxjProduct xxjProduct = xxjProductionService.getById(productId);
			checkNotNull(xxjProduct,"找不到产品信息");
			String productName = xxjProduct.getProduct_name();//学习佳产品名称
			Date effective = DateTimeUtil.transStringToDate(product.getValidDate());
			Date expires = null;
			// 1:包月2:半年3:全年0:指定日期
			switch (buyType) {
				case 0:
					expires = dateTime.plusDays(xxjProduct.getBuy_days()).toDate();
					break;
				case 1:
					expires = dateTime.plusMonths(1).toDate();
					break;
				case 2:
					expires = dateTime.plusMonths(6).toDate();
					break;
				case 3:
					expires = dateTime.plusYears(1).toDate();
					break;
				default:
					break;
			}
			int operProductStatus = Integer.valueOf(product.getProductStatus());
			//根据产品状态更新订单状态
			int orderStatus = 0;
			switch (operProductStatus) {
				case 0:
					orderStatus = ConstantHolder.ORDER_SUCCESS;
					break;
				case 1:
					orderStatus = ConstantHolder.ORDER_OUT_OF_SERVER;
					break;
				default:
					break;
			}
			//营业厅订购
			params.clear();
			params.put("platformId", platformId);
			params.put("userId", userId);
			params.put("offerId", offerId);
			hql = "from XxjOrder WHERE platformId=:platformId AND user_id =:userId AND oper_offerId=:offerId";
			//营业厅、初次订购
			List<XxjOrder> order_list = find(hql,params);
			if (CollectionUtils.isEmpty(order_list)) {
				log.info("营业厅订购");
				// 1、营业厅订购(添加所有字段,除去支付字段)
				insertOrder(new XxjOrder(platformId, userId,oper_comboId, offerId, offerName,
								 operProductId, operProductName, operProductStatus, operOrderId,
								 productId, productName, ConstantHolder.ORDER_OTHER,
								 showPrice,orderStatus,buyType, effective, expires));
			} 
			hql = "from XxjOrder WHERE platformId=:platformId AND user_id =:userId AND oper_offerId=:offerId AND NOW() BETWEEN effective AND expires";
			List<XxjOrder> enable_list = find(hql,params);
			for (XxjOrder xxjOrder : order_list) {
				String oper_orderId = xxjOrder.getOper_orderId();
				//订单号是否相等
				boolean equal = StringUtils.equals(oper_orderId, operOrderId);
				// Boss接口购买
				if(StringUtils.isBlank(oper_orderId)){//初次订购,更新
					log.info("初次订购");
					params.clear();
					params.put("order_id", xxjOrder.getOrder_id());
					params.put("oper_offerId", offerId);
					params.put("oper_offerName", offerName);
					params.put("oper_productId", operProductId);
					params.put("oper_productName", operProductName);
					params.put("oper_productStatus", operProductStatus);
					params.put("oper_orderId", operOrderId);
					params.put("product_id", productId);
					params.put("product_name", productName);
					params.put("order_souces", ConstantHolder.ORDER_BOSS);
					params.put("order_price", showPrice);
					params.put("order_status", orderStatus);
					params.put("buy_type", buyType);
					params.put("effective", effective);
					params.put("expires", expires);
					String sql = "update xxj_order set oper_offerId=:oper_offerId,oper_offerName=:oper_offerName"
								+ ",oper_productId=:oper_productId,oper_productName=:oper_productName"
								+ ",oper_productStatus=:oper_productStatus,oper_orderId=:oper_orderId"
								+ ",product_id=:product_id,product_name=:product_name,order_souces=:order_souces"
								+ ",order_price=:order_price,order_status=:order_status,buy_type=:buy_type"
								+ ",effective=:effective,expires=:expires where order_id=:order_id";
					executeBySql(sql, params);
				}else if(!equal){//产品续订,添加
					if(CollectionUtils.isEmpty(enable_list)){
						log.info("产品续订");
						insertOrder(new XxjOrder(platformId, userId, oper_comboId,offerId, offerName,
									operProductId, operProductName, operProductStatus, operOrderId,
									productId, productName, ConstantHolder.ORDER_BOSS,
									showPrice,orderStatus,buyType, effective, expires));
					}
				}else{
					log.info("更新产品状态");
					params.clear();
					params.put("oper_productStatus", operProductStatus);
					params.put("order_souces", ConstantHolder.ORDER_BOSS);
					params.put("order_status", orderStatus);
					params.put("order_id", xxjOrder.getOrder_id());
					String sql = "update xxj_order set oper_productStatus=:oper_productStatus,order_souces=:order_souces,order_status=:order_status where order_id=:order_id";
					executeBySql(sql,params);
				}
			}
			//产品过期(针对学习佳系统，不在有效期内即为过期)
			params.clear();
			params.put("platformId", platformId);
			params.put("userId", userId);
			params.put("offerId", offerId);
			hql = "from XxjOrder WHERE platformId=:platformId AND user_id =:userId AND oper_offerId=:offerId AND NOW() NOT BETWEEN effective AND expires";
			List<XxjOrder> order_list4 = find(hql,params);
			if(CollectionUtils.isNotEmpty(order_list4)){
				log.info("过期产品");
				order_list4.forEach(xxjOrder->{
					params.clear();
					params.put("order_status", ConstantHolder.ORDER_EXPRIES);
					params.put("order_id", xxjOrder.getOrder_id());
					String sql = "update xxj_order set order_status =:order_status where order_id =:order_id";
					int num = executeBySql(sql, params);
					log.info("更新订单信息结果：{}",num>0?"success":"fail");
				});
			}
		}
		//产品过期(针对Boss系统，不存在即为过期)
		params.clear();
		params.put("platformId", platformId);
		params.put("userId", userId);
		hql = "select new XxjOrder(oper_offerId) from XxjOrder WHERE platformId=:platformId AND user_id =:userId";
		List<XxjOrder> order_list = find(hql,params);
		List<XxjOrder> xxjOrdersDifferent = GuavaUtil.getListDifferent(order_list, preparedProductList);//差集
		if(CollectionUtils.isNotEmpty(xxjOrdersDifferent)){
			JDBCBatchUpdate(xxjOrdersDifferent);
		}
	}
	
	/**
	 * 订购成功后将订单信息更新至本地
	 * @see com.uflowertv.service.XxjOrderServiceI#updateUserPurchaseProduction(String, String)
	 */
	@Override
	public XxjOrder updateUserPurchaseProduction(String card,String orderId) {
		log.info("订购成功后将订单信息更新至本地");
		Map<String, Object> params = Maps.newHashMap();
		checkArgument(StringUtils.isNotBlank(card),"卡号为空");
		checkArgument(StringUtils.isNotBlank(orderId),"订单ID为空");
		String queryType = ConstantHolder.QUERY_TYPE;//智能卡号类型
		//获取用户ID
		String url = String.format(ConstantHolder.USER_INFO_URL, card,queryType);
		String json = HttpClientUtils.get(url);
		GetUserInfoDTO getUserInfo = JsonUtils.json2Bean(json, GetUserInfoDTO.class);
		// 获取用户所有已订购所有套餐ID列表
		List<ProductOrderDTO> productOrderList = getUserInfo.getCustInfo().getUserList().get(0).getProductOrderList();
		checkArgument(!CollectionUtils.isEmpty(productOrderList),"用户无订购任何产品");
		ArrayList<OfferIdCompared> oper_combo = Lists.newArrayList();
		String intOrderId = orderId.substring(6);
		//获取订单信息 
		XxjOrder xxjOrder = getById(Integer.valueOf(intOrderId));
		int userId = xxjOrder.getUser_id();
		String comboId = xxjOrder.getOper_comboId();
		String offerId = xxjOrder.getOper_offerId();
		
		productOrderList.forEach(productOrder -> {
			boolean equals = StringUtils.equals(productOrder.getOfferId(), offerId);
			if(equals){
				ProductDTO product = productOrder.getProductLs().get(0);
				OfferIdCompared offerIdCompared = new OfferIdCompared(productOrder.getOfferId(), productOrder.getOfferName(),
												  product.getExpireDate(), product.getProductId(), product.getProductName(), product.getStatus(),
												  product.getValidDate());
				oper_combo.add(offerIdCompared);
			}
		});
		//学习佳产品列表
		checkArgument(!CollectionUtils.isEmpty(oper_combo),"该用户没有购买学习佳产品");
		OfferIdCompared product = oper_combo.get(0);
		DateTime dateTime = DateTimeUtil.transStringToDateTime(product.getValidDate());
		String operOrderId = new DateTime(dateTime.toDate()).toString("yyyyMMddHHmmss") +userId;
		String offerName = product.getOfferName();//运营商套餐名称
		String operProductId = product.getProductId();//运营商产品ID
		String operProductName = product.getProductName();//运营商产品名称
		//通过套餐ID查询出订价信息
		params.put("comboId", comboId);
		String hql = "from XxjRated where combo_id=:comboId";
		XxjRated xxjRated = xxjRatedService.getByHql(hql,params);
		int productId = xxjRated.getProduct_id();//学习佳产品ID
		String showPrice = xxjRated.getShow_price();//学习佳套餐价格
		int buyType = xxjRated.getProduct_type();//学习佳购买类型
		// 通过产品ID查询出产品名称
		XxjProduct xxjProduct = xxjProductionService.getById(productId);
		checkNotNull(xxjProduct,"找不到产品信息");
		String productName = xxjProduct.getProduct_name();//学习佳产品名称
		Date effective = DateTimeUtil.transStringToDate(product.getValidDate());
		Date expires = null;
		// 1:包月2:半年3:全年0:指定日期
		switch (buyType) {
		case 0:
			expires = dateTime.plusDays(xxjProduct.getBuy_days()).toDate();
			break;
		case 1:
			expires = dateTime.plusMonths(1).toDate();
			break;
		case 2:
			expires = dateTime.plusMonths(6).toDate();
			break;
		case 3:
			expires = dateTime.plusYears(1).toDate();
			break;
		default:
			break;
		}
		int operProductStatus = Integer.valueOf(product.getProductStatus());
		//根据产品状态更新订单状态
		int orderStatus = 0;
		switch (operProductStatus) {
		case 0:
			orderStatus = ConstantHolder.ORDER_SUCCESS;
			break;
		case 1:
			orderStatus = ConstantHolder.ORDER_OUT_OF_SERVER;
			break;
		default:
			break;
		}
		params.clear();
		params.put("order_id", xxjOrder.getOrder_id());
		params.put("oper_offerId", offerId);
		params.put("oper_offerName", offerName);
		params.put("oper_productId", operProductId);
		params.put("oper_productName", operProductName);
		params.put("oper_productStatus", operProductStatus);
		params.put("oper_orderId", operOrderId);
		params.put("product_id", productId);
		params.put("product_name", productName);
		params.put("order_souces", ConstantHolder.ORDER_BOSS);
		params.put("order_price", showPrice);
		params.put("order_status", orderStatus);
		params.put("buy_type", buyType);
		params.put("effective", effective);
		params.put("expires", expires);
		String sql = "update xxj_order set oper_offerId=:oper_offerId,oper_offerName=:oper_offerName"
					+ ",oper_productId=:oper_productId,oper_productName=:oper_productName"
					+ ",oper_productStatus=:oper_productStatus,oper_orderId=:oper_orderId"
					+ ",product_id=:product_id,product_name=:product_name,order_souces=:order_souces"
					+ ",order_price=:order_price,order_status=:order_status,buy_type=:buy_type"
					+ ",effective=:effective,expires=:expires where order_id=:order_id";
		executeBySql(sql, params);
		return getById(xxjOrder.getOrder_id());
	}
	
	@Override
	public int executeBySql(String sql, Map<String, Object> params) {
		return xxjOrderDao.executeSql(sql, params);
	}
	
	@Override
	public int insertOrder(XxjOrder xxjOrder){
		return (int) xxjOrderDao.save(xxjOrder);
	}
	
	@Override
	public XxjOrder getById(int id){
		return xxjOrderDao.getById(XxjOrder.class, id);
	}
	
	@Override
	public List<XxjOrder> find(String hql,Map<String, Object> params){
		return xxjOrderDao.find(hql,params);
	}
	/**
	 * 批量更新过期产品
	 */
	private void JDBCBatchUpdate(List<XxjOrder> xxjOrdersDifferent) {
		log.info("过期产品批量更新开始");
		Connection conn = DataBaseUtil.getConnection();
		PreparedStatement stmt = null;
		int[] result = null;
		try {
			conn.setAutoCommit(false);
			String sql = "update xxj_order set order_status = ? where order_id = ?";
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			for (XxjOrder xxjOrder : xxjOrdersDifferent) {
				stmt.setInt(1, ConstantHolder.ORDER_EXPRIES);
				stmt.setInt(2, xxjOrder.getOrder_id());
				stmt.addBatch();
			}
			result = stmt.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConnStmtRs(conn, stmt, null);
		}
		log.info("受影响行数：" + result.length);
	}
}

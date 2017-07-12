package com.uflowertv.service.impl;

import com.crunii.ccn.ectchannel.server.webservice.impl.ComboOrderInfo;
import com.crunii.ccn.ectchannel.server.webservice.impl.ComboValidInfo;
import com.google.common.collect.Maps;
import com.uflowertv.dao.XxjOrderDaoI;
import com.uflowertv.dao.XxjRatedDaoI;
import com.uflowertv.model.dto.GetUserInfoDTO;
import com.uflowertv.model.dto.ProductDTO;
import com.uflowertv.model.dto.ProductOrderDTO;
import com.uflowertv.model.dto.UserDTO;
import com.uflowertv.model.po.XxjOrder;
import com.uflowertv.model.po.XxjProduct;
import com.uflowertv.model.po.XxjRated;
import com.uflowertv.model.po.XxjUser;
import com.uflowertv.service.BossServiceI;
import com.uflowertv.service.XxjOrderServiceI;
import com.uflowertv.service.XxjProductionServiceI;
import com.uflowertv.service.XxjUserServiceI;
import com.util.MD5Util;
import com.util.OrderNo;
import com.util.StringEcodingUtil;
import com.util.commons.ConstantHolder;
import com.util.connection.HttpClientUtils;
import com.util.date.DateTimeUtil;
import com.util.json.JsonUtils;
import jersey.repackaged.com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	private XxjRatedDaoI xxjRatedDao;
	@Autowired
	private XxjProductionServiceI xxjProductionService;
	@Autowired
	private BossServiceI bossService;
		
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
     * 订购套餐
     * @throws InterruptedException 
     */
    @Override
    public void executePurchaseCombo(String orderId){
    	log.info(".......................支付成功，开始订购.......................");
        XxjOrder xxjOrder = getById(Integer.valueOf(orderId));
        Integer user_id = xxjOrder.getUser_id();
        XxjUser xxjUser =  xxjUserService.getById(user_id);
        String card = xxjUser.getCard();
        String comboId = xxjOrder.getOper_comboId();
        String channelCode = ConstantHolder.CHANNEL_CODE;
        log.info(".....................套餐校验开始.....................");
        ComboValidInfo comboValidInfo = bossService.intfComboValid(card, comboId, channelCode);
        String code = comboValidInfo.getCode();
        if (StringUtils.equals(code,"200")){
            log.info(".....................套餐校验成功.....................");
            ComboOrderInfo comboOrderInfo = bossService.intfComboOrder(card, comboId, channelCode, comboValidInfo.getIntfSeq());
            code = comboOrderInfo.getCode();
            log.info(".....................套餐订购开始.....................");
            if (StringUtils.equals(code,"200")){
            	log.info(".....................套餐订购结束.....................");
            }
        }
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
		String sql = "update xxj_order set serial_number=:serial_number,pay_desc=:pay_desc,order_status=:order_status,pay_type=:pay_type,gmt_modified=:modify where order_id=:order_id";
		params.put("serial_number", paySeq);
		params.put("pay_desc", payDesc);
		params.put("order_status", Integer.valueOf(payState));
		params.put("pay_type", payType);
		params.put("order_id", Integer.valueOf(orderId));
		params.put("modify", new Date());
		int num = executeBySql(sql, params);
		log.info("支付订单回调:{}",num>0?"success":"fail");
		if(StringUtils.equals(payState,"1")){
			executePurchaseCombo(orderId);
		}
	}
	
	/**
	 *  用户已购买产品
	 */
	@Override
	public void updateUserPurchaseProduction(int userId) {
		log.info("开始与Boss接口进行用户产品列表同步");
		Map<String, Object> params = Maps.newHashMap();
		checkArgument(userId!=0,"用户ID为空");
		//获取用户ID前先获取用户已购买产品
		XxjUser xxjUser = xxjUserService.getById(userId);
		checkNotNull(xxjUser,"用户不存在");
		String card = xxjUser.getCard();
		int platformId = xxjUser.getPlatformId();
		//获取用户ID
		String url = String.format(ConstantHolder.USER_INFO_URL, card);
 		String json = HttpClientUtils.get(url);
		GetUserInfoDTO getUserInfo = JsonUtils.json2Bean(json, GetUserInfoDTO.class);
//		GetUserInfoDTO getUserInfo = JsonUtils.json2Bean(json(), GetUserInfoDTO.class);
		checkNotNull(getUserInfo,"系统繁忙，请稍候再试！");
		// 获取用户所有已订购所有套餐ID列表
		UserDTO userDTO = getUserInfo.getCustInfo().getUserList().get(0);
		List<ProductOrderDTO> productOrderList = userDTO.getProductOrderList();
		checkArgument(!CollectionUtils.isEmpty(productOrderList),"用户无订购任何产品");
		ArrayList<XxjOrder> compareable = Lists.newArrayList();
		for (ProductOrderDTO productOrderDTO : productOrderList) {
			String offerId = productOrderDTO.getOfferId();
			// 获取用户所有学习佳套餐ID列表
			String hql = "from XxjRated WHERE offer_id =:offerId";
			params.clear();
			params.put("offerId", offerId);
			//订价信息
			XxjRated xxjRated = xxjRatedDao.getByHql(hql,params);
			if(xxjRated != null){
				compareable.add(new XxjOrder(offerId));
				String oper_comboId = xxjRated.getCombo_id();
				int productId = xxjRated.getProduct_id();//学习佳产品ID
				String showPrice = xxjRated.getShow_price();//学习佳套餐价格
				int buyType = xxjRated.getProduct_type();//学习佳购买类型
				
				//运营商产品信息
				ProductDTO product = productOrderDTO.getProductLs().get(1);
				DateTime dateTime = DateTimeUtil.transStringToDateTime(product.getValidDate());
				String operOrderId = OrderNo.makeOrderNum(new Date());
				String offerName = productOrderDTO.getOfferName();//运营商套餐名称
				String operProductId = product.getProductId();//运营商产品ID
				String operProductName = product.getProductName();//运营商产品名称
				int operProductStatus = Integer.valueOf(product.getStatus());//运营商订单状态
				//根据产品状态更新订单状态
				int orderStatus = getStatus(operProductStatus);
				
				//产品信息
				XxjProduct xxjProduct = xxjProductionService.getById(productId);
				checkNotNull(xxjProduct,"找不到产品信息");
				String productName = xxjProduct.getProduct_name();//学习佳产品名称
				Date effective = DateTimeUtil.transStringToDate(product.getValidDate());
				Date expires = getExpiresDay(dateTime,buyType,xxjProduct.getBuy_days());
				//订单信息
				hql = "from XxjOrder where user_id=:userId and oper_offerId=:offerId";
				params.clear();
				params.put("userId", userId);
				params.put("offerId", offerId);
				XxjOrder xxjOrder = xxjOrderDao.getByHql(hql, params);
				if(xxjOrder == null){
					log.info("============================营业厅订购开始============================");
					// 1、营业厅订购(添加所有字段,除去支付字段)
					insertOrder(new XxjOrder(platformId, userId, oper_comboId,offerId, offerName,
								operProductId, operProductName, operProductStatus, operOrderId,
								productId, productName, ConstantHolder.ORDER_OTHER,
								showPrice,orderStatus,buyType, effective, expires,new Date(),new Date()));
					log.info("============================营业厅订购完成============================");
				}else{
					String oper_productId = xxjOrder.getOper_productId();
					/*String oper_offerId = xxjOrder.getOper_offerId();
					Integer order_status = xxjOrder.getOrder_status();
					Integer order_id = xxjOrder.getOrder_id();
					boolean equals = StringUtils.equals(oper_offerId, offerId);
					//支付成功，未订购成功处理。
					if(equals && StringUtils.isBlank(oper_productId) && order_status == 1){
						updateUserPurchaseProduction(card, String.valueOf(order_id));
					}else{
						log.info("更新产品状态");
						xxjOrder.setOper_productStatus(operProductStatus);
						xxjOrder.setOrder_status(orderStatus);
						xxjOrderDao.update(xxjOrder);
					}*/
					log.info("更新产品状态");
					xxjOrder.setOper_productStatus(operProductStatus);
					xxjOrder.setOrder_status(orderStatus);
					xxjOrderDao.update(xxjOrder);
					params.clear();
					params.put("platformId", platformId);
					params.put("userId", userId);
					params.put("offerId", offerId);
					params.put("oper_productId", oper_productId);
					hql = "from XxjOrder WHERE oper_productId=:oper_productId AND platformId=:platformId AND user_id =:userId AND oper_offerId=:offerId AND NOW() BETWEEN effective AND expires";
					List<XxjOrder> enable_list = find(hql,params);
					if(CollectionUtils.isEmpty(enable_list)){
						log.info("产品续订");
						insertOrder(new XxjOrder(platformId, userId, oper_comboId,offerId, offerName,
									operProductId, operProductName, operProductStatus, operOrderId,
									productId, productName, ConstantHolder.ORDER_BOSS,
									showPrice,orderStatus,buyType, effective, expires,new Date(),new Date()));
					}
				}
			}
			//产品过期(针对学习佳系统，不在有效期内即为过期)
			params.clear();
			params.put("platformId", platformId);
			params.put("userId", userId);
			params.put("offerId", offerId);
			hql = "from XxjOrder WHERE platformId=:platformId AND user_id =:userId AND oper_offerId=:offerId AND NOW() NOT BETWEEN effective AND expires";
			List<XxjOrder> order_list = find(hql,params);
			if(CollectionUtils.isNotEmpty(order_list)){
				log.info("过期产品");
				order_list.forEach(order->{
					order.setOrder_status(ConstantHolder.ORDER_EXPRIES);
					xxjOrderDao.update(order);
				});
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//订单信息
		String hql = "from XxjOrder where user_id=:userId";
		params.clear();
		params.put("userId", userId);
		List<XxjOrder> order_list = xxjOrderDao.find(hql, params);
		if(CollectionUtils.isNotEmpty(order_list)){
			order_list.forEach(obj->{
				String oper_productId = obj.getOper_productId();
				//产品过期(针对Boss系统，不存在即为过期)
				if(StringUtils.isNotBlank(oper_productId) && !compareable.contains(obj)){
					log.info("过期产品");
					obj.setOrder_status(ConstantHolder.ORDER_EXPRIES);
					xxjOrderDao.update(obj);
				}
				//订单无效即为过期
				if(StringUtils.isBlank(oper_productId)){
					log.info("过期产品");
					obj.setOrder_status(ConstantHolder.ORDER_EXPRIES);
					xxjOrderDao.update(obj);
				}
			});
		}
	}
	
	/**
	 * 保存订购信息
	 */
	@Override
	public synchronized int updateUserPurchaseProduction(String card,String orderId) {
		int num = 0;
		log.info("................开始保存产品信息................");
		Map<String, Object> params = Maps.newHashMap();
 		checkArgument(StringUtils.isNotBlank(card),"卡号为空");
 		checkArgument(StringUtils.isNotBlank(orderId),"订单ID为空");
 		//获取订单信息
 		XxjOrder xxjOrder = getById(Integer.valueOf(orderId));
 		//获取用户ID
 		String url = String.format(ConstantHolder.USER_INFO_URL, card);
 		String json = HttpClientUtils.get(url);
 		GetUserInfoDTO getUserInfo = JsonUtils.json2Bean(json, GetUserInfoDTO.class);
 		//GetUserInfoDTO getUserInfo = JsonUtils.json2Bean(json(), GetUserInfoDTO.class);
 		// 获取用户所有已订购所有套餐ID列表
 		UserDTO userDTO = getUserInfo.getCustInfo().getUserList().get(0);
		List<ProductOrderDTO> productOrderList = userDTO.getProductOrderList();
		checkArgument(!CollectionUtils.isEmpty(productOrderList),"用户无订购任何产品");
		//int userId = xxjOrder.getUser_id();
		String offerId = xxjOrder.getOper_offerId();
		for (ProductOrderDTO productOrderDTO : productOrderList) {
			String offerId2 = productOrderDTO.getOfferId();
			boolean equals = StringUtils.equals(offerId2, offerId);
			if(equals){
				ProductDTO product = productOrderDTO.getProductLs().get(1);
				//学习佳产品列表
				DateTime dateTime = DateTimeUtil.transStringToDateTime(product.getValidDate());
				String operOrderId = OrderNo.makeOrderNum(new Date());
				String offerName = productOrderDTO.getOfferName();//运营商套餐名称
				String operProductId = product.getProductId();//运营商产品ID
				String operProductName = product.getProductName();//运营商产品名称
				//通过套餐ID查询出订价信息
				params.clear();
				params.put("offerId", offerId);
				String hql = "from XxjRated where offer_id=:offerId";
				XxjRated xxjRated = xxjRatedDao.getByHql(hql,params);
				int productId = xxjRated.getProduct_id();//学习佳产品ID
				String showPrice = xxjRated.getShow_price();//学习佳套餐价格
				int buyType = xxjRated.getProduct_type();//学习佳购买类型
				// 通过产品ID查询出产品名称
				XxjProduct xxjProduct = xxjProductionService.getById(productId);
				checkNotNull(xxjProduct,"找不到产品信息");
				String productName = xxjProduct.getProduct_name();//学习佳产品名称
				Date effective = DateTimeUtil.transStringToDate(product.getValidDate());
				Date expires = getExpiresDay(dateTime,buyType,xxjProduct.getBuy_days());
				int operProductStatus = Integer.valueOf(product.getStatus());
				//根据产品状态更新订单状态
				int orderStatus = getStatus(operProductStatus);
				params.clear();
				params.put("order_id", Integer.valueOf(orderId));
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
				params.put("modify", new Date());
				String sql = "update xxj_order set oper_offerId=:oper_offerId,oper_offerName=:oper_offerName"
							+ ",oper_productId=:oper_productId,oper_productName=:oper_productName"
							+ ",oper_productStatus=:oper_productStatus,oper_orderId=:oper_orderId"
							+ ",product_id=:product_id,product_name=:product_name,order_souces=:order_souces"
							+ ",order_price=:order_price,order_status=:order_status,buy_type=:buy_type"
							+ ",effective=:effective,expires=:expires,gmt_modified=:modify where order_id=:order_id";
		        num = executeBySql(sql, params);
		        log.info("................保存产品信息结果:{}",num>0?"success":"fail");
			}
		}
 		return num;
	}

	private Date getExpiresDay(DateTime dateTime,int buyType,int buy_days){
		// 1:包月2:半年3:全年0:指定日期
        Date expires = null;
		switch (buyType) {
			case 0:
				expires = dateTime.plusDays(buy_days).toDate();
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
		return expires;
	}

	private int getStatus(int status){
        //根据产品状态更新订单状态
        int orderStatus = 0;
        switch (status) {
            case 0:
                orderStatus = ConstantHolder.ORDER_SUCCESS;
                break;
            case 1:
                orderStatus = ConstantHolder.ORDER_OUT_OF_SERVER;
                break;
            default:
                break;
        }
        return orderStatus;
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
	public Map<String, Object> saveObj(String card,String orderId){
		log.info("...............................card:{}...............................",card);
		log.info("...............................orderId:{}.........................",orderId);
		Map<String, Object> map = Maps.newHashMap();
		orderId = orderId.substring(6);
		int num = updateUserPurchaseProduction(card, orderId);
		if(num > 0){
			XxjOrder xxjOrder = getById(Integer.valueOf(orderId));
			if(StringUtils.isNotBlank(xxjOrder.getOper_productId())){
				map.put("code", 200);
				map.put("message", "订购成功");
				map.put("data", xxjOrder);
				return map;
			}
			map.put("code", 500);
			map.put("message", "查询失败");
			return map;
		}
		map.put("code", 500);
		map.put("message", "查询失败");
		return map;
	}
	
	@Override
	public XxjOrder getById(int id){
		return xxjOrderDao.getById(XxjOrder.class, id);
	}
	
	@Override
	public List<XxjOrder> find(String hql,Map<String, Object> params){
		return xxjOrderDao.find(hql,params);
	}
	
	/*private String json(){
		try {
			StringBuffer sb = new StringBuffer();
			InputStream is = this.getClass().getResourceAsStream("/user_data.json");
			InputStreamReader inputStreamReader = new InputStreamReader(is, "UTF-8");
		    BufferedReader br = new BufferedReader(inputStreamReader);
		    String lineTxt = null;
		    while ((lineTxt = br.readLine()) != null) {
		    	sb.append(lineTxt);
		     }
		    br.close();
		    return sb.toString();
		  } catch (Exception e) {
		    log.error("文件读取错误!");
		    return null;
		 }
	}*/
}

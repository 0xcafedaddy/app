package com.uflowertv.service.impl;

import com.crunii.ccn.ectchannel.server.webservice.impl.ComboOrderInfo;
import com.crunii.ccn.ectchannel.server.webservice.impl.ComboValidInfo;
import com.crunii.ccn.ectchannel.server.webservice.impl.ParentLocker;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.uflowertv.dao.XxjRatedDaoI;
import com.uflowertv.model.dto.CustInfoDTO;
import com.uflowertv.model.dto.GetUserInfoDTO;
import com.uflowertv.model.po.XxjOrder;
import com.uflowertv.model.po.XxjRated;
import com.uflowertv.model.po.XxjUser;
import com.uflowertv.service.BossServiceI;
import com.uflowertv.service.ValidateServiceI;
import com.uflowertv.service.XxjOrderServiceI;
import com.uflowertv.service.XxjUserServiceI;
import com.util.commons.ConstantHolder;
import com.util.connection.HttpClientUtils;
import com.util.json.JsonUtils;
import com.util.redis.URLRedisCache;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 
 * 版权所有：2017年3月15日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：校验业务
 * 类名称：com.uflowertv.service.impl.ValidateServiceImpl     
 * 创建人：liguoliang 
 * 创建时间：2017年3月15日 下午1:44:43   
 * 修改人：
 * 修改时间：2017年3月15日 下午1:44:43   
 * 修改备注：   
 * @version   V1.0
 */
@Service("validateService")
public class ValidateServiceImpl implements ValidateServiceI{
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private BossServiceI bossService;
	@Autowired
	private XxjOrderServiceI xxjOrderService;
	@Autowired
	private XxjUserServiceI xxjUserService;
	@Autowired
	private XxjRatedDaoI xxjRatedDao;
	
	/**
	 * 获取家长锁
	 * @Title: getParentLoker
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param card
	 * @return
	 */
	@Override
	public Map<String, Object> getParentLoker(String card){
		log.info("获取家长锁");
		Map<String, Object> map = Maps.newHashMap();
		checkArgument(StringUtils.isNotBlank(card),"卡号为空");
		String channelCode = ConstantHolder.CHANNEL_CODE;
		String queryType = ConstantHolder.QUERY_TYPE;
		String url = String.format(ConstantHolder.USER_INFO_URL, card,queryType);
 		String json = HttpClientUtils.get(url);
 		GetUserInfoDTO getUserInfo = JsonUtils.json2Bean(json, GetUserInfoDTO.class);
 		checkNotNull(getUserInfo,"系统繁忙，请稍候再试！");
		//客户编号
		String custId = getUserInfo.getCustInfo().getCustId();
		//获取家长锁
		ParentLocker parentLocker = bossService.intfParentLocker(channelCode, custId, "1", null, null);
		checkNotNull(parentLocker,"获取家长锁失败");
		map.put("code", parentLocker.getCode());
		map.put("message", parentLocker.getMsg());
		map.put("pwd", Strings.nullToEmpty(parentLocker.getLockerPasswd()));
		return map;
	}
	
	/**
	 * 套餐校验
	 */
	@Override
	public Map<String, Object> executeComboValid(int platformId,String card, String comboId, int comboType) {
		log.info("生成支付接口订单信息");
		Map<String, Object> map = Maps.newHashMap();
		checkArgument(platformId!=0,"平台ID为空");
		checkArgument(StringUtils.isNotBlank(card),"卡号为空");
		checkArgument(StringUtils.isNotBlank(comboId),"套餐ID为空");
		String channelCode = ConstantHolder.CHANNEL_CODE;
		//黑名单
		List<String> blackCards = URLRedisCache.getSort(ConstantHolder.BLACK_CARD);
		boolean contains = blackCards.contains(card);
		if(contains){
		    map.put("code", 500);
	        map.put("message", "您的广电账户已在广电客户黑名单，请拨打 96868 详细咨询!");
			return map;
		}
		map.clear();
		map.put("card", card);
		String hql = "from XxjUser where card=:card";
		XxjUser xxjUser = xxjUserService.getByHql(hql, map);
		checkNotNull(xxjUser,"用户不存在");
		//获取订价信息
		map.clear();
		map.put("comboId", comboId);
		hql = "from XxjRated where combo_id=:comboId";
		XxjRated xxjRated = xxjRatedDao.getByHql(hql, map);
		checkNotNull(xxjRated,"订价信息不存在");
        //1:包月2:半年3:全年0:指定日期'
		String offerId = xxjRated.getOffer_id();
		String rated_price = xxjRated.getRated_price();
        int orderId = getOrderId(platformId,xxjUser.getUser_id(),comboId,offerId);
        
		//验证套餐
		ComboValidInfo comboValidInfo = bossService.intfComboValid(card, comboId, channelCode);
		checkNotNull(comboValidInfo,"系统繁忙，请稍候再试!");
		String code = comboValidInfo.getCode();
		String message = comboValidInfo.getMsg();
		String intfSeq = comboValidInfo.getIntfSeq();
		String orderTplId = comboValidInfo.getOrderTplId();
		String rechargeAccount = comboValidInfo.getRechargeAccount();
		boolean Status200 = StringUtils.equals(code, "200");
		//包月
		if(Status200 && comboType == 1){
			log.info(".....................套餐订购开始.....................");
			ComboOrderInfo comboOrderInfo = bossService.intfComboOrder(card, comboId, channelCode, intfSeq);
			code = comboOrderInfo.getCode();
			message = comboOrderInfo.getMsg();
            if (StringUtils.equals(code,"200")){
            	log.info(".....................套餐订购结束.....................");
            	map.clear();
        		map.put("code", code);
        		map.put("message", message);
        		return map;
            }
        }
		
		//查询用户是否欠费
  		String url = String.format(ConstantHolder.USER_INFO_URL, card);
   		String json = HttpClientUtils.get(url);
  		GetUserInfoDTO getUserInfo = JsonUtils.json2Bean(json, GetUserInfoDTO.class);
  		CustInfoDTO custInfo = getUserInfo.getCustInfo();
  		String oweTotalFee = custInfo.getOweTotalFee();
  		Double valueOf = Double.valueOf(oweTotalFee);
  		Double valueOf2 = Double.valueOf(rated_price);
  		Double total = valueOf + valueOf2;
  		String totalFee = String.valueOf(total);
		map.clear();
		map.put("code", code);
		map.put("message", message);
		map.put("data", new OrderInfo(card, "000000"+orderId, comboId, intfSeq, rated_price,orderTplId,oweTotalFee,totalFee,rechargeAccount));
		return map;
	}

    private int getOrderId(int platformId,int userId,String comboId,String offerId){
        XxjOrder xxjOrder = new XxjOrder();
        xxjOrder.setPlatformId(platformId);
        xxjOrder.setOper_offerId(offerId);
        xxjOrder.setOper_comboId(comboId);
        xxjOrder.setUser_id(userId);
        xxjOrder.setCreated(new Date());
        xxjOrder.setModify(new Date());
        return xxjOrderService.insertOrder(xxjOrder);
    }
}


/**
 * 版权所有：2017年4月13日-油菜花
 * 项目名称：uflowertv_api
 *
 * 类描述：内部类，封装套餐校验成功后返回的信息
 * 类名称：com.uflowertv.service.impl.OrderInfo
 * 创建人：liguoliang
 * 创建时间：2017年4月13日 上午10:58:12
 * 修改人：
 * 修改时间：2017年4月13日 上午10:58:12
 * 修改备注：
 * @version   V1.0
 */
@Data
class OrderInfo{
	private String card;
	private String orderId;
	private String comboId;
	private String comboSeq;
	private String price;
    private String orderTplId;
    private String oweTotalFee;
    private String totalFee;
    private String rechargeAccount;
    
	public OrderInfo(){}

	public OrderInfo(String card, String orderId, String comboId, String comboSeq, String price, String orderTplId,
			String oweTotalFee, String totalFee, String rechargeAccount) {
		super();
		this.card = card;
		this.orderId = orderId;
		this.comboId = comboId;
		this.comboSeq = comboSeq;
		this.price = price;
		this.orderTplId = orderTplId;
		this.oweTotalFee = oweTotalFee;
		this.totalFee = totalFee;
		this.rechargeAccount = rechargeAccount;
	}
	
	
}
package com.uflowertv.service.impl;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crunii.ccn.ectchannel.server.webservice.impl.ComboValidInfo;
import com.crunii.ccn.ectchannel.server.webservice.impl.ParentLocker;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.uflowertv.model.dto.GetUserInfoDTO;
import com.uflowertv.model.po.XxjOrder;
import com.uflowertv.model.po.XxjRated;
import com.uflowertv.model.po.XxjUser;
import com.uflowertv.service.BossServiceI;
import com.uflowertv.service.ValidateServiceI;
import com.uflowertv.service.XxjOrderServiceI;
import com.uflowertv.service.XxjRatedServiceI;
import com.uflowertv.service.XxjUserServiceI;
import com.uflowertv.util.ConstantHolder;
import com.uflowertv.util.HttpClientUtils;
import com.uflowertv.util.JsonUtils;

import lombok.Data;

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
	private XxjRatedServiceI xxjRatedService;
	
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
	public Map<String, Object> intfComboValid(int platformId,String card,String orderId300, String comboId) {
		log.info("生成支付接口订单信息");
		Map<String, Object> map = Maps.newHashMap();
		checkArgument(platformId!=0,"平台ID为空");
		checkArgument(StringUtils.isNotBlank(card),"卡号为空");
		checkArgument(StringUtils.isNotBlank(orderId300),"订单ID为空");
		checkArgument(StringUtils.isNotBlank(comboId),"套餐ID为空");
		String channelCode = ConstantHolder.CHANNEL_CODE;
		//验证套餐
		ComboValidInfo comboValidInfo = bossService.intfComboValid(card, comboId, channelCode);
		checkNotNull(comboValidInfo,"系统繁忙，请稍候再试!");
		String code = comboValidInfo.getCode();
		String message = comboValidInfo.getMsg();
		boolean Status200 = StringUtils.equals(code, "200");
		boolean Status300 = StringUtils.equals(code, "300");
		map.put("card", card);
		String hql = "from XxjUser where card=:card";
		XxjUser xxjUser = xxjUserService.getByHql(hql, map);
		checkNotNull(xxjUser,"用户不存在");
		//获取订价信息
		map.clear();
		map.put("comboId", comboId);
		hql = "from XxjRated where combo_id=:comboId";
		XxjRated xxjRated = xxjRatedService.getByHql(hql, map);
		checkNotNull(xxjRated,"订价信息不存在");
		//如果校验成功并且订单ID不为空，说明该订单已经支付成功，直接将信息返回
		if(Status200 && StringUtils.isNotBlank(orderId300)){
			map.clear();
			map.put("code", code);
			map.put("message", message);
			map.put("data", new OrderInfo(card, orderId300, comboId, comboValidInfo.getIntfSeq(), xxjRated.getRated_price()));
			return map;
		}
		//200：校验成功后生成订单信息，等待订购。300：生成订单，等待下次校验
		if(Status200 || Status300){
			XxjOrder xxjOrder = new XxjOrder();
			xxjOrder.setPlatformId(platformId);
			xxjOrder.setUser_id(xxjUser.getUser_id());
			xxjOrder.setOper_comboId(comboId);
			int orderId200 = xxjOrderService.insertOrder(xxjOrder);
			map.clear();
			map.put("code", code);
			map.put("message", message);
			map.put("data", new OrderInfo(card, "000000"+orderId200, comboId, comboValidInfo.getIntfSeq(), xxjRated.getRated_price()));
			return map;
		}
		map.clear();
		map.put("code", code);
		map.put("message", message);
		return map;
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
		public OrderInfo(){}
		public OrderInfo(String card, String orderId, String comboId, String comboSeq, String price) {
			super();
			this.card = card;
			this.orderId = orderId;
			this.comboId = comboId;
			this.comboSeq = comboSeq;
			this.price = price;
		}
	}
}

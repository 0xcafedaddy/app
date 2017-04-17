package com.uflowertv.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uflowertv.dao.PhoneCodeMapper;
import com.uflowertv.model.PhoneCode;
/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：wxpublic   
 *
 * 类描述：
 * 类名称：com.uflowertv.service.PhoneCodeService     
 * 创建人：liguoliang 
 * 创建时间：2016年9月18日 下午12:28:30   
 * 修改人：
 * 修改时间：2016年9月18日 下午12:28:30   
 * 修改备注：   
 * @version   V1.0
 */
@Service
public class PhoneCodeService {
	private transient final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private PhoneCodeMapper phoneCodeMapper;
	
	/**
	 * 
	 * @Title: getPhoneCode
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param phone
	 * @return
	 */
	public PhoneCode getPhoneCode(String phone){
		log.info("查询手机号");
		return phoneCodeMapper.selectByPrimaryKey(phone);
	}
	public void save(PhoneCode phoneCode){
		log.info("保存手机号");
		phoneCodeMapper.insert(phoneCode);
	}
	public void update(PhoneCode phoneCode){
		log.info("更新手机号");
		phoneCodeMapper.updateByPrimaryKey(phoneCode);
	}
}

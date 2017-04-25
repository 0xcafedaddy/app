package com.uflowertv.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uflowertv.dao.XxjRatedDaoI;
import com.uflowertv.model.po.XxjRated;
import com.uflowertv.service.XxjRatedServiceI;

/**
 * 
 * 版权所有：2017年4月1日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：
 * 类名称：com.uflowertv.service.impl.XxjRatedServiceImpl     
 * 创建人：liguoliang 
 * 创建时间：2017年4月1日 下午1:26:36   
 * 修改人：
 * 修改时间：2017年4月1日 下午1:26:36   
 * 修改备注：   
 * @version   V1.0
 */
@Service("xxjRatedService")
public class XxjRatedServiceImpl implements XxjRatedServiceI{

	@Autowired
	public XxjRatedDaoI xxjRatedDao;
	
	@Override
	public XxjRated getByHql(String hql,Map<String,Object> params){
		return xxjRatedDao.getByHql(hql,params);
	}

	@Override
	public List<XxjRated> find(String hql) {
		return xxjRatedDao.find(hql);
	}
}

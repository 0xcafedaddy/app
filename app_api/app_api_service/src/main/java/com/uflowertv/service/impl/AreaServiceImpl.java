package com.uflowertv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uflowertv.dao.AreaDaoI;
import com.uflowertv.model.po.TbProvCityAreaStreet;
import com.uflowertv.service.AreaServiceI;

/**
 * 
 * 版权所有：2017年3月8日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：省、市、区、镇四级联动
 * 类名称：com.uflowertv.service.impl.AreaServiceImpl     
 * 创建人：liguoliang 
 * 创建时间：2017年3月8日 下午6:01:05   
 * 修改人：
 * 修改时间：2017年3月8日 下午6:01:05   
 * 修改备注：   
 * @version   V1.0
 */
@Service("areaService")
public class AreaServiceImpl implements AreaServiceI{

	@Autowired
	private AreaDaoI areaDao;
	
	@Override
	public List<TbProvCityAreaStreet> getProvinces() {
		return areaDao.getProvinces();
	}

	@Override
	public List<TbProvCityAreaStreet> getNodes(int pid) {
		return areaDao.getNodes(pid);
	}
}

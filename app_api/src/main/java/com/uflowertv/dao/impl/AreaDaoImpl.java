package com.uflowertv.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.google.common.collect.Maps;
import com.uflowertv.dao.AreaDaoI;
import com.uflowertv.model.po.TbProvCityAreaStreet;
@Repository("areaDao")
public class AreaDaoImpl extends XxjBaseDaoImpl<TbProvCityAreaStreet> implements AreaDaoI{

	@Override
	public List<TbProvCityAreaStreet> getProvinces() {
		return find("from TbProvCityAreaStreet where pid = 0");
	}

	@Override
	public List<TbProvCityAreaStreet> getNodes(int pid) {
		Map<String, Object> params = Maps.newHashMap();
		params.put("pid", pid);
		String hql = "from TbProvCityAreaStreet where pid =:pid";
	    return find(hql,params);
	}
}

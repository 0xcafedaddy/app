package com.uflowertv.dao;

import java.util.List;

import com.uflowertv.model.po.TbProvCityAreaStreet;


public interface AreaDaoI {

	//省市县区四级联动
	List<TbProvCityAreaStreet> getProvinces();
	
	List<TbProvCityAreaStreet> getNodes(int pid);
	
}

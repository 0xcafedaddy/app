package com.uflowertv.dao;

import com.uflowertv.model.po.TbProvCityAreaStreet;

import java.util.List;


public interface AreaDaoI {

    //省市县区四级联动
    List<TbProvCityAreaStreet> getProvinces();

    List<TbProvCityAreaStreet> getNodes(int pid);

}

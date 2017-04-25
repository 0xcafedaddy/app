package com.uflowertv.service;

import java.util.List;
import java.util.Map;

import com.uflowertv.model.po.XxjRated;

public interface XxjRatedServiceI {

	XxjRated getByHql(String hql, Map<String, Object> params);

	List<XxjRated> find(String hql);

}

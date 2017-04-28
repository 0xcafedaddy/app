package com.jpa.demo.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.Repository;

import com.jpa.demo.entity.XxjHome;

public interface XxjHomeRepository extends Repository<XxjHome,Serializable>{
	//查询全部对象信息
	List<XxjHome> findAll();
	//根据ID获取对象信息
	XxjHome findByHomeId(Integer homeId);
	//
}
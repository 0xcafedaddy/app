package com.jpa.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.demo.dao.XxjHomeRepository;
import com.jpa.demo.entity.XxjHome;
@Service
public class XxjHomeService {

	@Autowired
	private XxjHomeRepository xxjHomeDao;
	
	public XxjHome findByHomeId(int homeId) {
		return xxjHomeDao.findByHomeId(homeId);
	}

	public List<XxjHome> findAll() {
		return xxjHomeDao.findAll();
	}
}

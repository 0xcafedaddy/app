package com.uflowertv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uflowertv.dao.impl.TestDao;
import com.uflowertv.exception.BusinessException;
import com.uflowertv.exception.ParameterException;
import com.uflowertv.service.TestService;

/**
 * 
 * 版权所有：2017年3月9日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：业务异常测试
 * 类名称：com.uflowertv.service.impl.TestServiceImpl     
 * 创建人：liguoliang 
 * 创建时间：2017年3月9日 下午3:51:52   
 * 修改人：
 * 修改时间：2017年3月9日 下午3:51:52   
 * 修改备注：   
 * @version   V1.0
 */
@Service("testService")
public class TestServiceImpl implements TestService {
	@Autowired
	private TestDao testDao;
	
	public void exception(Integer id) throws Exception {
		switch(id) {
		case 1:
			throw new BusinessException("11", "service11");
		case 2:
			throw new BusinessException("21", "service21");
		case 3:
			throw new BusinessException("31", "service31");
		case 4:
			throw new BusinessException("41", "service41");
		case 5:
			throw new BusinessException("51", "service51");
		default:
			throw new ParameterException("Service Parameter Error");
		}
	}

	@Override
	public void dao(Integer id) throws Exception {
		testDao.exception(id);
	}
}

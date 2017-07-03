package com.uflowertv.service.impl;

import org.springframework.scheduling.annotation.Scheduled;

import com.uflowertv.service.RedisTaskServiceI;

/**
 * 
 * 版权所有：2017年3月8日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：Spring定时任务
 * 类名称：com.uflowertv.service.impl.RedisTaskServicImpl     
 * 创建人：liguoliang 
 * 创建时间：2017年3月8日 下午6:41:51   
 * 修改人：
 * 修改时间：2017年3月8日 下午6:41:51   
 * 修改备注：   
 * @version   V1.0
 */
//@Service
public class RedisTaskServicImpl implements RedisTaskServiceI{
	@Scheduled(cron="0 0 0 10 * ?") //每月的10号
	@Override
	public void clearRedis() {
		//URLRedisCache.clear();
	}
}

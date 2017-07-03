package com.uflowertv.dao;

import java.util.List;

import com.uflowertv.model.vo.CommonsEntityJson;

/**
 * 
 * 版权所有：2016年11月1日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：
 * 类名称：com.uflowertv.dao.XuedDAO     
 * 创建人：liguoliang 
 * 创建时间：2016年11月1日 下午5:23:08   
 * 修改人：
 * 修改时间：2016年11月1日 下午5:23:08   
 * 修改备注：   
 * @version   V1.0
 */
public interface RedisCommonsDaoI {
	List<CommonsEntityJson> getCommonsList(String listKey);
	CommonsEntityJson getCommonsDetail(String listKey);
}

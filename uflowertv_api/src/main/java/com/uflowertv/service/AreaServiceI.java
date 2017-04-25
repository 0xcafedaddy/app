package com.uflowertv.service;

import java.util.List;

import com.uflowertv.model.po.TbProvCityAreaStreet;

/**
 * 
 * 版权所有：2017年3月9日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：省、市、区、镇四级联动
 * 类名称：com.uflowertv.service.AreaServiceI     
 * 创建人：liguoliang 
 * 创建时间：2017年3月9日 下午4:29:48   
 * 修改人：
 * 修改时间：2017年3月9日 下午4:29:48   
 * 修改备注：   
 * @version   V1.0
 */
public interface AreaServiceI {

	/**
	 * 省列表
	 * @Title: getProvinces
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 */
	List<TbProvCityAreaStreet> getProvinces();
	/**
	 * 省的子孙节点列表
	 * @Title: getNodes
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param pid
	 * @return
	 */
	List<TbProvCityAreaStreet> getNodes(int pid);
}

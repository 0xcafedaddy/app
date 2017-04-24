package com.uflowertv.service;

import com.baomidou.framework.annotations.Log;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Maps;
import com.uflowertv.dao.CommonQuestionMapper;
import com.uflowertv.model.po.CommonQuestion;
import com.uflowertv.service.support.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：wxpublic   
 *
 * 类描述：
 * 类名称：com.uflowertv.service.CommonQuestionService     
 * 创建人：liguoliang 
 * 创建时间：2016年9月8日 下午4:16:54   
 * 修改人：
 * 修改时间：2016年9月8日 下午4:16:54   
 * 修改备注：   
 * @version   V1.0
 */
@Service
public class CommonQuestionService extends BaseServiceImpl<CommonQuestionMapper,CommonQuestion>{
	/**
	 * 常见问题列表
	 * @Title: list
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param page
	 * @param rows
	 * @return
	 */
	@Log("常见问题列表")
	public Map<String,Object> list(int page,int rows,CommonQuestion commonQuestion){
		Map<String,Object> map = Maps.newHashMap();
		EntityWrapper<CommonQuestion> ew = new EntityWrapper<CommonQuestion>();
		Page<CommonQuestion> p = new Page<CommonQuestion>(page,rows,"pid");
		if(StringUtils.isNotBlank(commonQuestion.getQuestionType())){
			ew.like("question_type",commonQuestion.getQuestionType());
		}
		p = selectPage(p, ew);
		List<CommonQuestion> list = p.getRecords();
		int total = p.getTotal();
		map.put("rows", list);
		map.put("total", total);
		return map;
	}

	/**
	 *
	 * @Title: getCommonQuestion
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param id
	 * @return
	 */
	@Log("查询是否存在下级目录")
	public int countByParameter(int id) {
		return baseMapper.countByParameter(id);
	}

	/**
	 *
	 * @Title: selectByString
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param id
	 * @return
	 */
	@Log("查询子级问题集")
	public List<CommonQuestion> selectByString(int id){
		return baseMapper.selectByString(id);
	}


	/**
	 *
	 * @Title: batchUpdateCommonQuestion
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param record
	 * @return
	 */
	@Log("批量更新子级问题")
	public int updateBatchCommonQuestion(List<CommonQuestion> record){
		return baseMapper.batchUpdateCommonQuestion(record);
	}
}

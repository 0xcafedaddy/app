package com.uflowertv.wechat.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Maps;
import com.uflowertv.wechat.mapper.CommonQuestionMapper;
import com.uflowertv.wechat.model.CommonQuestion;
import com.uflowertv.wechat.service.support.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：wxpublic   
 *
 * 类描述：
 * 类名称：CommonQuestionService
 * 创建人：liguoliang 
 * 创建时间：2016年9月8日 下午4:16:54   
 * 修改人：
 * 修改时间：2016年9月8日 下午4:16:54   
 * 修改备注：   
 * @version   V1.0
 */
@Service
public class CommonQuestionService extends BaseServiceImpl<CommonQuestionMapper,CommonQuestion> {
	private Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * 常见问题列表
	 * @Title: list
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String,Object> list(int page,int rows,CommonQuestion commonQuestion){
		log.info("常见问题列表");
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
	public int countByParameter(int id) {
		log.info("查询是否存在下级目录");
		return baseMapper.countByParameter(id);
	}

	/**
	 *
	 * @Title: selectByString
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param id
	 * @return
	 */
	public List<CommonQuestion> selectByString(int id){
		log.info("查询子级问题集");
		return baseMapper.selectByString(id);
	}


	/**
	 *
	 * @Title: batchUpdateCommonQuestion
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param record
	 * @return
	 */
	public int updateBatchCommonQuestion(List<CommonQuestion> record){
		log.info("批量更新子级问题");
		return baseMapper.batchUpdateCommonQuestion(record);
	}
}

package com.uflowertv.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.uflowertv.commons.BaseService;
import com.uflowertv.dao.CommonQuestionMapper;
import com.uflowertv.model.CommonQuestion;
import com.uflowertv.model.CommonQuestionExample;
import com.uflowertv.model.CommonQuestionExample.Criteria;
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
public class CommonQuestionService extends BaseService{

	@Autowired
	private CommonQuestionMapper commonQuestionMapper;
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
		PageHelper.startPage(page, rows);
		Map<String,Object> map = new HashMap<String,Object>();
		CommonQuestionExample example = new CommonQuestionExample();
		example.setOrderByClause("pid");
		Criteria criteria = example.createCriteria().andIdIsNotNull();
		if(StringUtils.isNotBlank(commonQuestion.getQuestionType())){
			criteria.andQuestionTypeLike("%"+commonQuestion.getQuestionType()+"%");
		}
		List<CommonQuestion> list = commonQuestionMapper.selectByExample(example);
		int count = commonQuestionMapper.countByExample(example);
		map.put("rows", list);
		map.put("total", count);
		return map;
	}
	
	/**
	 * 获取单个问题
	 * @Title: getCommonQuestion
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param id
	 * @return
	 */
	public CommonQuestion getCommonQuestion (int id){
		log.info("获取单个问题");
		return commonQuestionMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 初始化消息
	 * @Title: queryFrist
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 */
	public List<CommonQuestion> queryFrist(){
		CommonQuestionExample example = new CommonQuestionExample();
		example.createCriteria().andPidEqualTo(0);
		return commonQuestionMapper.selectByExample(example);
	}
	
	/**
	 * 获取常见问题列表
	 * @Title: getCommonQuestions
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 */
	public List<CommonQuestion> getCommonQuestions() {
		log.info("获取常见问题列表");
		CommonQuestionExample example = new CommonQuestionExample();
		example.createCriteria().andIdIsNotNull();
		return commonQuestionMapper.selectByExample(example);

		
	}
	/**
	 * 
	 * @Title: saveCommonQuestion
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param commonQuestion
	 * @return
	 */
	public int saveCommonQuestion(CommonQuestion commonQuestion) {
		log.info("保存问题");
		return commonQuestionMapper.insert(commonQuestion);
	}
	
	/**
	 * 
	 * @Title: updateCommonQuestion
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param commonQuestion
	 * @return
	 */
	public int updateCommonQuestion(CommonQuestion commonQuestion) {
		log.info("更新问题");
		return commonQuestionMapper.updateByPrimaryKey(commonQuestion);
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
		return commonQuestionMapper.countByParameter(id);
	}
	
	/**
	 * 
	 * @Title: delCommonQuestion
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param id
	 * @return
	 */
	public int delCommonQuestion(int id) {
		log.info("删除问题");
		return commonQuestionMapper.deleteByPrimaryKey(id);
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
		return commonQuestionMapper.selectByString(id);
	}
	
	/**
	 * 查询是否是根节点
	 * @Title: selectRootNodes
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param id
	 * @return
	 */
	public List<CommonQuestion> selectRootNodes(int id){
		log.info("查询是否是根节点");
		CommonQuestionExample example = new CommonQuestionExample();
		example.createCriteria().andIdEqualTo(id).andPidEqualTo(0);
		return commonQuestionMapper.selectByExample(example);
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
		return commonQuestionMapper.batchUpdateCommonQuestion(record);
	}
}

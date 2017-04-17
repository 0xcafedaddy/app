package com.uflowertv.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.uflowertv.dao.QuestionMapper;
import com.uflowertv.dao.UserMapper;
import com.uflowertv.model.QuestionExample;
import com.uflowertv.model.QuestionExample.Criteria;
import com.uflowertv.model.QuestionWithBLOBs;
import com.uflowertv.model.User;


/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：Weixin   
 *
 * 类描述：问题反馈业务功能
 * 类名称：com.uflowertv.Question.service.QuestionService     
 * 创建人：liguoliang 
 * 创建时间：2016年8月19日 下午3:28:21   
 * 修改人：
 * 修改时间：2016年8月19日 下午3:28:21   
 * 修改备注：   
 * @version   V1.0
 */
@Service
public class QuestionService{
	private transient final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 保存消息
	 * @Title: saveQuestion
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param bloBs
	 * @return
	 */
	public int saveQuestion(QuestionWithBLOBs bloBs){
		log.info("保存问题反馈");
		return questionMapper.insert(bloBs);
	}
	
	
	/**
	 * 反馈问题列表
	 * @Title: list
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param page
	 * @param rows
	 * @param type
	 * @return
	 */
	public Map<String,Object> list(int page,int rows,int type,QuestionWithBLOBs questionWithBLOBs){
		log.info("反馈问题列表");
		PageHelper.startPage(page, rows);
		Map<String,Object> map = new HashMap<String,Object>();
		QuestionExample example = new QuestionExample();
		example.setOrderByClause("createtime");
		example.setOrderExample("desc");
		Criteria criteria = example.createCriteria().andIdIsNotNull().andStatusEqualTo(type);
		if(StringUtils.isNotBlank(questionWithBLOBs.getWxUserQuestionType())){
			criteria.andWxUserQuestionTypeLike("%"+questionWithBLOBs.getWxUserQuestionType()+"%");
		}
		if(StringUtils.isNotBlank(questionWithBLOBs.getReplyQuestionHuman())){
			criteria.andReplyQuestionHumanLike("%"+questionWithBLOBs.getReplyQuestionHuman()+"%");
		}
		if(StringUtils.isNotBlank(questionWithBLOBs.getCompletetime())){
			criteria.andCompletetimeBetween(questionWithBLOBs.getCompletetime(),questionWithBLOBs.getCreatetime());
		}
		if(StringUtils.isNotBlank(questionWithBLOBs.getWxUserQuestionContent())){
			example.setWxUserQuestionContent(questionWithBLOBs.getWxUserQuestionContent());
		}
		if(StringUtils.isNotBlank(questionWithBLOBs.getReplyQuestionContent())){
			example.setReplyQuestionContent(questionWithBLOBs.getReplyQuestionContent());
		}
		List<QuestionWithBLOBs> list = questionMapper.selectByExampleWithBLOBsByPageHelper(example);
		List<QuestionWithBLOBs> newList = new ArrayList<QuestionWithBLOBs>();
		for (QuestionWithBLOBs questionWithBLOBs2 : list) {
			String subStr1 = questionWithBLOBs2.getWxUserQuestionContent();
			String subStr2 = questionWithBLOBs2.getReplyQuestionContent();
			if(StringUtils.isNotBlank(subStr1)&&subStr1.length()>50){
				subStr1 = subStr1.substring(0, 50)+"……";
				questionWithBLOBs2.setWxUserQuestionContent(subStr1);
			}
			if(StringUtils.isNotBlank(subStr2)&&subStr2.length()>50){
				subStr2 = subStr2.substring(0, 50)+"……";
				questionWithBLOBs2.setReplyQuestionContent(subStr2);
			}
			newList.add(questionWithBLOBs2);
		}
		int count = questionMapper.countByExampleWithBLOBsByPageHelper(example);
		map.put("rows", newList);
		map.put("total", count);
		return map;
	}

	/**
	 * 查看问题
	 * @Title: findById
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param id
	 * @return
	 */
	public QuestionWithBLOBs findById(String id) {
		log.info("查看问题");
		return questionMapper.selectByPrimaryKey(id);
	}

	/**
	 * 回复问题
	 * @Title: updateQuestionWithBLOBs
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param questionWithBLOBs
	 * @return
	 */
	public int updateQuestionWithBLOBs(QuestionWithBLOBs questionWithBLOBs) {
		log.info("回复问题");
		return questionMapper.updateByPrimaryKeySelective(questionWithBLOBs);
	}

	/**
	 * 获取回复人昵称
	 * @Title: findByUserId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param userId
	 * @return
	 */
	public User findByUserId(String userId) {
		log.info("获取回复人");
		return userMapper.selectByPrimaryKey(userId);
	}
}

package com.uflowertv.service;

import com.baomidou.framework.annotations.Log;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.uflowertv.dao.QuestionMapper;
import com.uflowertv.model.po.Question;
import com.uflowertv.service.support.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


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
public class QuestionService extends BaseServiceImpl<QuestionMapper,Question>{

	private EntityWrapper<Question> ew = new EntityWrapper<Question>();
	/**
	 * 反馈问题列表
	 * @Title: list
	 * @param page
	 * @param rows
	 * @param type
	 * @return
	 */
	@Log("反馈问题列表")
	public Map<String,Object> list(int page,int rows,int type,Question question){
		Map<String,Object> map = Maps.newHashMap();
		Page p = new Page<Question>(page,rows,"createtime");
		p.setAsc(false);
		ew.where("status",type);
		if(StringUtils.isNotBlank(question.getWxUserQuestionType())){
			ew.like("wxUserQuestionType",question.getWxUserQuestionType());
		}
		if(StringUtils.isNotBlank(question.getReplyQuestionHuman())){
			ew.like("replyQuestionHuman",question.getReplyQuestionHuman());
		}
		if(StringUtils.isNotBlank(question.getCompletetime())){
			ew.between("completetime",question.getCompletetime(),question.getCreatetime());
		}
		if(StringUtils.isNotBlank(question.getWxUserQuestionContent())){
			ew.eq("wxUserQuestionContent",question.getWxUserQuestionContent());
		}
		if(StringUtils.isNotBlank(question.getReplyQuestionContent())){
			ew.eq("replyQuestionContent",question.getReplyQuestionContent());
		}

		p = selectPage(p, ew);
		List<Question> list = p.getRecords();
		List<Question> newList = Lists.newArrayList();
		for (Question question1 : list) {
			String subStr1 = question1.getWxUserQuestionContent();
			String subStr2 = question1.getReplyQuestionContent();
			if(StringUtils.isNotBlank(subStr1)&&subStr1.length()>50){
				subStr1 = subStr1.substring(0, 50)+"……";
                question1.setWxUserQuestionContent(subStr1);
			}
			if(StringUtils.isNotBlank(subStr2)&&subStr2.length()>50){
				subStr2 = subStr2.substring(0, 50)+"……";
                question1.setReplyQuestionContent(subStr2);
			}
			newList.add(question1);
		}
		int count = p.getTotal();
		map.put("rows", newList);
		map.put("total", count);
		return map;
	}
}
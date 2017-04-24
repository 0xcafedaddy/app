package com.uflowertv.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.collect.Maps;
import com.uflowertv.controller.support.BaseController;
import com.uflowertv.model.po.CommonQuestion;
import com.uflowertv.service.CommonQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：wxpublic   
 *
 * 类描述：
 * 类名称：com.uflowertv.controller.CommonQuestionController     
 * 创建人：liguoliang 
 * 创建时间：2016年9月8日 下午4:30:24   
 * 修改人：
 * 修改时间：2016年9月8日 下午4:30:24   
 * 修改备注：   
 * @version   V1.0
 */
@Controller
@RequestMapping("question")
public class CommonQuestionController extends BaseController{

	
	@Autowired
	private CommonQuestionService commonQuestionService;
	/**
	 * 
	 * @Title: getCommonQuestionList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/getCommonQuestionList")
	@ResponseBody
	public Map<String,Object> getCommonQuestionList(int page,int rows,CommonQuestion commonQuestion){
		return commonQuestionService.list(page, rows,commonQuestion);
	}
	
	/**
	 * 
	 * @Title: getQuestionType
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 */
	@RequestMapping("/getQuestionType")
	@ResponseBody
	public List<CommonQuestion> getQuestionType(){
		return commonQuestionService.selectList(new EntityWrapper<CommonQuestion>());
	}
	
	/**
	 * 
	 * @Title: saveCommonQuestion
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param commonQuestion
	 * @return
	 */
	@RequestMapping("/saveCommonQuestion")
	@ResponseBody
	public Map<String,Object> saveCommonQuestion(CommonQuestion commonQuestion){
		commonQuestion.setId(null);
		Map<String,Object> map = Maps.newHashMap();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		commonQuestion.setCreateTime(sdf.format(new Date()));
		CommonQuestion cq = commonQuestionService.selectById(commonQuestion.getPid());
		if(cq != null){
			cq.setCode(cq.getCode()+1);
			commonQuestionService.updateById(cq);
		}
		commonQuestion.setCode(0);
		boolean insert = commonQuestionService.insert(commonQuestion);
		if(insert){
			map.put("message", "操作成功!");
			return map;
		}
		map.put("message", "操作失败!");
		return map;
	}
	
	/**
	 * 
	 * @Title: updateCommonQuestion
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param commonQuestion
	 * @return
	 */
	@RequestMapping("/updateCommonQuestion")
	@ResponseBody
	public Map<String,Object> updateCommonQuestion(CommonQuestion commonQuestion){
		Map<String,Object> map = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		commonQuestion.setUpdateTime(sdf.format(new Date()));
		List<CommonQuestion> list = commonQuestionService.selectByString(commonQuestion.getId());
		if(list!=null && list.size()>0){
			List<CommonQuestion> list2 = new ArrayList<CommonQuestion>();
			for (CommonQuestion commonQuestion2 : list) {
				commonQuestion2.setP_question(commonQuestion.getQuestion());
				list2.add(commonQuestion2);
			}
			commonQuestionService.updateBatchCommonQuestion(list2);
		}
		commonQuestionService.updateById(commonQuestion);
		map.put("message", "操作成功!");
		return map;
	}
	
	/**
	 * 
	 * @Title: delCommonQuestion
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param id
	 * @return
	 */
	@RequestMapping("/delCommonQuestion")
	@ResponseBody
	public Map<String,Object> delCommonQuestion(int id){
		Map<String,Object> map = new HashMap<String, Object>();
		int count = commonQuestionService.countByParameter(id);
		if(count > 0){
			map.put("message", "删除失败!请先删除子节点后再操作");
			return map;
		}else{
			CommonQuestion commonQuestion = commonQuestionService.selectById(id);
			CommonQuestion cq = commonQuestionService.selectById(commonQuestion.getPid());
			if(cq != null){
				cq.setCode(cq.getCode()-1);
				commonQuestionService.updateById(cq);
			}
			commonQuestionService.deleteById(id);
			map.put("message", "操作成功!");
			return map;
		}
	}
}

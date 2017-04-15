package com.uflowertv.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uflowertv.model.CommonQuestion;
import com.uflowertv.service.CommonQuestionService;
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
@RequestMapping("/question")
public class CommonQuestionController {

	
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
	@RequestMapping("/getCommonQuestionList.do")
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
	@RequestMapping("/getQuestionType.do")
	@ResponseBody
	public List<CommonQuestion> getQuestionType(){
		return commonQuestionService.getCommonQuestions();
	}
	
	/**
	 * 
	 * @Title: saveCommonQuestion
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param commonQuestion
	 * @return
	 */
	@RequestMapping("/saveCommonQuestion.do")
	@ResponseBody
	public Map<String,Object> saveCommonQuestion(CommonQuestion commonQuestion){
		commonQuestion.setId(null);
		Map<String,Object> map = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		commonQuestion.setCreatetime(sdf.format(new Date()));
		CommonQuestion cq = commonQuestionService.getCommonQuestion(commonQuestion.getPid());
		if(cq != null){
			cq.setCode(cq.getCode()+1);
			commonQuestionService.updateCommonQuestion(cq);
		}
		commonQuestion.setCode(0);
		int count = commonQuestionService.saveCommonQuestion(commonQuestion);
		if(count > 0){
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
	@RequestMapping("/updateCommonQuestion.do")
	@ResponseBody
	public Map<String,Object> updateCommonQuestion(CommonQuestion commonQuestion){
		Map<String,Object> map = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		commonQuestion.setUpdatetime(sdf.format(new Date()));
		List<CommonQuestion> list = commonQuestionService.selectByString(commonQuestion.getId());
		if(list!=null && list.size()>0){
			List<CommonQuestion> list2 = new ArrayList<CommonQuestion>();
			for (CommonQuestion commonQuestion2 : list) {
				commonQuestion2.setpQuestion(commonQuestion.getQuestion());
				list2.add(commonQuestion2);
			}
			commonQuestionService.updateBatchCommonQuestion(list2);
		}
		commonQuestionService.updateCommonQuestion(commonQuestion);
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
	@RequestMapping("/delCommonQuestion.do")
	@ResponseBody
	public Map<String,Object> delCommonQuestion(int id){
		Map<String,Object> map = new HashMap<String, Object>();
		int count = commonQuestionService.countByParameter(id);
		if(count > 0){
			map.put("message", "删除失败!请先删除子节点后再操作");
			return map;
		}else{
			CommonQuestion commonQuestion = commonQuestionService.getCommonQuestion(id);
			CommonQuestion cq = commonQuestionService.getCommonQuestion(commonQuestion.getPid());
			if(cq != null){
				cq.setCode(cq.getCode()-1);
				commonQuestionService.updateCommonQuestion(cq);
			}
			commonQuestionService.delCommonQuestion(id);
			map.put("message", "操作成功!");
			return map;
		}
	}
}

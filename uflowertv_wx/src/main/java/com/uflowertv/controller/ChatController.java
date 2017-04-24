package com.uflowertv.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.uflowertv.controller.support.BaseController;
import com.uflowertv.model.po.CommonQuestion;
import com.uflowertv.service.CommonQuestionService;
import com.uflowertv.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：wxpublic   
 *
 * 类描述：
 * 类名称：com.uflowertv.controller.ChatController     
 * 创建人：liguoliang 
 * 创建时间：2016年9月7日 下午6:22:14   
 * 修改人：
 * 修改时间：2016年9月7日 下午6:22:14   
 * 修改备注：   
 * @version   V1.0
 */
@Controller
@RequestMapping("chatserver")
public class ChatController extends BaseController{
	
	@Autowired
	private CommonQuestionService commonQuestionService;
	/**
	 * @Title: auto_reply
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("auto_reply")
	public void auto_reply(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String id = request.getParameter("id");
		List<CommonQuestion> list = null;
		if (StringUtils.isBlank(id)) {
		    int pid = 0;
            list = commonQuestionService.selectList(new EntityWrapper<CommonQuestion>().where("pid={0}",pid));
		}else{
			list = commonQuestionService.selectByString(Integer.valueOf(id));
		}
		response.getWriter().print(JsonUtils.bean2Json(list));
		
		/*String jsoncallback=request.getParameter("callback");
		String id = request.getParameter("id");
		List<CommonQuestion> list = null;
		if (StringUtils.isBlank(id)) {
			list = commonQuestionService.queryFrist();
		}else{
			list = commonQuestionService.selectByString(Integer.valueOf(id));
		}
		response.getWriter().print(jsoncallback +"("+ JsonUtils.bean2Json(list)+")");*/
	}
}
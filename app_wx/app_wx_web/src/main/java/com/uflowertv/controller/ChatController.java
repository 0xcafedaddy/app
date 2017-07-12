package com.uflowertv.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.uflowertv.model.CommonQuestion;
import com.uflowertv.service.CommonQuestionService;
import com.uflowertv.support.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：wxpublic   
 *
 * 类描述：
 * 类名称：ChatController
 * 创建人：liguoliang 
 * 创建时间：2016年9月7日 下午6:22:14   
 * 修改人：
 * 修改时间：2016年9月7日 下午6:22:14   
 * 修改备注：   
 * @version   V1.0
 */
@Controller
@RequestMapping("wechat")
public class ChatController extends BaseController{
	
	@Autowired
	private CommonQuestionService commonQuestionService;

    /**
     * 自动回复
     * @param request
     * @return
     */
	@RequestMapping(value = "/auto_reply",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<CommonQuestion> auto_reply(HttpServletRequest request) {
	    String id = request.getParameter("id");
		if (StringUtils.isBlank(id)) {
		    int pid = 0;
            return commonQuestionService.selectList(new EntityWrapper().where("pid={0}",pid));
		}
        return commonQuestionService.selectByString(Integer.valueOf(id));
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
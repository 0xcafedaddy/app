package com.uflowertv.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.uflowertv.model.News;
import com.uflowertv.model.po.Question;
import com.uflowertv.model.po.User;
import com.uflowertv.service.QuestionService;
import com.uflowertv.service.UserService;
import com.uflowertv.util.ConstantHolder;
import com.uflowertv.util.FreeMarkerTemplateUtil;
import com.uflowertv.util.GUIDUtil;
import io.github.elkan1788.mpsdk4j.api.WechatAPI;
import io.github.elkan1788.mpsdk4j.api.WechatAPIImpl;
import io.github.elkan1788.mpsdk4j.mvc.WechatWebSupport;
import io.github.elkan1788.mpsdk4j.vo.MPAccount;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * 问题反馈
 * 版权所有：2016-油菜花
 * 项目名称：Weixin   
 *
 * 类描述：
 * 类名称：com.uflowertv.controller.QuestionController    
 * 创建人：liguoliang 
 * 创建时间：2016年8月22日 下午3:09:08   
 * 修改人：
 * 修改时间：2016年8月22日 下午3:09:08   
 * 修改备注：   
 * @version   V1.0
 */
@Controller
@RequestMapping("question")
public class QuestionController extends WechatWebSupport{
    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserService userService;
    
   //声明接口
  	private WechatAPI wechatAPI;
  	/*
  	 *普通代码块加载参数 
  	 */
  	{
	  MPAccount mpAct = new MPAccount();
      mpAct.setMpId(ConstantHolder.MPID);
      mpAct.setAppId(ConstantHolder.APPID);
      mpAct.setAppSecret(ConstantHolder.APPSECRET);
      mpAct.setToken(ConstantHolder.TOKEN);
      _wk.setMpAct(mpAct);
      // 实例化所有接口信息
      wechatAPI = WechatAPIImpl.create(mpAct);
  	}
  	/**
  	 * 
  	 * @Title: uploadMulti
  	 * @Description: TODO(这里用一句话描述这个方法的作用)
  	 * @param files
  	 * @param request
  	 * @throws IOException 
  	 */
  	@RequestMapping("/test/upload")
  	public void uploadMulti(@RequestParam MultipartFile[] files,HttpServletRequest request) throws IOException{
  		 /**
	     * springMvc 上传图片
	     * 1.enctype属性的属性值设为multipart/form-data。
	     * 2.input的type属性的属性值设为file。
	     * 后台就可以使用multipartResolver获取到前台上传的文件
	     */
		for(MultipartFile file : files){  
            if(!file.isEmpty()){  
            	String ext = FilenameUtils.getExtension(file.getOriginalFilename());
				//如果名称不为“”,说明该文件存在，否则说明该文件不存在  
				if (ext.trim() != "") {
					//年月日分时秒 （毫秒） + 随机数（三位）
					DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
					//图片名
					String name = df.format(new Date());
					Random r = new Random();
					for (int i = 0; i < 3; i++) {
						name += r.nextInt(10);
					}
					String fileName = name + "." + ext; //png
					String realPath = request.getSession().getServletContext().getRealPath("upload");
					//这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的  
					FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, fileName));  
				}
            } 
        }  
  	}

    /**
     * 提交反馈问题
     * @param request
     * @param question
     * @return
     */
	@RequestMapping("/saveQuestion")
	@ResponseBody
	public Map<String,Object> save(HttpServletRequest request,Question question){
		String param = request.getParameter("base64Img");
		String[] base64Img = param.split(",");
	    String path = request.getSession().getServletContext().getRealPath("upload")+ConstantHolder.IMG_FLODER;
	    //file 为前台隐藏域里面的字符串
	    StringBuffer sb = new StringBuffer();
	    if(base64Img!= null && base64Img.length!=0){
	    	for (String base64Str : base64Img) {
				byte[] byteArr = Base64.decodeBase64(base64Str);
				DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				//图片名
				String name = df.format(new Date());
				Random r = new Random();
				for (int i = 0; i < 3; i++) {
					name += r.nextInt(10);
			    }
				String fileName = name+".jpg";
				sb.append(fileName).append(",");
				try {
		              OutputStream out = new FileOutputStream(path+File.separator+fileName);
		              out.write(byteArr);
		              out.close();
		          } catch (Exception e) {
		              e.printStackTrace();
		          }
			}
	    }
	    question.setWxUserQuestionImg(sb.substring(0, sb.length()-1).toString());
		Map<String, Object> map = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        question.setCreateTime(sdf.format(new Date()));
        question.setStatus(0);
        question.setId(GUIDUtil.get());
		boolean insert = questionService.insert(question);
		if(insert){
			map.put("message", "提交成功！");
			wechatAPI.sendCoustomText( question.getWxUserId(), "您的问题反馈成功，请耐心等待！");
			return map;
		}else{
			map.put("message", "提交失败！");
			return map;
		}
	}


    /**
     * 回复问题
     * @param request
     * @param question
     * @return
     */
	@RequestMapping("/replyQuestion")
	@ResponseBody
	public Map<String,Object> replyQuestion(HttpServletRequest request,Question question){
        Map<String,Object> map = Maps.newHashMap();
        User user= userService.selectById(question.getReplyQuestionHuman());
        question.setReplyQuestionHuman(user.getUname());
        question.setCompleteTime(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        boolean update = questionService.updateById(question);
        if(update){
		    /** Create a data model */
		    Map<String, Object> mapTemplateData = new HashMap<String, Object>();
		    mapTemplateData.put("question", question );
		    mapTemplateData.put("replyTime", new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
	
		    String htmlFileFtl = "user_question.ftl";
		    String htmlFileName = FreeMarkerTemplateUtil.geneHtmlFile(request, mapTemplateData, htmlFileFtl);
		    String url = ConstantHolder.FILE_SERVER + ConstantHolder.HTML_FLODER + htmlFileName;
		    String picUrl = ConstantHolder.FILE_SERVER +"/question.jpg";
		    List<News> list = Lists.newArrayList();
            String desc = question.getReplyQuestionContent();
		    if(StringUtils.isNotBlank(desc)&&desc.length() > 25){
		    	desc = desc.substring(0, 25)+"……";
		    }
		    list.add(new News(question.getWxUserQuestionTitle(), desc , url, picUrl));
		    //开启微信配置信息
		   // wechatAPI.sendCoustomNews( question.getWxUserId(), list);
			map.put("message", "回复成功!");
			map.put("code", 1);
			return map;
		}else{
			map.put("message", "回复失败!");
			return map;
		}
	}

    /**
     * 问题列表
     * @param page
     * @param rows
     * @param status
     * @param question
     * @return
     */
	@RequestMapping("/userQuestionList")
	@ResponseBody
	public Map<String,Object> userQuestionList(int page,int rows,String status,Question question){
		return questionService.list(page, rows, Integer.valueOf(status),question);
	}

    /**
     * 查看详情
     * @param id
     * @param status
     * @return
     */
	@RequestMapping("/questionInfo")
	public ModelAndView questionInfo(String id,String status){
		ModelAndView mv = new ModelAndView("exception");
		Question question = questionService.selectById(id);
		if(question!=null){
			mv.addObject("question", question);
			if("0".equals(status)){
				mv.setViewName("question/quesionInfo");
			}else if("3".equals(status)){
				mv.setViewName("question/quesionInfo");
			}else if("4".equals(status)){
				mv.setViewName("question/quesionInfo2");
			}else{
				mv.setViewName("question/quesionInfo2");
			}
			return mv;
		}
		return mv;
	}

    /**
     * 转交其它部门
     * @param questionId
     * @param stauts
     * @return
     */
	@RequestMapping("/changeOther")
	@ResponseBody
	public Map<String,Object> changeOther(String questionId,String stauts){
		Question question = new Question();
        question.setId(questionId);
        question.setStatus(Integer.valueOf(stauts));
        boolean update = questionService.updateById(question);
        Map<String,Object> map = Maps.newHashMap();
		if(update){
			map.put("message", "转交成功!");
			return map;
		}
        map.put("message", "转交失败!");
        return map;
	}

    /**
     * 图片列表
     * @param id
     * @param request
     * @return
     */
	@RequestMapping("/getImgNameList")
	@ResponseBody
	public List<String> getImgNameList(String id,HttpServletRequest request){
        Question question = questionService.selectById(id);
		String[] names = question.getWxUserQuestionImg().split(",");
		List<String> list = Arrays.asList(names);
		List<String> newList = Lists.newArrayList();
        String remotePath = ConstantHolder.FILE_SERVER+ConstantHolder.IMG_FLODER;
		if(list.size()>0){
			for (String string : list) {
				String name = remotePath + string ;
				newList.add(name);
			}
		}
		return newList;
	}

    /**
     * 更新问题状态
     * @param status
     * @param id
     * @return
     */
	@RequestMapping("/updateStatus")
	@ResponseBody
	public Map<String, Object> updateStatus(int status,String id){
		Map<String, Object> map = Maps.newHashMap();
        Question question = questionService.selectById(id);
        question.setStatus(status);
        boolean update = questionService.updateById(question);
        if(update && status == 4){
			map.put("message", "谢谢回复,您的支持就是我们的动力！");
			return map;
		}
		if(update && status == 5){
			map.put("message", "非常抱歉,我们会尽力的！");
			return map;
		}
		return Collections.emptyMap();
	}
}

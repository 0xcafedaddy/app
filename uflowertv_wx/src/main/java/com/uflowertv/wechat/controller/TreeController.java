package com.uflowertv.wechat.controller;

import com.uflowertv.bean.dto.SessionInfo;
import com.uflowertv.bean.dto.TreeData;
import com.uflowertv.wechat.controller.support.BaseController;
import com.uflowertv.wechat.service.TreeService;
import com.util.json.gson.GsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("tree")
public class TreeController extends BaseController{
	@Autowired
	private TreeService treeService;

	
	@RequestMapping(value = "/getTreeList")
	public void getTreeList(String id,HttpSession session,HttpServletResponse response) throws IOException{
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
		if(sessionInfo != null){
			List<TreeData> treeDataList = null;
			if(StringUtils.isBlank(id)){
				id = "0";
				treeDataList=treeService.getTreeList(id);
			}else{
				treeDataList=treeService.getTreeList(id);
			}
			response.getWriter().print(GsonUtils.objToJson(treeDataList));
		}else{
			response.getWriter().print(-1);
		}
	}
	
	/**
	 * 验证码
	 * @Title: validateCode
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/validateCode.do")
	public void validateCode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		 //创建图片的不buff内存缓存区
		BufferedImage bi=new BufferedImage(100,40,BufferedImage.TYPE_INT_RGB); 
		//获取图像的处理接口
		Graphics GImage=bi.getGraphics();
		//创建图片背景色
		Color color=new Color(200,150,255);
		//设置图片颜色
		GImage.setColor(color);
		//与canvas 差不多  用来 用当前颜色填充 矩形
		GImage.fillRect(0, 0, 100, 40);	
		
		char[] ca="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random r=new Random();  //随机默认当前系统时间对应的相对时间有关的数字作为种子数:
		int len=ca.length;
		int index;
		StringBuilder sb=new StringBuilder();
		Font f = new Font("宋体",Font.BOLD ,34); 
		GImage.setFont(f);
		
		for(int i=0;i<4;i++){    //随机生成四个数字
			index=r.nextInt(len);
			GImage.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
			if(i==2){
				Graphics2D g2d = (Graphics2D) GImage;
				g2d.rotate( 0.02*Math.PI);//旋转
				
			}
			GImage.drawString(ca[index]+"", i*20+10, 30);   //设置每个字符的位置
			sb.append(ca[index]);		
		}
		
		request.getSession().setAttribute("code", sb.toString());
		ImageIO.write(bi, "JPG", response.getOutputStream());
	}
}

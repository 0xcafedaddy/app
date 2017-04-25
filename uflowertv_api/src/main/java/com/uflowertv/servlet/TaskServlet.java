package com.uflowertv.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 
 * 版权所有：2017年1月19日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：启动各流程对应线程
 * 类名称：com.uflowertv.servlet.TaskServlet     
 * 创建人：liguoliang 
 * 创建时间：2017年1月19日 下午4:47:08   
 * 修改人：
 * 修改时间：2017年1月19日 下午4:47:08   
 * 修改备注：   
 * @version   V1.0
 */

/*@WebServlet(asyncSupported = true,//支持异步处理
			name = "TaskServlet",//servlet名称
			loadOnStartup = 3,//启动优先级
			urlPatterns = { "/returnServlet" }, //servlet映射地址
			initParams = {@WebInitParam(name = "returnUrlThreadTime", value = "6000"),//初始化参数
						  @WebInitParam(name = "notifyUrlThreadTime", value = "2000")})*/
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	private ReturnUrlThread returnUrlThread;
	private NotifyUrlThread notifyUrlThread;

	public void init(){
		
		long returnUrlThreadTime = Long.valueOf(getServletConfig().getInitParameter("returnUrlThreadTime"));
		long notifyUrlThreadTime = Long.valueOf(getServletConfig().getInitParameter("notifyUrlThreadTime"));
		try {
			log	.info("线程returnUrlThread启动");
			this.returnUrlThread = new ReturnUrlThread(returnUrlThreadTime);
			//new Thread(this.returnUrlThread).start();
		} catch (Exception e) {
			log.error("启动线程发生异常" + e);
		}
		
		try {
			log	.info("线程notifyUrlThread启动");
			this.notifyUrlThread = new NotifyUrlThread(notifyUrlThreadTime);
			//new Thread(this.notifyUrlThread).start();
		} catch (Exception e) {
			log.error("启动线程发生异常" + e);
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
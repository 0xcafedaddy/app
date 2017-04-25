package com.uflowertv.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * 版权所有：2017年1月19日-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：回调多线程请求处理
 * 类名称：com.uflowertv.servlet.ReturnUrlThread     
 * 创建人：liguoliang 
 * 创建时间：2017年1月19日 下午4:49:24   
 * 修改人：
 * 修改时间：2017年1月19日 下午4:49:24   
 * 修改备注：   
 * @version   V1.0
 */
public class ReturnUrlThread implements Runnable {
	private static Logger log = LoggerFactory.getLogger(ReturnUrlThread.class);
	
	private long sleeptime;
	
    public ReturnUrlThread(long sleeptime) {
    	this.sleeptime = sleeptime;
    }
    
	private void cloudComposeTask() {
		System.out.println("ReturnUrlThread.cloudComposeTask()");
	}
	
	
	@Override
	public void run() {
		log.info("线程正在运行...");
		while(!Thread.currentThread().isInterrupted()) {//当队列达到容量时，会阻塞。
			try {
				cloudComposeTask();
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {
				log.error("云迁移线程发生异常", e);
				Thread.currentThread().interrupt(); //发生异常时中断线程
			}
		}
	}
}

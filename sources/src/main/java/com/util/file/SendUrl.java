package com.util.file;

import com.util.LogUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * 远程及本地调用命令公共类
 * @author 刘勇涛
 *
 */
public class SendUrl 
{
	/**
	 * 远程调用url
	 * @param sendtext		发送的内容
	 * @param uurrll		远程url地址
	 * @return		调用远程url的接收内容
	 * @throws Exception
	 */
	public static String sendUrl(String sendtext, String uurrll, String msg) throws Exception
	{
		URL url = new URL(uurrll);

		HttpURLConnection conn;
		conn = (HttpURLConnection) url.openConnection();
		
		conn.setConnectTimeout(5*60 * 1000);
		conn.setReadTimeout(Constants.httpTimeOut);
		
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("content-type", "text/xml charset=utf-8");  

		conn.setRequestProperty("Accept-Charset", "UTF-8");
		
		conn.connect();
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(
				 conn.getOutputStream(), "UTF-8"));
		LogUtil.printLog("info", "send xml = " + sendtext);
		output.write(sendtext);
		output.flush();
		output.close();
		System.out.println("---------------------"+msg+"开始--------------------");
		InputStream input = conn.getInputStream();
		int length = conn.getContentLength();
		System.out.println("length = " + length + " - " + conn.getResponseCode());
		String backstring = null;
		byte[] response = null;
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		byte[] ch = new byte[256];
		int len;
		//System.out.println("get xml ");
		while ((len = input.read(ch)) >= 0) {
			buf.write(ch, 0, len);
		}
		response = buf.toByteArray();
		buf.flush();
		buf.close();
		backstring = new String(response, "UTF-8");
		input.close();
		System.out.println("---------------------"+msg+"结束--------------------");
		
		LogUtil.printLog("info", "backResult = " + backstring);
		
		return backstring;
	}
	
	/**
	 * 调用本地命令，如exe,bat等等
	 * @param cmd		要调用的命令地址
	 * @param param		需要传入的参数
	 * @param msg		调用成功后的输出提示
	 * @throws Exception
	 */
	public static void sendexe(String cmd, String param, String msg) throws Exception
	{
		if(param != null)
		{
			cmd = cmd+" "+param.replaceAll("/", "\\\\");
		}
		
		String[] cmdArray = cmd.split(" ");
		
		ProcessBuilder processBuilder=new ProcessBuilder(cmdArray); 
		processBuilder.redirectErrorStream(true); 
		Process ps=processBuilder.start();
		
		//Process ps = Runtime.getRuntime().exec(cmdArray);

		BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
		String   line   =   null;
		StringBuffer strXml = new StringBuffer();
	    while((line   =   br.readLine())!=null)
	    {
	    	strXml.append(line).append("\r\n");
	    	System.out.println(line);
	    }
	    br.close();
	    
	    LogUtil.printLog("info", strXml.toString());
	    
		int result = ps.waitFor();
		if(result == 0)
		{
			LogUtil.printLog("info", msg);
		}
		else
		{
			LogUtil.printLog("info", "操作失败");
		}
	}
	
	/**
	 * 多线程调用本地命令，如exe,bat等等(备用)
	 * @param cmd		要调用的命令地址
	 * @param param		需要传入的参数
	 * @param msg		调用成功后的输出提示
	 * @throws Exception
	 */
	public static void sendexe2(String cmd, String param, String msg) throws Exception
	{
		if(param != null)
		{
			cmd = cmd+" "+param.replaceAll("/", "\\\\");
		}
		
		String[] cmdArray = cmd.split(" ");
		
		final Process ps = Runtime.getRuntime().exec(cmdArray);
		
		 new Thread(new Runnable(){
		  public void run(){
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(ps.getErrorStream()));
			String   line   =   null;
			StringBuffer strXml = new StringBuffer();
		    while((line   =   br.readLine())!=null)
		    {
		    	strXml.append(line).append("\r\n");
		    	System.out.println(line);
		    }
		    br.close();
		    
		    LogUtil.printLog("info", strXml.toString());
		 }
		catch(Exception e)
		 {
			  try {
				LogUtil.printLog("error", "执行exe多线程失败");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	 }
		}).start();
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
		String   line   =   null;
		StringBuffer strXml = new StringBuffer();
	    while((line   =   br.readLine())!=null)
	    {
	    	strXml.append(line).append("\r\n");
	    	System.out.println(line);
	    }
	    br.close();
		    
		LogUtil.printLog("info", strXml.toString());
		
		int result = ps.waitFor();
		if(result == 0)
		{
			LogUtil.printLog("info", msg);
		}
		else
		{
			LogUtil.printLog("info", "操作失败");
		}
	}
	
	/**
	 * 将指定文件解压缩
	 * @param sourcePath		源文件路径
	 * @param targetPath		被解压到的路径
	 * @throws Exception
	 */
	public static void unRarFile(String sourcePath, String targetPath)  throws Exception
	{
			// 系统安装winrar的路径   
			String cmd = "C:\\Program Files\\WinRAR\\WinRAR.exe";
			String param = "x -r -p- -o+ " + sourcePath + " " + targetPath;
			
			sendexe(cmd, param, "--------------------------------------解压缩文件执行成功!----------------------------------");
	}
}
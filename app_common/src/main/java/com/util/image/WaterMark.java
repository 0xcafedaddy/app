package com.util.image;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *添加图片水印的服务类
 * */
public class WaterMark {
  /**
   * @param request 请求流对象
   * @param request 响应流对象
   * */
	@SuppressWarnings("deprecation")
	public static void createMarkSize(String sizeContext,HttpServletRequest request,HttpServletResponse response)   {
		try {
			String path=request.getRealPath(request.getServletPath());
			FileInputStream in=new FileInputStream(path);
			Image src=ImageIO.read(in);
			int w=src.getWidth(null);
			int h=src.getHeight(null);
			BufferedImage img=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);//构建画板
			Graphics g=img.getGraphics();//得到画笔
			g.drawImage(src,0,0,w,h,null);//把源图片写入画板
			g.setColor(Color.red);
			g.drawString(sizeContext,10,5);  // 添加文字
			g.dispose();//生成图片
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(img,"jpg",outputStream);
            outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
  /**
    * @param localPath 添加水印LOGO路径
    * @param newFilePath 要添加水印的图片路径
    **/
	@SuppressWarnings("deprecation")
	public static void createMarkLogo(String localPath,String newFilePath)   {
		try {
			FileInputStream file=new FileInputStream(localPath);
			Image fimg=ImageIO.read(file);
			//int fw=fimg.getWidth(null);
			//int fh=fimg.getHeight(null);
			FileInputStream in=new FileInputStream(newFilePath);
			Image src=ImageIO.read(in);
			int w=src.getWidth(null);
			int h=src.getHeight(null);
			BufferedImage img=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);//构建画板
			Graphics g=img.getGraphics();//得到画笔
			g.drawImage(src,0,0,w,h,null);//把原图片写入画板
			int x=(int) (0.7*w);
			int y=(int) (0.7*h);
			g.drawImage(fimg,x,y,w-x,h-y,null);//把水印图片写入画板
			g.dispose();//生成图片
			FileOutputStream out=new FileOutputStream(newFilePath);
			ImageIO.write(img,"jpg",out);
			out.close();
			img.flush();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

      /**
    * @param localPath 添加水印图片路径
    * @param request 请求流对象
    * @param request 响应流对象
                  * @param width   水印图片的宽度
                  * @param height  水印图片的长度
    **/
	@SuppressWarnings("deprecation")
	public   static   void  createMarkLogo(String localPath,HttpServletRequest request,HttpServletResponse response,int width,int height)   {
		try {
			FileInputStream file=new FileInputStream(localPath);
			Image fimg=ImageIO.read(file);
			int fw=fimg.getWidth(null);
			int fh=fimg.getHeight(null);
			String path=request.getRealPath(request.getServletPath());
			FileInputStream in=new FileInputStream(path);
			Image src=ImageIO.read(in);
			int w=src.getWidth(null);//w为你过滤图片的宽度
			int h=src.getHeight(null);//h为你过滤图片的长度
			BufferedImage img=new BufferedImage(w+width,h+height,BufferedImage.TYPE_INT_RGB);//构建画板(画板的宽度为两个图片之和)
			Graphics g=img.getGraphics();//得到画笔
			g.drawImage(src,0,0,w,h,null);//把原图片写入画板
			g.drawImage(fimg,width,height,fw,fh,null);//把水印图片写入画板
			g.dispose();//生成图片
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(img,"jpg",outputStream);
            outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}   

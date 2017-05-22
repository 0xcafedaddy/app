package com.util.image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.*;
import java.net.URL;

/**
 * 图像压缩工具
 * @author 
 * 
 */
public class ImageSizer {
    public static final MediaTracker tracker = new MediaTracker(new Component() {
        private static final long serialVersionUID = 1234162663955668507L;} 
    );
    /**
     * @param originalFile 原图像
     * @param resizedFile 压缩后的图像
     * @param width 图像宽
     * @throws IOException
     */
    public static void resize(File originalFile, File resizedFile, Integer width,Integer height) throws IOException {   	
    	String format = getFileSuffix(originalFile);
        if(format!=null && "gif".equals(format.toLowerCase())){
        	resizeGif(originalFile, resizedFile, width, height);
        	return;
        }
        FileInputStream fis = new FileInputStream(originalFile);
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int readLength = -1;
        int bufferSize = 1024;
        byte bytes[] = new byte[bufferSize];
        while ((readLength = fis.read(bytes, 0, bufferSize)) != -1) {
            byteStream.write(bytes, 0, readLength);
        }
        byte[] in = byteStream.toByteArray();
        fis.close();
        byteStream.close();
        
    	Image inputImage = Toolkit.getDefaultToolkit().createImage( in );
        waitForImage( inputImage );
        int imageWidth = inputImage.getWidth( null );
        if ( imageWidth < 1 ) 
           throw new IllegalArgumentException( "image width " + imageWidth + " is out of range" );
        int imageHeight = inputImage.getHeight( null );
        if ( imageHeight < 1 ) 
           throw new IllegalArgumentException( "image height " + imageHeight + " is out of range" );
        
        // Create output image.
        if(height == null){
			float scale =(float)imageWidth/imageHeight;//
			width = imageWidth<width?imageWidth:width;
			height = (int) (width /scale );
        }else{
			float scale = getRatio(imageWidth, imageHeight, width, height);
//			scale = 2.0f;
			width = (int) (scale * imageWidth);
			height = (int) (scale * imageHeight);
        }
        
        Image outputImage = inputImage.getScaledInstance( width, height, Image.SCALE_DEFAULT);
        checkImage( outputImage );        
        encode(new FileOutputStream(resizedFile), outputImage, format);        
    }    

    /** Checks the given image for valid width and height. */
    private static void checkImage( Image image ) {
       waitForImage( image );
       int imageWidth = image.getWidth( null );
       if ( imageWidth < 1 ) 
          throw new IllegalArgumentException( "image width " + imageWidth + " is out of range" );
       int imageHeight = image.getHeight( null );
       if ( imageHeight < 1 ) 
          throw new IllegalArgumentException( "image height " + imageHeight + " is out of range" );
    }

    /** Waits for given image to load. Use before querying image height/width/colors. */
    private static void waitForImage( Image image ) {
       try {
          tracker.addImage( image, 0 );
          tracker.waitForID( 0 );
          tracker.removeImage(image, 0);
       } catch( InterruptedException e ) { e.printStackTrace(); }
    } 

    /** Encodes the given image at the given quality to the output stream. */
    private static void encode( OutputStream outputStream, Image outputImage, String format ) 
       throws IOException {
       int outputWidth  = outputImage.getWidth( null );
       if ( outputWidth < 1 ) 
          throw new IllegalArgumentException( "output image width " + outputWidth + " is out of range" );
       int outputHeight = outputImage.getHeight( null );
       if ( outputHeight < 1 ) 
          throw new IllegalArgumentException( "output image height " + outputHeight + " is out of range" );

       // Get a buffered image from the image.
       BufferedImage bi = new BufferedImage( outputWidth, outputHeight,
          BufferedImage.TYPE_INT_RGB );                                                   
       Graphics2D biContext = bi.createGraphics();
       biContext.drawImage( outputImage, 0, 0, null );
       ImageIO.write(bi, format, outputStream);
       outputStream.flush();  
       outputStream.close();
    } 
    
	/**
	 * 缩放gif图片
	 * @param originalFile 原图片
	 * @param resizedFile 缩放后的图片
	 * @param newWidth 宽度
	 * @throws IOException
	 */
    private static void resizeGif(File originalFile, File resizedFile, Integer newWidth, Integer newHeight) throws IOException {
    	ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
        Image i = ii.getImage();
        Image resizedImage = null; 
        int iWidth = i.getWidth(null);
        int iHeight = i.getHeight(null); 
        float scale = 1;
		
		if(newHeight == null){
			scale =(float)iWidth/iHeight;//
			int width = iWidth<newWidth?iWidth:newWidth;
			int height = (int) (width /scale );
			resizedImage = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		}else{
			scale = getRatio(iWidth, iHeight, newWidth, newHeight);
			int tempWidth = (int) (scale * iWidth);
			int tempheight = (int) (scale * iHeight);
			resizedImage = i.getScaledInstance(tempWidth, tempheight, Image.SCALE_SMOOTH);
		}
        
        // This code ensures that all the pixels in the image are loaded.
        Image temp = new ImageIcon(resizedImage).getImage(); 
        // Create the buffered image.
        BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null), temp.getHeight(null),
                                                        BufferedImage.TYPE_INT_RGB); 
        // Copy image to buffered image.
        Graphics g = bufferedImage.createGraphics(); 
        // Clear background and paint the image.
        g.setColor(Color.white);
        g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
        g.drawImage(temp, 0, 0, null);
        g.dispose(); 
        // Soften.
        float softenFactor = 0.05f;
        float[] softenArray = {0, softenFactor, 0, softenFactor, 1-(softenFactor*4), softenFactor, 0, softenFactor, 0};
        Kernel kernel = new Kernel(3, 3, softenArray);
        ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        bufferedImage = cOp.filter(bufferedImage, null); 
        // Write the jpeg to a file.
        FileOutputStream out = new FileOutputStream(resizedFile);        
        // Encodes image as a JPEG data stream
        ImageIO.write(bufferedImage,"jpg",out);
    }
    
    /**
     * 获得文件的后缀
     * @param originalFile
     * @return
     */
    public static String getFileSuffix(File originalFile){
    	String format = originalFile.getName().substring(originalFile.getName().lastIndexOf(".")+1, originalFile.getName().length());
    	return format;
    }
    
    /**
	 * 获取长宽比例
	 * @param width
	 * @param height
	 * @param maxWidth
	 * @param maxHeight
	 * @return
	 */
	public static float getRatio(int width, int height, int maxWidth,
			int maxHeight) {
		float Ratio = 1.0f;
		float widthRatio;
		float heightRatio;
		widthRatio = (float) maxWidth / width;
		heightRatio = (float) maxHeight / height;
		if (widthRatio < 1.0 || heightRatio < 1.0) {
			Ratio = widthRatio <= heightRatio ? widthRatio : heightRatio;
		}
		return Ratio;
	}
	
    public static void main(String[] args) {
    	try {
			ImageSizer.resize(new File("d:\\123.gif"), new File("d:\\1111.gif"), 200, 100);
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	/**
	*
	* @param filrDir 要copy的目标文件夹路经
	* @param srcFilePath 原图路径
	* @param ext 扩展名
	* @param fileName 图片名
	* @param w 目标宽
	* @param h 目标高
	* @param per 百分比
	* @info GOOGLE MAP 专用
	*/
	    public static String resize(String srcFilePath,File filrDir,String ext,String fileName,int w,int h,float per)
	    {
	            Image src;
	            try {
	               //从URL读取
	               URL url = new URL(srcFilePath);
	               src = ImageIO.read(url.openStream()); //构造Image对象
	               String img_midname = filrDir+"/" + fileName.substring(0,fileName.indexOf("."))+"." + ext.toLowerCase(); 
	               int old_w=src.getWidth(null); //得到源图宽
	               int old_h=src.getHeight(null);
	               int new_w=0;
	               int new_h=0; //得到源图长
	               double w2=(old_w*1.00)/(w*1.00);
	               double h2=(old_h*1.00)/(h*1.00);
	               /*
	               //图片跟据长宽留白，成一个正方形图  目前不需要
	               BufferedImage oldpic;
	               if(old_w>old_h)
	               {
	                   oldpic=new BufferedImage(old_w,old_w,BufferedImage.TYPE_INT_RGB);
	               }else{if(old_w<old_h){
	                   oldpic=new BufferedImage(old_h,old_h,BufferedImage.TYPE_INT_RGB);
	               }else{
	                    oldpic=new BufferedImage(old_w,old_h,BufferedImage.TYPE_INT_RGB);
	               }
	               }
	                Graphics2D g = oldpic.createGraphics();
	                g.setColor(Color.white);
	                if(old_w>old_h)
	                {
	                    g.fillRect(0, 0, old_w, old_w);
	                    g.drawImage(src, 0, (old_w - old_h) / 2, old_w, old_h, Color.white, null);
	                }else{
	                    if(old_w<old_h){
	                    g.fillRect(0,0,old_h,old_h);
	                    g.drawImage(src, (old_h - old_w) / 2, 0, old_w, old_h, Color.white, null);
	                    }else{
	                        //g.fillRect(0,0,old_h,old_h);
	                        g.drawImage(src.getScaledInstance(old_w, old_h,  Image.SCALE_SMOOTH), 0,0,null);
	                    }
	                }             
	                g.dispose();
	                src = oldpic;
	                //图片调整为方形结束 
	                */
	               if(old_w>w)
	               new_w=(int)Math.round(old_w/w2);
	               else
	                   new_w=old_w;
	               if(old_h>h)
	            	   new_h=(int)Math.round(old_h/h2);//计算新图长宽
	               else
	                   new_h=old_h;
	               BufferedImage tag = new BufferedImage(new_w,new_h,BufferedImage.TYPE_INT_RGB);       
	               tag.getGraphics().drawImage(src.getScaledInstance(new_w, new_h,  Image.SCALE_SMOOTH), 0,0,null);
	               FileOutputStream newimage=new FileOutputStream(img_midname); //输出到文件流
                   ImageIO.write(tag,"jpg",newimage);
	               newimage.close();
	               return "OK";
	               } catch (IOException ex) {
	            	   ex.printStackTrace();
	            	   return "ERR";
	            }
	    }    
	    /**
	     * @param originalFile 原图像
	     * @param resizedFile 压缩后的图像
	     * @throws Exception
	     * @throws IOException
	     */
	    public static void resize_upload(File originalFile, File resizedFile, Integer w,Integer h) throws Exception
	    {
	               Image src;
	               float per = 1f;
	               src = ImageIO.read(originalFile); //构造Image对象
	               int old_w=src.getWidth(null); //得到源图宽
	               int old_h=src.getHeight(null);
	               //小于一定尺寸就不用压缩了
//	               if(old_w > Constants.PHOTO_HEIGHT_SMALL  || old_h > Constants.PHOTO_HEIGHT_SMALL)
//	               {
		               @SuppressWarnings("unused")
					int new_w = 0;
		               @SuppressWarnings("unused")
					int new_h; //得到源图长
		               double w2=(old_w*1.00)/(w*1.00);
		               double h2=(old_h*1.00)/(h*1.00);    
		               if(old_w>w)
		            	  new_w = (int)Math.round(old_w/w2);
		               else
		                   new_w=old_w;
		               if(old_h>h)
		            	   new_h=(int)Math.round(old_h/h2);//计算新图长宽
		               else
		                   new_h=old_h;         
		              // int old_w = src.getWidth( null );
		               if ( old_w < 1 ) 
		                  throw new IllegalArgumentException( "image width " + old_w + " is out of range" );
		              // int old_h = src.getHeight( null );
		               if ( old_h < 1 ) 
		                  throw new IllegalArgumentException( "image height " + old_h + " is out of range" );
		               
		               // Create output image.
		               if(h == null)
		               {
			       			float scale =(float)old_w/old_h;//
			       			w = old_w<w?old_w:w;
			       			h = (int) (w /scale );
		               }
		               else
		               {
			       			float scale = getRatio(old_w, old_h, w, h);
		                   //scale = 2.0f;
			       			w = (int) (scale * old_w);
			       			h = (int) (scale * old_h);
		               }	 	            	   
//	               }
//	               else
//	               {
//	            	   w= old_w;
//	            	   h = old_h;
//	               }
	               BufferedImage tag = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);       
	               tag.getGraphics().drawImage(src.getScaledInstance(w, h,  Image.SCALE_SMOOTH), 0,0,null);
	               FileOutputStream newimage = new FileOutputStream(resizedFile); //输出到文件流
                   ImageIO.write(tag,"jpg",newimage);
	               newimage.close();
	    }       
}
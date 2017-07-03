package com.util.image;

import com.util.file.FileUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.*;
import java.net.URL;

public class ImageUtils {
	public static String originalityURL = "";
	public static String revisedURL = "";

	public static final MediaTracker tracker = new MediaTracker(new Component() {
		private static final long serialVersionUID = 1234162663955668507L;
	});

	/**
	 * 图片格式转换
	 * 
	 * @author : GaoYang
	 * @param source
	 * @param formatName
	 * @param result
	 */
	public static void convert(String source, String formatName, String result) {
		try {
			File f = new File(source);
			f.canRead();
			BufferedImage src = ImageIO.read(f);
			ImageIO.write(src, formatName, new File(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 *            图片所在目录
	 * @param fileName
	 *            图片名
	 * @param toFileName
	 *            压缩后图片名
	 * 
	 */

	public static synchronized void ImageScale(File fileName, File toFileName, int maxWidth, int maxHeight) {
		try {
			ImageSizer.resize_upload(fileName, toFileName, maxWidth, maxHeight);
		} catch (Exception ioe) {
			ioe.printStackTrace();
		} finally {

		}
	}

	/**
	 * 固定宽度等比例压缩
	 * 
	 *            图片所在目录
	 * @param fileName
	 *            图片名
	 * @param toFileName
	 *            压缩后图片名
	 */
	public static void imageScaleWidth(File fileName, File toFileName, int maxWidth) {
		try {
			ImageSizer.resize(fileName, toFileName, maxWidth, null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {

		}
	}

	/**
	 * 获取长宽比例
	 * 
	 * @param width
	 * @param height
	 * @param maxWidth
	 * @param maxHeight
	 * @return
	 */
	public static float getRatio(int width, int height, int maxWidth, int maxHeight) {
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

	/**
	 * 获取长宽比例
	 * 
	 * @param width
	 * @param height
	 * @param maxWidth
	 * @param maxHeight
	 * @return
	 */
	public static float getRatio2(int width, int height, int maxWidth, int maxHeight) {
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

	/**
	 * 获得新的文件名
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	static long item = 0l;

	public static String getImageNameByTime(String fileName) throws Exception {
		// Thread.sleep(1);
		StringBuilder sdate = new StringBuilder();
		sdate.append(System.currentTimeMillis() + item);
		item++;
		if(fileName.lastIndexOf(".")>0)
			sdate.append(fileName.substring(fileName.lastIndexOf("."), fileName.length()));
		else
			sdate.append(".png");
		return sdate.toString();
	}
	
	//获取图片后缀
	public static String getImageNameByItemNo(String fileName,String midPath) throws Exception {
		// Thread.sleep(1);
		StringBuilder sdate = new StringBuilder();
		sdate.append(midPath + item);
		item++;
		if(fileName.lastIndexOf(".")>0)
			sdate.append(fileName.substring(fileName.lastIndexOf("."), fileName.length()));
		else
			sdate.append(".png");
		return sdate.toString();
	}
public static void main(String[] args) {
	try {
		System.out.println(getImageNameByTime("wei"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	/**
	 * 删除上传的图片
	 * 
	 * @param fileDirectory
	 *            图片目录文件路径格式为 ：Constants.IMG_LOGO_PATH+"/"+enterprise.getId()
	 * @param imgUrl
	 *            原来的图片名称
	 */
	public static void deleteImg(String fileDirectory, String imgUrl) {

		if (imgUrl != null && !"".equals(imgUrl)) {
			File file = new File(fileDirectory);
			if (!file.exists())
				return;
			File[] feliList = file.listFiles();
			for (int i = 0; i < feliList.length; i++) {
				if (feliList[i].isDirectory()) {
					deleteImg(feliList[i].getPath(), imgUrl);
				} else {
					String filename = feliList[i].getName().trim();
					if (filename.equals(imgUrl.trim())) {
						System.out.println("delete:   " + filename);
						feliList[i].delete();
					}
				}
			}
			System.gc();
		}
	}

	/**
	 * 删除上传的图片
	 * 
	 * @param fileDirectory
	 *            图片目录文件路径格式为 ：Constants.IMG_LOGO_PATH+"/"+enterprise.getId()
	 * @param imgUrl
	 *            [] 原来的图片名称可以是多个
	 */
	public static void deleteImg(String fileDirectory, String imgUrl[]) {
		if (imgUrl != null && !"".equals(imgUrl)) {
			File file = new File(fileDirectory);
			if (!file.exists())
				return;
			File[] feliList = file.listFiles();
			for (int i = 0; i < feliList.length; i++) {
				if (feliList[i].isDirectory()) {
					deleteImg(feliList[i].getPath(), imgUrl);
				} else {
					String filename = feliList[i].getName().trim();
					for (int j = 0; j < imgUrl.length; j++) {
						if (filename.equals(imgUrl[i].trim())) {
							System.out.println(filename);
							feliList[i].delete();
						}
					}

				}
			}
			System.gc();
		}
	}

	/**
	 * 用流（图片URL）保存图片
	 * 
	 */
	public static String uploadImgByUrl(String imgUrl, File file, int width, int height) {
		try {
			imgUrl = " http://122.70.139.121/twitter/userImg/imageNews/64/original/1292825697532.jpg";
			URL url = new URL(imgUrl);
			BufferedImage src = ImageIO.read(url.openStream()); // 读入文件
			Image image = src.getScaledInstance(width, height, Image.SCALE_DEFAULT);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			ImageIO.write(tag, "PNG", file);// 输出到文件流
			return "OK";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERR";
		}
	}

	/**
	 * 
	 * @param filrDir
	 *            要copy的目标文件夹路经
	 * @param srcFilePath
	 *            原图路径
	 * @param ext
	 *            扩展名
	 * @param fileName
	 *            图片名
	 * @param w
	 *            目标宽
	 * @param h
	 *            目标高
	 * @param per
	 *            百分比
	 */
	public static String ImageScale(String srcFilePath, File filrDir, String ext, String fileName, int w, int h, float per) {
		return ImageSizer.resize(srcFilePath, filrDir, ext, fileName, w, h, per);
	}

	/**
	 * 固定宽度或者高度等比例压缩
	 * 
	 *            图片所在目录
	 * @param fileName
	 *            图片名
	 * @param toFileName
	 *            压缩后图片名
	 */
	public static String imageScaleWidthOrHeight(File fileName, File toFileName, int maxWidth, int maxHeight) throws Exception {
		String size = "";
		if (maxWidth == 0) {
			size = resizeSizer2(fileName, toFileName, 400, maxHeight);
		} else {
			size = resizeSizer2(fileName, toFileName, maxWidth, 400);
		}
		// resizeMagick(fileName, toFileName, maxWidth, null);
		return size;
	}

	/**
	 * @param originalFile
	 *            原图像
	 * @param resizedFile
	 *            压缩后的图像
	 * @param width
	 *            图像宽
	 *            图片格式 jpg, png, gif(非动画)
	 * @throws IOException
	 */
	public static String resizeSizer2(File originalFile, File resizedFile, Integer width, Integer height) throws Exception {
		String format = getFileSuffix(originalFile);
		if (format != null && "gif".equals(format.toLowerCase())) {
			resizeGif(originalFile, resizedFile, width, height);
			return "";
		}
		FileInputStream fis = null;
		ByteArrayOutputStream byteStream = null;
		byte[] in = null;
		try {
			fis = new FileInputStream(originalFile);
			byteStream = new ByteArrayOutputStream();
			int readLength = -1;
			int bufferSize = 1024;
			byte bytes[] = new byte[bufferSize];
			while ((readLength = fis.read(bytes, 0, bufferSize)) != -1) {
				byteStream.write(bytes, 0, readLength);
			}
			in = byteStream.toByteArray();
		} finally {
			if (byteStream != null) {
				byteStream.flush();
			}
			IOUtils.closeQuietly(fis);
			IOUtils.closeQuietly(byteStream);
		}

		Image inputImage = Toolkit.getDefaultToolkit().createImage(in);
		waitForImage(inputImage);
		int imageWidth = inputImage.getWidth(null);
		if (imageWidth < 1)
			throw new IllegalArgumentException("image width " + imageWidth + " is out of range");
		int imageHeight = inputImage.getHeight(null);
		if (imageHeight < 1)
			throw new IllegalArgumentException("image height " + imageHeight + " is out of range");

		// Create output image.
		if (height == null) {
			float scale = (float) imageWidth / imageHeight;//
			width = imageWidth < width ? imageWidth : width;
			height = (int) (width / scale);
		} else if (width == null) {
			float scale = (float) imageHeight / imageWidth;//
			height = imageHeight < height ? imageHeight : height;
			width = (int) (height / scale);
		} else {
			float scale = getRatio(imageWidth, imageHeight, width, height);
			//scale = 0.5f;
			width = (int) (scale * imageWidth);
			height = (int) (scale * imageHeight);
		}
		Image outputImage = inputImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		checkImage(outputImage);
		encode(resizedFile, outputImage, format);
		return width + "-" + height;
	}

	/**
	 * 获得文件的后缀
	 * 
	 * @param originalFile
	 * @return
	 */
	public static String getFileSuffix(File originalFile) {
		String format = originalFile.getName().substring(originalFile.getName().lastIndexOf(".") + 1, originalFile.getName().length());
		return format;
	}

	/**
	 * 缩放gif图片
	 * 
	 * @param originalFile
	 *            原图片
	 * @param resizedFile
	 *            缩放后的图片
	 * @param newWidth
	 *            宽度
	 *            缩放比例 (等比例)
	 * @throws IOException
	 */
	private static void resizeGif(File originalFile, File resizedFile, Integer newWidth, Integer newHeight) throws Exception {

		ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
		Image i = ii.getImage();
		Image resizedImage = null;
		int iWidth = i.getWidth(null);
		int iHeight = i.getHeight(null);
		float scale = 1;

		if (newHeight == null) {
			scale = (float) iWidth / iHeight;//
			int width = iWidth < newWidth ? iWidth : newWidth;
			int height = (int) (width / scale);
			resizedImage = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		} else {
			scale = getRatio(iWidth, iHeight, newWidth, newHeight);
			int tempWidth = (int) (scale * iWidth);
			int tempheight = (int) (scale * iHeight);
			resizedImage = i.getScaledInstance(tempWidth, tempheight, Image.SCALE_SMOOTH);
		}

		// This code ensures that all the pixels in the image are loaded.
		Image temp = new ImageIcon(resizedImage).getImage();
		// Create the buffered image.
		BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null), temp.getHeight(null), BufferedImage.TYPE_INT_RGB);
		// Copy image to buffered image.
		Graphics g = bufferedImage.createGraphics();
		// Clear background and paint the image.
		g.setColor(Color.white);
		g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
		g.drawImage(temp, 0, 0, null);
		g.dispose();
		// Soften.
		float softenFactor = 0.05f;
		float[] softenArray = { 0, softenFactor, 0, softenFactor, 1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0 };
		Kernel kernel = new Kernel(3, 3, softenArray);
		ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		bufferedImage = cOp.filter(bufferedImage, null);
		// Write the jpeg to a file.

		FileOutputStream out = null;
		try {
			out = new FileOutputStream(resizedFile);
			// Encodes image as a JPEG data stream
			ImageIO.write(bufferedImage,"jpg",out);
		} finally {
			if (out != null) {
				out.flush();
			}
			IOUtils.closeQuietly(out);
		}
	}

	/**
	 * Checks the given image for valid width and height.
	 * 
	 * @throws InterruptedException
	 */
	private static void checkImage(Image image) throws InterruptedException {
		waitForImage(image);
		int imageWidth = image.getWidth(null);
		if (imageWidth < 1)
			throw new IllegalArgumentException("image width " + imageWidth + " is out of range");
		int imageHeight = image.getHeight(null);
		if (imageHeight < 1)
			throw new IllegalArgumentException("image height " + imageHeight + " is out of range");
	}

	/**
	 * Waits for given image to load. Use before querying image height/width/colors.
	 * 
	 * @throws InterruptedException
	 */
	private static void waitForImage(Image image) throws InterruptedException {
		try {
			tracker.addImage(image, 0);
			tracker.waitForID(0);
			tracker.removeImage(image, 0);
		} catch (InterruptedException e) {
			throw new InterruptedException();
		}
	}

	/** Encodes the given image at the given quality to the output stream. */
	private static void encode(File resizedFile, Image outputImage, String format) throws Exception {
		int outputWidth = outputImage.getWidth(null);
		if (outputWidth < 1)
			throw new IllegalArgumentException("output image width " + outputWidth + " is out of range");
		int outputHeight = outputImage.getHeight(null);
		if (outputHeight < 1)
			throw new IllegalArgumentException("output image height " + outputHeight + " is out of range");

		// Get a buffered image from the image.
		BufferedImage bi = new BufferedImage(outputWidth, outputHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D biContext = bi.createGraphics();

		if (format.equalsIgnoreCase("png")) {
			// 增加下面的代码使得背景透明 在这里只适应PNG JPG加这个会出错 -固特殊处理
			bi = biContext.getDeviceConfiguration().createCompatibleImage(outputWidth, outputHeight, Transparency.TRANSLUCENT);
			biContext.dispose();
			biContext = bi.createGraphics();
		}

		biContext.drawImage(outputImage, 0, 0, null);

		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(resizedFile);
			ImageIO.write(bi, format, outputStream);
		} finally {
			if (outputStream != null) {
				outputStream.flush();
			}
			IOUtils.closeQuietly(outputStream);
		}
	}
	
	
	/**
	 * 固定等比例压缩
	 * 
	 *            图片所在目录
	 * @param fileName
	 *            图片名
	 * @param toFileName
	 *            压缩后图片名
	 */
	public static void imageScaleSame(File fileName, File toFileName, int maxWidth, int maxHeight) throws Exception {
		resizeSizer(fileName, toFileName, maxWidth, maxWidth);
		// resizeMagick(fileName, toFileName, maxWidth, null);
	}
	
	/**
	 * @param originalFile
	 *            原图像
	 * @param resizedFile
	 *            压缩后的图像
	 * @param width
	 *            图像宽
	 *            图片格式 jpg, png, gif(非动画)
	 * @throws IOException
	 */
	public static void resizeSizer(File originalFile, File resizedFile, Integer width, Integer height) throws Exception {
		FileUtil.isDir(resizedFile.getParentFile());
		String format = getFileSuffix(originalFile);
		if (format != null && "gif".equals(format.toLowerCase())) {
			resizeGif(originalFile, resizedFile, width, height);
			return;
		}

		FileInputStream fis = null;
		ByteArrayOutputStream byteStream = null;
		byte[] in = null;
		try {
			fis = new FileInputStream(originalFile);
			byteStream = new ByteArrayOutputStream();
			int readLength = -1;
			int bufferSize = 1024;
			byte bytes[] = new byte[bufferSize];
			while ((readLength = fis.read(bytes, 0, bufferSize)) != -1) {
				byteStream.write(bytes, 0, readLength);
			}

			in = byteStream.toByteArray();
		} finally {
			if (byteStream != null) {
				byteStream.flush();
			}
			IOUtils.closeQuietly(fis);
			IOUtils.closeQuietly(byteStream);
		}

		Image inputImage = Toolkit.getDefaultToolkit().createImage(in);
		waitForImage(inputImage);
		int imageWidth = inputImage.getWidth(null);
		if (imageWidth < 1)
			throw new IllegalArgumentException("image width " + imageWidth + " is out of range");
		int imageHeight = inputImage.getHeight(null);
		if (imageHeight < 1)
			throw new IllegalArgumentException("image height " + imageHeight + " is out of range");

		// Create output image.
		if (height == null) {
			float scale = (float) imageWidth / imageHeight;//
			width = imageWidth < width ? imageWidth : width;
			height = (int) (width / scale);
		} else {
			float scale = getRatio(imageWidth, imageHeight, width, height);
			// scale = 2.0f;
			width = (int) (scale * imageWidth);
			height = (int) (scale * imageHeight);
		}

		Image outputImage = inputImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		checkImage(outputImage);
		encode(resizedFile, outputImage, format);
	}

	public static int getWidth(String url){
		int width = 0;
		try {
			BufferedImage bufferedImage = ImageIO.read(new File(url));
			width = bufferedImage.getWidth();
			bufferedImage.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return width;
	}
	public static int getHeight(String url){
		int height = 0;
		try {
			BufferedImage bufferedImage = ImageIO.read(new File(url));
			height = bufferedImage.getHeight();
			bufferedImage.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return height;
	}
	
	public static boolean compressPic(String srcFilePath, String descFilePath)  
    {  
        File file = null;  
        BufferedImage src = null;  
        FileOutputStream out = null;  
        ImageWriter imgWrier;  
        ImageWriteParam imgWriteParams;  
  
        // 指定写图片的方式为 jpg  
        imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();
        imgWriteParams = new javax.imageio.plugins.jpeg.JPEGImageWriteParam(null);  
        // 要使用压缩，必须指定压缩方式为MODE_EXPLICIT  
        imgWriteParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);  
        // 这里指定压缩的程度，参数qality是取值0~1范围内，  
        imgWriteParams.setCompressionQuality((float)0.5);
        imgWriteParams.setProgressiveMode(ImageWriteParam.MODE_DISABLED);
        try  
        {  
            if(StringUtils.isBlank(srcFilePath))  
            {  
                return false;  
            }  
            else  
            {  
                file = new File(srcFilePath);  
                src = ImageIO.read(file);  
                out = new FileOutputStream(descFilePath);  
  
                imgWrier.reset();  
                // 必须先指定 out值，才能调用write方法, ImageOutputStream可以通过任何 OutputStream构造  
                imgWrier.setOutput(ImageIO.createImageOutputStream(out));  
                // 调用write方法，就可以向输入流写图片  
                imgWrier.write(null, new IIOImage(src, null, null), imgWriteParams);  
                out.flush();  
                out.close();  
            }  
        }  
        catch(Exception e)  
        {  
            e.printStackTrace();
            return false;  
        }  
        return true;  
    }  
}
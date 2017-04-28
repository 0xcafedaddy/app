package com.util.skye;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FileNameUtil {

	public static String getFileName(String path){
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//图片名
		String name = df.format(new Date());
		
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			name += r.nextInt(10);
		}
		return path+"/"+name;
	}
}

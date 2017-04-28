package com.util.ctvit.gather;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wll
 * @date 2015-8-17 
 * 计算文件的md5值
 * */
public class FileDigest {

	/**
	 * 获取单个文件的MD5值！
	 * 
	 * @return
	 */

	public static String getStrMD5(String str)
	{
		MessageDigest digest;
		StringBuilder sb = null;
		try {
			digest = MessageDigest.getInstance("MD5");
			byte[] bs = digest.digest(str.getBytes());
	        sb = new StringBuilder(40);
	        for(byte x:bs) {
	            if((x & 0xff)>>4 == 0) {
	                sb.append("0").append(Integer.toHexString(x & 0xff));
	            } else {
	                sb.append(Integer.toHexString(x & 0xff));
	            }
	        }
		} catch (NoSuchAlgorithmException e) {
			// 
			e.printStackTrace();
		}
		
        return sb.toString();
	}
	public static String getFileMD5(File file) {
		if (!file.isFile()) {
			return null;
		}
		MessageDigest digest = null;
		FileInputStream in = null;
		byte buffer[] = new byte[1024];
		int len;
		try {
			digest = MessageDigest.getInstance("MD5");
			in = new FileInputStream(file);
			while ((len = in.read(buffer, 0, 1024)) != -1) {
				digest.update(buffer, 0, len);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		BigInteger bigInt = new BigInteger(1, digest.digest());
		return bigInt.toString(16);
	}
	/**
	   * 获取文件夹中文件的MD5值
	   * @param file 目录
	   * @param listChild ;true递归子目录中的文件
	   * @return
	   */
	  public static Map<String, String> getDirMD5(File file,boolean listChild) {
	    if(!file.isDirectory()){
	      return null;
	    }
	    //<filepath,md5>
	    Map<String, String> map=new HashMap<String, String>();
	    String md5;
	    File files[]=file.listFiles();
	    for(int i=0;i<files.length;i++){
	      File f=files[i];
	      if(f.isDirectory()&&listChild){
	        map.putAll(getDirMD5(f, listChild));
	      } else {
	        md5=getFileMD5(f);
	        if(md5!=null){
	          map.put(f.getPath(), md5);
	        }
	      }
	    }
	    return map;
	  }
	  
}

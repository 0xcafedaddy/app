package com.uflowertv.util;

/**
 * 
 * 版权所有：2017年2月23日-油菜花
 * 项目名称：uflowertv_wx   
 *
 * 类描述：生成16位随机字符串
 * 类名称：com.uflowertv.util.RandomUtils     
 * 创建人：liguoliang 
 * 创建时间：2017年2月23日 下午5:09:46   
 * 修改人：
 * 修改时间：2017年2月23日 下午5:09:46   
 * 修改备注：   
 * @version   V1.0
 */
public class RandomUtils {

	 private static final String RANDOM_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	 private static final java.util.Random RANDOM = new java.util.Random();
	
	 public static String getRandomStr() {
	   StringBuilder sb = new StringBuilder();
	   for (int i = 0; i < 16; i++) {
	      sb.append(RANDOM_STR.charAt(RANDOM.nextInt(RANDOM_STR.length())));
	   }
	   return sb.toString();
	 }
	public static void main(String[] args) {
		String randomStr = RandomUtils.getRandomStr();
		System.out.println(randomStr);
	}
}

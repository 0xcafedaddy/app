package com.util.random;

import java.util.Random;
import java.util.UUID;

/**
 * 
 * 版权所有：2017年2月23日-油菜花
 * 项目名称：uflowertv_wx   
 *
 * 类描述：GUIDUtil
 * 类名称：com.uflowertv.util.GUIDUtil     
 * 创建人：liguoliang 
 * 创建时间：2017年2月23日 下午5:43:36   
 * 修改人：
 * 修改时间：2017年2月23日 下午5:43:36   
 * 修改备注：   
 * @version   V1.0
 */
public class GUIDUtil {
	public static String get() {
		return get(true);
	}

	public static String get(boolean withoutBar) {
		String id = UUID.randomUUID().toString();
		if (withoutBar)
			id = id.replaceAll("-", "");
		return id;
	}
	
	public static String getId(String _tvid,String _channel) {
		//long result = 0;
		long id = 0;
		String total = "";
		id = System.currentTimeMillis();
		Random random = new Random();
		int ranNum = random.nextInt(1000);
		if (ranNum < 10) {
			total = _tvid+ "-" + _channel+ "-" + id + "00" + ranNum;
		} else if (ranNum < 100){
			total = _tvid+ "-" + _channel+ "-" + id + "0" + ranNum;
		} else {
			total = _tvid+ "-" + _channel+ "-" + id + ranNum;
		}
		//result = Long.parseLong(total);
		return total;
	}
	
	public synchronized static String getId() {
//		long result = 0;
		long id = 0;
		String total = "";
		id = System.currentTimeMillis();
		Random random = new Random();
		int ranNum = random.nextInt(1000);
		if (ranNum < 10) {
			total = "" + id + "00" + ranNum;
		} else if (ranNum < 100){
			total = "" + id + "0" + ranNum;
		} else {
			total = "" + id + ranNum;
		}
//		result = Long.parseLong(total);
		return total;
	}

}
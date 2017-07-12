package com.util.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Redis本身没有存取对象的功能，而是有存取byte数据的功能，我们可以对要存取的对象进行序列化后，进行操作
 * 
 * @author Mrchang
 *
 * @time 2016年6月24日 e下午1:59:42
 */
public class SerializeUtil {
	/**
	 * 序列化
	 * 
	 * @param object
	 */
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			oos.flush();
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 反序列化
	 * 
	 * @param bytes
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static Object unserialize(byte[] bytes) {
		if(null==bytes){
			return null;
		}
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

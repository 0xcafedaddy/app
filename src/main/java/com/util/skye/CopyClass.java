package com.util.skye;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CopyClass {
	/**
	 * 
	 * @param o1 新对象
	 * @param o2 要覆盖的对象
	 */
	public static void copyPriperties(Object o1, Object o2) {

		String fileName, str, getName, setName;
		List fields = new ArrayList();
		Method getMethod = null;
		Method setMethod = null;
		try {
			Class c1 = o1.getClass();
			Class c2 = o2.getClass();

			Field[] fs1 = c1.getDeclaredFields();
			Field[] fs2 = c2.getDeclaredFields();
			// ���������ԱȽ��޳���ͬ�����ԣ�ֻ������ͬ������
			for (int i = 0; i < fs2.length; i++) {
				for (int j = 0; j < fs1.length; j++) {
					if (fs1[j].getName().equals(fs2[i].getName())) {
						fields.add(fs1[j]);
						break;
					}
				}
			}
			if (null != fields && fields.size() > 0) {
				for (int i = 0; i < fields.size(); i++) {
					// ��ȡ�������
					Field f = (Field) fields.get(i);
					fileName = f.getName();
					// �������һ����ĸ��д
					str = fileName.substring(0, 1).toUpperCase();
					// ƴ��getXXX��setXXX������
					getName = "get" + str + fileName.substring(1);
					setName = "set" + str + fileName.substring(1);
					// ��ȡget��set����
					getMethod = c1.getMethod(getName, new Class[] {});
					setMethod = c2.getMethod(setName,
							new Class[] { f.getType() });

					// ��ȡ����ֵ
					Object o = getMethod.invoke(o1, new Object[] {});
					System.out.println(fileName + " : " + o);
					// ������ֵ������һ�������ж�Ӧ������
					if (null != o) {
						//System.out.println("o2.setMethod = " + setMethod);
						setMethod.invoke(o2, new Object[] { o });
					}
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}

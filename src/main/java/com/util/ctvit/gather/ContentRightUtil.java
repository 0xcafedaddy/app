package com.util.ctvit.gather;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ContentRightUtil {

	/**
	 * 
	 * @param list	过滤的数据源
	 * @param userId 用户id
	 * @param userIdfield 用户id的属性值，因为不同表存储用户id的数据库字段不同
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 */
	public static int filterListDataByuserRightsCount(List<?> list,String userId,String userIdfield) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException
	{
		return filterListDataByuserRights(list, userId,userIdfield).size();
	}
	/***
	 * 传入list 根据用户权限过滤指定数据源
	 * @param list 数据源
	 * @param userId 当前用户id
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 */
	public static List filterListDataByuserRights(List<?> list,String userId,String userIdfield) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException
	{
		List currentOrgList = new ArrayList();
		if(list != null && list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				Object obj = list.get(i);
				Class cls = list.get(i).getClass();
				Field[] field = cls.getDeclaredFields();
				String userIdTemp = (String) cls.getField(userIdfield).get(cls.getName());
				String isshare = (String) cls.getField("isshare").get(cls.getName());
				if(!"".equals(isshare) && isshare.equals("1"))
				{
					currentOrgList.add(obj);
				}
				else if(userIdTemp == userId)
				{
					currentOrgList.add(obj);
					
				}
			}
		}
		return currentOrgList;
		
	}
}

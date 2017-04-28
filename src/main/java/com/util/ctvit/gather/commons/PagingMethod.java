package com.util.ctvit.gather.commons;

import java.util.List;



public interface PagingMethod {
	
/**
 * 分页方法
 * */
	public abstract <T> List selectPageByExample(T clazz);
	/**
	 * 添加权限过滤分页
	 * */
	public abstract  <T> List selectPageByExampleWithRight(T clazz);
	
	/**
	 * 内容权限统计方法
	 * */
	public abstract <T> List myCountByExamplewithRight(T clazz);
	
}

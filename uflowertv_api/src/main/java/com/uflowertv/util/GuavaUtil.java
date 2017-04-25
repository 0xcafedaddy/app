package com.uflowertv.util;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

/**
 * 站在巨人的肩上造轮子
 * @author Administrator
 *
 */
public class GuavaUtil {

	/**
	 * 两List差集
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static <T> List<T> getListDifferent(List<T> t1,List<T> t2){
		SetView<T> difference = Sets.difference(Sets.newHashSet(t1), Sets.newHashSet(t2));
		return Lists.newArrayList(difference);
		
	}
	
	/**
	 * 两List交集
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static <T> List<T> getListIntersection(List<T> t1,List<T> t2){
		SetView<T> intersection = Sets.intersection(Sets.newHashSet(t1), Sets.newHashSet(t2));
		return Lists.newArrayList(intersection);
		
	}
	/**
	 * 两List并集
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static <T> List<T> getListUnion(List<T> t1,List<T> t2){
		SetView<T> union = Sets.union(Sets.newHashSet(t1), Sets.newHashSet(t2));
		return Lists.newArrayList(union);
	}
	
	/**
	 * 两个Map的差集
	 * @param map1
	 * @param map2
	 * @return
	 */
	public static Map<Object, Object> getMapDifference(Map<Object, Object> map1,Map<Object, Object> map2) {
		SetView<Object> difference = Sets.difference(map1.keySet(), map2.keySet());
		Map<Object, Object> newResult = Maps.newHashMap();
		difference.forEach(key->{newResult.put(key, map1.get(key));});
		return newResult;
	}
	
	/**
	 * 两个Map的交集
	 * @param map1
	 * @param map2
	 * @return
	 */
	public static Map<Object, Object> getMapIntersection(Map<Object, Object> map1,Map<Object, Object> map2) {
		SetView<Object> intersection = Sets.intersection(map1.keySet(), map2.keySet());
		Map<Object, Object> newResult = Maps.newHashMap();
		intersection.forEach(key->{newResult.put(key, map1.get(key));});
		return newResult;
	}
	
	/**
	 * 两个Map的并集
	 * @param map1
	 * @param map2
	 * @return
	 */
	public static Map<Object, Object> getMapUnion(Map<Object, Object> map1,Map<Object, Object> map2) {
		SetView<Object> union = Sets.union(map1.keySet(), map2.keySet());
		Map<Object, Object> newResult = Maps.newHashMap();
		union.forEach(key->{newResult.put(key, map1.get(key));});
		return newResult;
	}
}
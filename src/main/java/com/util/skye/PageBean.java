package com.util.skye;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public class PageBean<T> {

	//分页条件
	private int page;//当前页码
	private int pageSize;//每页显示记录数
	private DetachedCriteria detachedCriteria;//封装查询条件
	//分页结果
	private long total;//总记录数
	private List<T> rows;//当前页展示的数据集合
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}
	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	
}

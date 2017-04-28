package com.util.ctvit.gather.commons;


public class PagingInterface {
	/**
	 * 分页属性
	 * */
	private int pageSize;//单页个数
    private int recordIndex;//下标
    private String userid;
    private String orderExample;//排序方式
    private String orderByClause;//排序字段
    private int isShare; 
    
    /*private List<String> groupByList;//group by 字段   mybatis 查询结果异常
	public List<String> getGroupByList() {
		return groupByList;
	}
	public void setGroupByList(List<String> groupByList) {
		this.groupByList = groupByList;
	}*/
    
    
	public String getOrderByClause() {
		return orderByClause;
	}
	public int getIsShare() {
		return isShare;
	}
	public void setIsShare(int isShare) {
		this.isShare = isShare;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
	public String getOrderExample() {
		return orderExample;
	}
	public void setOrderExample(String orderExample) {
		this.orderExample = orderExample;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordIndex() {
		return recordIndex;
	}
	public void setRecordIndex(int recordIndex) {
		this.recordIndex = recordIndex;
	}
    
}

package com.uflowertv.statistics.util;

import java.util.List;

public class PageUtil<T> {

   private int pageSize; // 每页显示多少条记录
     
    private int currentPage; //当前第几页数据
     
    private int totalRecord; // 一共多少条记录
     
    private int totalPage; // 一共多少页记录
     
    private List<T> dataList; //要显示的数据
     
    public PageUtil(int pageNum, int pageSize, List<T> sourceList){
        if(sourceList == null || sourceList.isEmpty()){
            return;
        }
        // 总记录条数
        this.totalRecord = sourceList.size();
         
        // 每页显示多少条记录
        this.pageSize = pageSize;
         
        //获取总页数
        this.totalPage = this.totalRecord / this.pageSize;
        if(this.totalRecord % this.pageSize !=0){
            this.totalPage = this.totalPage + 1;
        }
        // 当前第几页数据
        this.currentPage = this.totalPage < pageNum ?  this.totalPage : pageNum;
                 
        // 起始索引
        int fromIndex   = this.pageSize * (this.currentPage -1);
         
        // 结束索引
        int toIndex  = this.pageSize * this.currentPage > this.totalRecord ? this.totalRecord : this.pageSize * this.currentPage;
                 
        this.dataList = sourceList.subList(fromIndex, toIndex);
    }
    
	/**
	* pages页数
	* @param <T>
	* */
	public static <T> int pages(List<T> infoList,int size){
		int pages = infoList.size()/size;
		int lastPage = infoList.size()%size;
		if(lastPage>0){
			pages = pages+1;
		}
		return pages;
	}
	/**
	* 分页新闻
	* @param <T>
	* */
	public static <T> List<T> currentPages(int currentPage,List<T> infoList,int size){
		int infoSize = infoList.size();//新闻总长
		int firstInfo = currentPage*size;//起始位置
		int toIndex = firstInfo+size;//结束位置
		int currentSize = infoSize - firstInfo;//第N页后长度
		if(currentSize<size){//长度大于size则截取长度为size条。如果小于size则截取条数为当前长度
			toIndex = firstInfo + currentSize;//起始位置+当前长度为截取长度
		}
		List<T> currentList =infoList.subList(firstInfo, toIndex);
		return currentList;
	}
	 /**  
     * 对list集合进行分页处理  
     *   
     * @return  
     */  
   /* private List<E> ListSplit(List<E> list) {  
        List<E> newList=null;  
        total=list.size();  
        newList=list.subList(rows*(page-1), ((rows*page)>total?total:(rows*page)));  
        return newList;  
    }  */
	
	
	/*int totalPages = (int) Math.ceil(totalResults / pageSize);
	// show first page by default
	int first = 0;
	if (currentPage >= 0 && currentPage < totalPages) {
	    first = currentPage * pageSize;    
	}
	// the number of items on the page might be less than the page size
	int count = Math.min(pageSize, totalResults - first);     */
}

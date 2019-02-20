package com.guhecloud.rudez.npmarket.commonmodel.http.response.page;



/**
 * 分页实体类
 * @author QingLong
 * @date 2011/03/10
 */
public class PageInfo  {
	
	private static final long serialVersionUID = -6204819767511355561L;
	/**
	 * 判断上一页
	 */
	private boolean hasPrevPage;
	/**
	 * 判断下一页
	 */
	private boolean hasNextPage;
	/**
	 * 总记录数量
	 */
	private int totalData;
	/**
	 * 总页码数量
	 */
	private int totalPage;
	/**
	 * 每页记录数
	 */
	private int everyPage;
	/**
	 * 当前页码号
	 */
	private int currentNo;
	/**
	 * 起始位置数
	 */
	private int beginIndex;
	/**
	 * 截止位置数
	 */
	private int closeIndex;
	
	/** 
	 * 默认构造函数
	 * */
	public PageInfo() {
		super();
	}
	
	/**
	 * 含参构造函数
	 */
	public PageInfo(int everyPage, int currentNo) {
		this.everyPage = everyPage;
		this.currentNo = currentNo;
	}
	
	/** 
	 * 含参构造函数
	 * */
	public PageInfo(boolean hasPrevPage, boolean hasNextPage, int totalData, int totalPage, int everyPage, int currentNo, int beginIndex, int closeIndex) {
		this.hasPrevPage = hasPrevPage;
		this.hasNextPage = hasNextPage;
		this.totalData = totalData;
		this.totalPage = totalPage;
		this.everyPage = everyPage;
		this.currentNo = currentNo;
		this.beginIndex = beginIndex;
		this.closeIndex = closeIndex;
	}
	
	public boolean isHasPrevPage() {
		return hasPrevPage;
	}
	public void setHasPrevPage(boolean hasPrevPage) {
		this.hasPrevPage = hasPrevPage;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public int getTotalData() {
		return totalData;
	}
	public void setTotalData(int totalData) {
		this.totalData = totalData;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getEveryPage() {
		return everyPage;
	}
	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}
	public int getCurrentNo() {
		return currentNo;
	}
	public void setCurrentNo(int currentNo) {
		this.currentNo = currentNo;
	}
	public int getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	public int getCloseIndex() {
		return closeIndex;
	}
	public void setCloseIndex(int closeIndex) {
		this.closeIndex = closeIndex;
	}
}
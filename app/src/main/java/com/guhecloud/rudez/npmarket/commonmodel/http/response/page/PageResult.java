package com.guhecloud.rudez.npmarket.commonmodel.http.response.page;

import java.util.List;


/**
 * 分页结果集
 * @author QingLong
 * @date 2011/03/10
 */
@SuppressWarnings("rawtypes")
public class PageResult<T>{
	
	private static final long serialVersionUID = 1448530714566815240L;
	/**
	 * 分页实体类
	 */
	private PageInfo page;
	/**
	 * 分页结果集
	 */
	private List<T> list;
	
	/**
	 * 默认构造函数
	 */
	public PageResult() {
		super();
	}
	
	/**
	 * 含参构造函数
	 */
	public PageResult(PageInfo page, List<T> list) {
		this.page = page;
		this.list = list;
	}
	
	public PageInfo getPage() {
		return page;
	}
	public void setPage(PageInfo page) {
		this.page = page;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
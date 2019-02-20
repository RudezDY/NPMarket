package com.guhecloud.rudez.npmarket.commonmodel.http.response.page;


/**
 * 分页工具类
 * @author QingLong
 * @date 2011/03/10
 */
public class PageUtil  {
	
	private static final long serialVersionUID = -7686208863658487753L;

	/**
	 * 创建分页实体
	 * @param everyPage 每页记录数
	 * @param currentNo 当前页码号
	 * @param totalData 总记录数量
	 * @return Page
	 */
	public static PageInfo createPage(int everyPage, int currentNo, int totalData) {
		everyPage = getEveryPage(everyPage);
		if (everyPage > 99) everyPage = 99;
		int totalPage = getTotalPage(everyPage, totalData);
		if (currentNo > totalPage) currentNo = totalPage;
		currentNo = getCurrentPage(currentNo);
		int beginIndex = getBeginIndex(everyPage, currentNo);
		int closeIndex = getCloseIndex(everyPage, currentNo);
		if (closeIndex > totalData) closeIndex = totalData;
		boolean hasNextPage = hasNextPage(currentNo, totalPage);
		boolean hasPrevPage = hasPrevPage(currentNo);
		return new PageInfo(hasPrevPage,hasNextPage,totalData,totalPage,everyPage,currentNo,beginIndex,closeIndex);
	}
	
	private static int getEveryPage(int everyPage) {
		return everyPage == 0 ? 1 : everyPage;
	}

	private static int getCurrentPage(int currentNo) {
		return currentNo == 0 ? 1 : currentNo;
	}

	private static int getBeginIndex(int everyPage, int currentNo) {
		return (currentNo - 1) * everyPage;
	}
	
	private static int getCloseIndex(int everyPage, int currentNo) {
		return currentNo * everyPage;
	}

	public static int getTotalPage(int everyPage, int totalData) {
		int totalPage = 0;
		if (totalData % everyPage == 0){
			totalPage = totalData / everyPage;
		} else{
			totalPage = totalData / everyPage + 1;
		}
		return totalPage;
	}
	
	private static boolean hasPrevPage(int currentNo) {
		return currentNo == 1 ? false : true;
	}
	
	private static boolean hasNextPage(int currentNo, int totalPage) {
		return currentNo == totalPage || totalPage == 0 ? false : true;
	}
}
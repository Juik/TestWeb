package com.pb.vo;

import java.util.List;

public class Page {
	private int currentPage;
	private int previousPage;
	private int nextPage;
	private int totalPage;
	private int totalCount;
	private int pageSize;
	private List currentPageData;
	private String[] keyWords;

	public String[] getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String[] keyWords) {
		this.keyWords = keyWords;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List getCurrentPageData() {
		return currentPageData;
	}

	public void setCurrentPageData(List currentPageData) {
		this.currentPageData = currentPageData;
	}

}

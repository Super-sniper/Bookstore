package com.bookstore.bean;

public class QueryInfo {
	private int currentPage = 1;
	private int startIndex ;
	private int pageSize = 6;
	
	private String queryName;
	private String queryvalue;
	private String where;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartIndex() {
		 this.startIndex = (this.currentPage-1)*(this.pageSize);
		 return startIndex;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getQueryName() {
		return queryName;
	}
	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}
	public String getQueryvalue() {
		return queryvalue;
	}
	public void setQueryvalue(String queryvalue) {
		this.queryvalue = queryvalue;
	}
	public String getWhere() {
		if(this.queryName==null||this.queryName.trim().equals("")){
			return "";
		}else{
			this.where = "where "+queryName+"=?";
		}
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	
	
}

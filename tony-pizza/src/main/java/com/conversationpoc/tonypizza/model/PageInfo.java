package com.conversationpoc.tonypizza.model;

public class PageInfo {

	private String currentPage;
	private FormInfo formInfo;
	
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public FormInfo getFormInfo() {
		return formInfo;
	}
	public void setFormInfo(FormInfo formInfo) {
		this.formInfo = formInfo;
	}
}

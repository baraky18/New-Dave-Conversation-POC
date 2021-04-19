package com.conversationpoc.tonypizza.model;

public class WebhookResponse {

	private FulfillmentResponse fulfillmentResponse;
	private PageInfo pageInfo;
	private SessionInfo sessionInfo;
	private Struct payload;
	private String transition;
	
	public FulfillmentResponse getFulfillmentResponse() {
		return fulfillmentResponse;
	}
	public void setFulfillmentResponse(FulfillmentResponse fulfillmentResponse) {
		this.fulfillmentResponse = fulfillmentResponse;
	}
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public SessionInfo getSessionInfo() {
		return sessionInfo;
	}
	public void setSessionInfo(SessionInfo sessionInfo) {
		this.sessionInfo = sessionInfo;
	}
	public Struct getPayload() {
		return payload;
	}
	public void setPayload(Struct payload) {
		this.payload = payload;
	}
	public String getTransition() {
		return transition;
	}
	public void setTransition(String transition) {
		this.transition = transition;
	}
}

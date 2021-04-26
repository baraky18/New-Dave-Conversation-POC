package com.conversationpoc.tonypizza.model;


public class WebhookRequest {

	private String detectIntentResponseId;
	private String languageCode;
	private FulfillmentInfo fulfillmentInfo;
	private IntentInfo intentInfo;
	private PageInfo pageInfo;
	private SessionInfo sessionInfo;
	private ResponseMessage[] messages;
	private Struct payload;
	private SentimentAnalysisResult sentimentAnalysisResult;
	private String query;
	
	public String getDetectIntentResponseId() {
		return detectIntentResponseId;
	}
	public void setDetectIntentResponseId(String detectIntentResponseId) {
		this.detectIntentResponseId = detectIntentResponseId;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public FulfillmentInfo getFulfillmentInfo() {
		return fulfillmentInfo;
	}
	public void setFulfillmentInfo(FulfillmentInfo fulfillmentInfo) {
		this.fulfillmentInfo = fulfillmentInfo;
	}
	public IntentInfo getIntentInfo() {
		return intentInfo;
	}
	public void setIntentInfo(IntentInfo intentInfo) {
		this.intentInfo = intentInfo;
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
	public ResponseMessage[] getMessages() {
		return messages;
	}
	public void setMessages(ResponseMessage[] messages) {
		this.messages = messages;
	}
	public Struct getPayload() {
		return payload;
	}
	public void setPayload(Struct payload) {
		this.payload = payload;
	}
	public SentimentAnalysisResult getSentimentAnalysisResult() {
		return sentimentAnalysisResult;
	}
	public void setSentimentAnalysisResult(SentimentAnalysisResult sentimentAnalysisResult) {
		this.sentimentAnalysisResult = sentimentAnalysisResult;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
}

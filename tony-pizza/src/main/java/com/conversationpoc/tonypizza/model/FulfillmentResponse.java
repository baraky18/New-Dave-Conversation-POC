package com.conversationpoc.tonypizza.model;

public class FulfillmentResponse {

	private ResponseMessage[] messages;
	private MergeBehavior mergeBehavior;
	
	public ResponseMessage[] getMessages() {
		return messages;
	}
	public void setMessages(ResponseMessage[] messages) {
		this.messages = messages;
	}
	public MergeBehavior getMergeBehavior() {
		return mergeBehavior;
	}
	public void setMergeBehavior(MergeBehavior mergeBehavior) {
		this.mergeBehavior = mergeBehavior;
	}
}

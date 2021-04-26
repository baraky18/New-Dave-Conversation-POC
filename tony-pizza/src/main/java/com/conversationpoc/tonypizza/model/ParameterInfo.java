package com.conversationpoc.tonypizza.model;

import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class ParameterInfo {

	private String displayName;
	private boolean required;
	private ParameterState state;
	private Object value;
	private boolean justCollected;
	
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public ParameterState getState() {
		return state;
	}
	public void setState(ParameterState state) {
		this.state = state;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public boolean isJustCollected() {
		return justCollected;
	}
	public void setJustCollected(boolean justCollected) {
		this.justCollected = justCollected;
	}
}

package com.conversationpoc.tonypizza.model;

public class IntentParameterValue {

	private String originalValue;
	private Object resolvedValue;
	
	public String getOriginalValue() {
		return originalValue;
	}
	public void setOriginalValue(String originalValue) {
		this.originalValue = originalValue;
	}
	public Object getResolvedValue() {
		return resolvedValue;
	}
	public void setResolvedValue(Object resolvedValue) {
		this.resolvedValue = resolvedValue;
	}
}

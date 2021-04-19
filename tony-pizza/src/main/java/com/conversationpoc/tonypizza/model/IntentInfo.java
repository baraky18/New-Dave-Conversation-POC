package com.conversationpoc.tonypizza.model;

import java.util.Map;

public class IntentInfo {

	private String last_matched_intent;
	private String display_name;
	private Map<String, IntentParameterValue> parameters;
	private float confidence;
	
	public String getLast_matched_intent() {
		return last_matched_intent;
	}
	public void setLast_matched_intent(String last_matched_intent) {
		this.last_matched_intent = last_matched_intent;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public Map<String, IntentParameterValue> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, IntentParameterValue> parameters) {
		this.parameters = parameters;
	}
	public float getConfidence() {
		return confidence;
	}
	public void setConfidence(float confidence) {
		this.confidence = confidence;
	}
}

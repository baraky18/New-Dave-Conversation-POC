package com.conversationpoc.tonypizza.model;

import java.util.Map;

public class SessionInfo {

	private String session;
	private Map<String, Object> parameters;
	
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public Map<String, Object> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
}

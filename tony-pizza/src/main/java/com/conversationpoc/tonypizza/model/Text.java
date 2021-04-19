package com.conversationpoc.tonypizza.model;

public class Text {

	private String[] text;
	private boolean allowPlaybackInterruption;
	
	public String[] getText() {
		return text;
	}
	public void setText(String[] text) {
		this.text = text;
	}
	public boolean isAllowPlaybackInterruption() {
		return allowPlaybackInterruption;
	}
	public void setAllowPlaybackInterruption(boolean allowPlaybackInterruption) {
		this.allowPlaybackInterruption = allowPlaybackInterruption;
	}
}

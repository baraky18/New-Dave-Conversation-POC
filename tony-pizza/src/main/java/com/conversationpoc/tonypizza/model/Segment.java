package com.conversationpoc.tonypizza.model;

public class Segment {

	private boolean allowPlaybackInterruption;
	private String content;
	
	public boolean isAllowPlaybackInterruption() {
		return allowPlaybackInterruption;
	}
	public void setAllowPlaybackInterruption(boolean allowPlaybackInterruption) {
		this.allowPlaybackInterruption = allowPlaybackInterruption;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}

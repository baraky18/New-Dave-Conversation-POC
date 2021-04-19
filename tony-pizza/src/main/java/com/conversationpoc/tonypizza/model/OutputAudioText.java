package com.conversationpoc.tonypizza.model;

public class OutputAudioText {

	private boolean allowPlaybackInterruption;
	private String source;
	
	public boolean isAllowPlaybackInterruption() {
		return allowPlaybackInterruption;
	}
	public void setAllowPlaybackInterruption(boolean allowPlaybackInterruption) {
		this.allowPlaybackInterruption = allowPlaybackInterruption;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
}

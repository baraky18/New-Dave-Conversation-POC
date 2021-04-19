package com.conversationpoc.tonypizza.model;

public class PlayAudio {

	private String audioUri;
	private boolean allowPlaybackInterruption;
	
	public String getAudioUri() {
		return audioUri;
	}
	public void setAudioUri(String audioUri) {
		this.audioUri = audioUri;
	}
	public boolean isAllowPlaybackInterruption() {
		return allowPlaybackInterruption;
	}
	public void setAllowPlaybackInterruption(boolean allowPlaybackInterruption) {
		this.allowPlaybackInterruption = allowPlaybackInterruption;
	}
}

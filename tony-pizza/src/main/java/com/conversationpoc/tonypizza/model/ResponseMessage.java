package com.conversationpoc.tonypizza.model;

public class ResponseMessage {

	private Text text;
	private Struct payload;
	private ConversationSuccess conversationSuccess;
	private OutputAudioText outputAudioText;
	private LiveAgentHandoff liveAgentHandoff;
	private EndInteraction endInteraction;
	private PlayAudio playAudio;
	private MixedAudio mixedAudio;
	
	public Text getText() {
		return text;
	}
	public void setText(Text text) {
		this.text = text;
	}
	public Struct getPayload() {
		return payload;
	}
	public void setPayload(Struct payload) {
		this.payload = payload;
	}
	public ConversationSuccess getConversationSuccess() {
		return conversationSuccess;
	}
	public void setConversationSuccess(ConversationSuccess conversationSuccess) {
		this.conversationSuccess = conversationSuccess;
	}
	public OutputAudioText getOutputAudioText() {
		return outputAudioText;
	}
	public void setOutputAudioText(OutputAudioText outputAudioText) {
		this.outputAudioText = outputAudioText;
	}
	public LiveAgentHandoff getLiveAgentHandoff() {
		return liveAgentHandoff;
	}
	public void setLiveAgentHandoff(LiveAgentHandoff liveAgentHandoff) {
		this.liveAgentHandoff = liveAgentHandoff;
	}
	public EndInteraction getEndInteraction() {
		return endInteraction;
	}
	public void setEndInteraction(EndInteraction endInteraction) {
		this.endInteraction = endInteraction;
	}
	public PlayAudio getPlayAudio() {
		return playAudio;
	}
	public void setPlayAudio(PlayAudio playAudio) {
		this.playAudio = playAudio;
	}
	public MixedAudio getMixedAudio() {
		return mixedAudio;
	}
	public void setMixedAudio(MixedAudio mixedAudio) {
		this.mixedAudio = mixedAudio;
	}
}

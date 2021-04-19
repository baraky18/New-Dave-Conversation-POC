package com.conversationpoc.tonypizza.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conversationpoc.tonypizza.model.WebhookRequest;
import com.conversationpoc.tonypizza.model.WebhookResponse;


@RestController
@RequestMapping("/conversation-poc/tony-pizza")
public class WebhookController {

	@RequestMapping(value="/is-total-declared-amount-greater-than-total-amount", method=RequestMethod.POST)
	public WebhookResponse helloWorld(@RequestBody WebhookRequest webhookRequest){
		System.out.println("-----session is: " + webhookRequest.getSessionInfo().getSession() + "-----");
		System.out.println("-----parameters are: " + webhookRequest.getSessionInfo().getParameters() + "-----");
		return new WebhookResponse();
	}
}

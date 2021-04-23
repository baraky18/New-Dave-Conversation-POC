package com.conversationpoc.tonypizza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conversationpoc.tonypizza.model.WebhookRequest;
import com.conversationpoc.tonypizza.model.WebhookResponse;
import com.conversationpoc.tonypizza.services.WebhookService;


@RestController
@RequestMapping("/conversation-poc/tony-pizza")
public class WebhookController {

	@Autowired
	public WebhookService webhookService;
	
	@RequestMapping(value="/is-total-declared-amount-greater-than-total-amount", method=RequestMethod.POST)
	public WebhookResponse isTotalDeclaredAmountGreaterThanTotalAmount(@RequestBody WebhookRequest webhookRequest){
		System.out.println("controller: " + webhookRequest.getSessionInfo());
		System.out.println("controller: " + webhookRequest.getSessionInfo().getParameters());
		System.out.println("controller: " + webhookRequest.getSessionInfo().getSession());
		return webhookService.isTotalDeclaredAmountGreaterThanTotalAmount(webhookRequest);
	}
	
	
	@RequestMapping(value="/is-total-declared-amount-changed", method=RequestMethod.POST)
	public WebhookResponse isTotalDeclaredAmountChanged(@RequestBody WebhookRequest webhookRequest){
		System.out.println("controller: " + webhookRequest.getSessionInfo());
		System.out.println("controller: " + webhookRequest.getSessionInfo().getParameters());
		System.out.println("controller: " + webhookRequest.getSessionInfo().getSession());
//		return webhookService.isTotalDeclaredAmountGreaterThanTotalAmount(webhookRequest);
		return new WebhookResponse();
	}

}

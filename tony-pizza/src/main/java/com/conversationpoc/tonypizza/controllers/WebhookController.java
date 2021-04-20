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
		System.out.println("-----totalAmount is: " + webhookRequest.getSessionInfo().getParameters().get("totalAmount").toString() + "-----");
		//-----parameters are: {drinkorder=[{original=soda, drink=soda}], pizzasize=[large], pizzatype=[napolitana], totalAmount=1, totalDeclaredAmount=1}-----
		String[] totalAmount = (String[]) webhookRequest.getSessionInfo().getParameters().get("totalAmount");
		double totalAmountAsDouble = 0;
		for(int i=0; i<totalAmount.length; i++){
			totalAmountAsDouble += (Double.parseDouble(totalAmount[i]));
		}
		 
		
		if(totalAmountAsDouble < 
				Double.parseDouble((String)webhookRequest.getSessionInfo().getParameters().get("totalDeclaredAmount"))){
			System.out.println("sababa");
			webhookRequest.getSessionInfo().getParameters().replace("totalDeclaredAmount", 5);
			WebhookResponse webhookResponse = new WebhookResponse();
			webhookResponse.setSessionInfo(webhookRequest.getSessionInfo());
		}
		return new WebhookResponse();
	}
}

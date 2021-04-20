package com.conversationpoc.tonypizza.controllers;

import java.util.List;

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

		//-----parameters are: {drinkorder=[{original=soda, drink=soda}], pizzasize=[large], pizzatype=[napolitana], totalAmount=1, totalDeclaredAmount=1}-----
		List<Double> totalAmount = (List<Double>) webhookRequest.getSessionInfo().getParameters().get("totalamount");
		double totalAmountAsDouble = 0;
		for(int i=0; i<totalAmount.size(); i++){
//			totalAmountAsDouble += (Double.parseDouble(totalAmount[i]));
			totalAmountAsDouble += totalAmount.get(i);
		}
		System.out.println("-----totalAmountAsDouble is: " + totalAmountAsDouble + "-----"); 
		
		if(totalAmountAsDouble < 
				Double.parseDouble((String)webhookRequest.getSessionInfo().getParameters().get("totaldeclaredamount"))){
			System.out.println("sababa");
			webhookRequest.getSessionInfo().getParameters().replace("totaldeclaredamount", 5);
			WebhookResponse webhookResponse = new WebhookResponse();
			webhookResponse.setSessionInfo(webhookRequest.getSessionInfo());
		}
		return new WebhookResponse();
	}
}

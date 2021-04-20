package com.conversationpoc.tonypizza.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conversationpoc.tonypizza.model.FulfillmentResponse;
import com.conversationpoc.tonypizza.model.ResponseMessage;
import com.conversationpoc.tonypizza.model.Text;
import com.conversationpoc.tonypizza.model.WebhookRequest;
import com.conversationpoc.tonypizza.model.WebhookResponse;


@RestController
@RequestMapping("/conversation-poc/tony-pizza")
public class WebhookController {

	@RequestMapping(value="/is-total-declared-amount-greater-than-total-amount", method=RequestMethod.POST)
	public WebhookResponse helloWorld(@RequestBody WebhookRequest webhookRequest){
		List<Double> totalAmount = (List<Double>) webhookRequest.getSessionInfo().getParameters().get("totalamount");
		double totalAmountAsDouble = 0;
		for(int i=0; i<totalAmount.size(); i++){
			totalAmountAsDouble += totalAmount.get(i);
		}
		WebhookResponse webhookResponse = new WebhookResponse();
		if(totalAmountAsDouble < 
				((Double)webhookRequest.getSessionInfo().getParameters().get("totaldeclaredamount")).doubleValue()){
			Text text = new Text();
			text.setText(new String[]{"something is missing man..."});
			ResponseMessage[] responseMessage = new ResponseMessage[1];
			responseMessage[0] = new ResponseMessage();
			responseMessage[0].setText(text);
			FulfillmentResponse fulfillmentResponse = new FulfillmentResponse();
			fulfillmentResponse.setMessages(responseMessage);
			webhookResponse.setFulfillmentResponse(fulfillmentResponse);
		}
		return webhookResponse;
	}
}

package com.conversationpoc.tonypizza.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.conversationpoc.tonypizza.model.FulfillmentResponse;
import com.conversationpoc.tonypizza.model.ResponseMessage;
import com.conversationpoc.tonypizza.model.Text;
import com.conversationpoc.tonypizza.model.WebhookRequest;
import com.conversationpoc.tonypizza.model.WebhookResponse;

@Service
public class WebhookService {

	public WebhookResponse isTotalDeclaredAmountGreaterThanTotalAmount(WebhookRequest webhookRequest){
		List<Double> totalAmountList = (List<Double>) webhookRequest.getSessionInfo().getParameters().get("totalamount");
		double totalAmount = 0;
		for(int i=0; i<totalAmountList.size(); i++){
			totalAmount += totalAmountList.get(i);
		}
		WebhookResponse webhookResponse = new WebhookResponse();
		double totalDeclaredAmount = ((Double)webhookRequest.getSessionInfo().getParameters().get("totaldeclaredamount")).doubleValue();
		if(totalAmount < totalDeclaredAmount){
			double difference = totalDeclaredAmount - totalAmount;
			Text text = new Text();
			if(difference > 1){
				text.setText(new String[]{"You asked for total of " + totalDeclaredAmount + " pizzas, so how do you want the other " + totalAmount + " pizzas?"});
			}
			else{
				text.setText(new String[]{"You asked for total of " + totalDeclaredAmount + " pizzas, so how do you want the last pizza?"});
			}
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

package com.conversationpoc.tonypizza.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conversationpoc.tonypizza.model.FulfillmentResponse;
import com.conversationpoc.tonypizza.model.ResponseMessage;
import com.conversationpoc.tonypizza.model.Text;
import com.conversationpoc.tonypizza.model.WebhookRequest;
import com.conversationpoc.tonypizza.model.WebhookResponse;

@Service
public class WebhookService {
	
	@Autowired
	private WebhookRequest webhookRequestSession;

	public WebhookResponse isTotalDeclaredAmountGreaterThanDetailedAmount(WebhookRequest webhookRequest){
		System.out.println("service: " + webhookRequest.getSessionInfo().getParameters());
		List<Double> detailedAmountList = (List<Double>) webhookRequest.getSessionInfo().getParameters().get("detailedamount");
		System.out.println("service: " + detailedAmountList);
		double totalOfDetailedAmount = 0;
		for(int i=0; i<detailedAmountList.size(); i++){
			totalOfDetailedAmount += detailedAmountList.get(i);
		}
		WebhookResponse webhookResponse = new WebhookResponse();
		double totalDeclaredAmount = ((Double)webhookRequest.getSessionInfo().getParameters().get("totaldeclaredamount")).doubleValue();
		Text text = new Text();
		if(totalOfDetailedAmount < totalDeclaredAmount && (webhookRequestSession.getSessionInfo() == null || 
				webhookRequestSession.getSessionInfo().getParameters() == null)){
			text.setText(new String[]{"What about the other " + (int)totalOfDetailedAmount + "?"});
			webhookRequestSession = webhookRequest;
		}
		else{
			text.setText(new String[]{"hi, you didn't tell me what would you like to drink?"});
		}
		ResponseMessage[] responseMessage = new ResponseMessage[1];
		responseMessage[0] = new ResponseMessage();
		responseMessage[0].setText(text);
		FulfillmentResponse fulfillmentResponse = new FulfillmentResponse();
		fulfillmentResponse.setMessages(responseMessage);
		webhookResponse.setFulfillmentResponse(fulfillmentResponse);
		webhookResponse.setTransition(null);
		return webhookResponse;
	}
}

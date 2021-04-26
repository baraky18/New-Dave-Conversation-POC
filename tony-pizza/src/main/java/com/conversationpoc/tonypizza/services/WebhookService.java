package com.conversationpoc.tonypizza.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conversationpoc.tonypizza.model.FormInfo;
import com.conversationpoc.tonypizza.model.FulfillmentResponse;
import com.conversationpoc.tonypizza.model.PageInfo;
import com.conversationpoc.tonypizza.model.ParameterInfo;
import com.conversationpoc.tonypizza.model.ResponseMessage;
import com.conversationpoc.tonypizza.model.SessionInfo;
import com.conversationpoc.tonypizza.model.Text;
import com.conversationpoc.tonypizza.model.WebhookRequest;
import com.conversationpoc.tonypizza.model.WebhookResponse;

@Service
public class WebhookService {
	
	@Autowired
	private ParameterInfo[] parameterInfo;

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
		if(totalOfDetailedAmount < totalDeclaredAmount){
			if(parameterInfo.length == 0){
				text.setText(new String[]{"What about the other " + (int)totalOfDetailedAmount + "?"});
				parameterInfo = webhookRequest.getPageInfo().getFormInfo().getParameterInfo();
			}
			else{
				addRequestToSession(webhookRequest.getPageInfo().getFormInfo().getParameterInfo());
			}
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
		FormInfo formInfo = new FormInfo();
		formInfo.setParameterInfo(parameterInfo);
		PageInfo pageInfo = new PageInfo();
		pageInfo.setFormInfo(formInfo);
		webhookResponse.setPageInfo(pageInfo);
//		webhookResponse.setSessionInfo(sessionInfo);
		return webhookResponse;
	}

	private void addRequestToSession(ParameterInfo[] newRequestParameterInfo) {
		List<String> newPizzaSize = new ArrayList<String>();
		List<String> currentPizzaSize = new ArrayList<String>();
		for(ParameterInfo tmpParameterInfo : newRequestParameterInfo){
			if(tmpParameterInfo.getDisplayName().equalsIgnoreCase("pizzaSize")){
				newPizzaSize = (List<String>) tmpParameterInfo.getValue();
				break;
			}
		}
		for(ParameterInfo tmpParameterInfo : parameterInfo){
			if(tmpParameterInfo.getDisplayName().equalsIgnoreCase("pizzaSize")){
				currentPizzaSize = (List<String>) tmpParameterInfo.getValue();
				currentPizzaSize.addAll(newPizzaSize);
				tmpParameterInfo.setValue(currentPizzaSize);
				break;
			}	
		}
		System.out.println("currentPizzaSize: " + currentPizzaSize);
	}

	private void foreach(Object object) {
		// TODO Auto-generated method stub
		
	}
}

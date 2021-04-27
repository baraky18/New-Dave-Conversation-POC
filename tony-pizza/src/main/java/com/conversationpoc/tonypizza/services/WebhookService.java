package com.conversationpoc.tonypizza.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

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
@SessionAttributes("sessionInfo")
public class WebhookService {
	
	@Autowired
	private ParameterInfo[] parameterInfo;
	@Autowired
	private SessionInfo sessionInfo;
	
	private List<Double> detailedAmountList;
	private double totalDeclaredAmount;
	private double totalOfDetailedAmount;

	public WebhookResponse isTotalDeclaredAmountGreaterThanDetailedAmount(WebhookRequest webhookRequest){
		populateAmounts(webhookRequest);
		WebhookResponse webhookResponse = new WebhookResponse();
		Text text = new Text();
		if(totalOfDetailedAmount < totalDeclaredAmount){
			if(isNewSession(webhookRequest.getSessionInfo())){
				text.setText(new String[]{"What about the other " + (int)totalOfDetailedAmount + "?"});
				parameterInfo = webhookRequest.getPageInfo().getFormInfo().getParameterInfo();
			}
			else{
				addRequestToSession(webhookRequest.getPageInfo().getFormInfo().getParameterInfo());
				text.setText(new String[]{"hi, you didn't tell me what would you like to drink?"});
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

	private void populateAmounts(WebhookRequest webhookRequest) {
		detailedAmountList = new ArrayList<Double>();
		totalDeclaredAmount = 1.0;
		for(int i=0; i<webhookRequest.getPageInfo().getFormInfo().getParameterInfo().length; i++){
			if(webhookRequest.getPageInfo().getFormInfo().getParameterInfo()[i].getDisplayName().equalsIgnoreCase("detailedAmount")){
				detailedAmountList = (List<Double>) webhookRequest.getPageInfo().getFormInfo().getParameterInfo()[i].getValue();
			}
			else if(webhookRequest.getPageInfo().getFormInfo().getParameterInfo()[i].getDisplayName().equalsIgnoreCase("totalDeclaredAmount")){
				totalDeclaredAmount = (double) webhookRequest.getPageInfo().getFormInfo().getParameterInfo()[i].getValue();
			}
		}
		totalOfDetailedAmount = 0;
		for(int i=0; i<detailedAmountList.size(); i++){
			totalOfDetailedAmount += detailedAmountList.get(i);
		}
	}

	private boolean isNewSession(SessionInfo requestSession) {
		if(sessionInfo.getSession() == null || 
				(sessionInfo.getSession() != null && !sessionInfo.getSession().equalsIgnoreCase(requestSession.getSession()))){
			sessionInfo = requestSession;
			parameterInfo = new ParameterInfo[0];
			return true;
		}
		return false;
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

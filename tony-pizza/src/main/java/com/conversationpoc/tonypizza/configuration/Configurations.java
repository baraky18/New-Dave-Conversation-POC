package com.conversationpoc.tonypizza.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.conversationpoc.tonypizza.services.WebhookService;

@Configuration
public class Configurations {

	@Bean
	public WebhookService getWebhookService(){
		return new WebhookService();
	}
}

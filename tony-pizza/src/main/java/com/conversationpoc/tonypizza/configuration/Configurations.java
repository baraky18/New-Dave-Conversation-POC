package com.conversationpoc.tonypizza.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import com.conversationpoc.tonypizza.services.WebhookService;

@Configuration
@ComponentScan("com.conversationpoc.tonypizza")
public class Configurations {

	@Bean
	public WebhookService getWebhookService(){
		return new WebhookService();
	}
	
	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
	    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
	    loggingFilter.setIncludeClientInfo(true);
	    loggingFilter.setIncludeQueryString(true);
	    loggingFilter.setIncludePayload(true);
	    loggingFilter.setMaxPayloadLength(64000);
	    return loggingFilter;
	}
}

package com.conversationpoc.tonypizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.conversationpoc.tonypizza")
public class TonyPizzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TonyPizzaApplication.class, args);
	}

}

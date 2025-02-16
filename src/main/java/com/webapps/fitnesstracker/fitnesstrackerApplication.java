package com.webapps.fitnesstracker;



import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.webapps.fitnesstracker.user.UserHttpClient;

@SpringBootApplication
public class fitnesstrackerApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(fitnesstrackerApplication.class, args);
	}

	@Bean
	UserHttpClient userHttpClient() {
	    RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
	    HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
	    return factory.createClient(UserHttpClient.class);
	}
}

package com.btg.solve.exercises.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
@EnableWebSecurity
public class Oauth2Config {

	@Bean
	public ClientRegistrationRepository clientRegistrationRepository() {

		// Create a new client registration
		return new InMemoryClientRegistrationRepository(
				// spring security provides us pre-populated builders for popular
				// oauth2 providers, like Github, Google, or Facebook.
				// The `CommonOAuth2Provider` contains the definitions for these
				CommonOAuth2Provider.GITHUB.getBuilder("github")
						// In this case, most of the common configuration, like the token and user
						// endpoints
						// are pre-populated. We only need to supply our client ID and secret
						.clientId("606cb99e3584880600c2").clientSecret("646a86576aa849045410a5bf0aea1ef8bb4e3041")
						.build());
	}
}

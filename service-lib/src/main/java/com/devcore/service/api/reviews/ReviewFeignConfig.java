package com.devcore.service.api.reviews;

import feign.Contract;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.httpclient.ApacheHttpClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Data
@Configuration
@Import(FeignClientsConfiguration.class)
public class ReviewFeignConfig {
	private String url;
	
	@Autowired private Encoder encoder;
	@Autowired private Decoder decoder;
	@Autowired private Contract contract;
	
//	@Bean
	public ReviewApi reviewApi() {
		return Feign.builder()
				.client(new ApacheHttpClient())
				.encoder(encoder)
				.decoder(decoder)
				.contract(contract)
				.target(ReviewApi.class, "http://localhost:8083/library/reviews");
	}

}

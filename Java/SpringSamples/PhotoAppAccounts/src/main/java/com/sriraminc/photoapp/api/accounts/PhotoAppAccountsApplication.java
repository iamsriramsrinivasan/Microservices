package com.sriraminc.photoapp.api.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoAppAccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppAccountsApplication.class, args);
	}

}

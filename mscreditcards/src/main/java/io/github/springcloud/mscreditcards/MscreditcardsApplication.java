package io.github.springcloud.mscreditcards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MscreditcardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscreditcardsApplication.class, args);
	}

}

package org.acme.demo;

import org.acme.demo.configuration.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({
		FileStorageProperties.class
})
@SpringBootApplication
public class LeomatchDataExtractorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeomatchDataExtractorApplication.class, args);
	}

}

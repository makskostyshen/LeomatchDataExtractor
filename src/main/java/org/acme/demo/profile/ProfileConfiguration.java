package org.acme.demo.profile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfileConfiguration {

    @Bean
    CommandLineRunner initDatabase(ProfileRepository repository){
        return args -> {
            repository.save(new Profile(null, "Maks", 16, ""));
            System.out.println("initial data loaded");
        };
    }
}

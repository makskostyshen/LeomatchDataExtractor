package org.acme.demo.configuration;

import org.acme.demo.profile.Profile;
import org.acme.demo.profile.ProfileRepository;
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

package com.san.webappsan.config;

import java.util.Arrays;

import com.san.webappsan.domain.User;
import com.san.webappsan.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User jack = new User(null, "Jack Johnson", "jack@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, jack));
    }
    
}

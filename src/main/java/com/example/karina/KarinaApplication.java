package com.example.karina;

import com.example.karina.users.Role;
import com.example.karina.users.User;
import com.example.karina.users.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class KarinaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KarinaApplication.class, args);
    }

}

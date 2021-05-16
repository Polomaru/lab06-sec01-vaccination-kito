package config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    public static final int DB_CHAR_LENGTH = 100;
    public static final int DB_DNI_LENGTH = 8;
    public static final int DB_PHONE_LENGTH= 20;


    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("Config is working");
        };
    }
}
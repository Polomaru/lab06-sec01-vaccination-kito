package config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class AppConfig {
    public static final int DB_CHAR_LENGTH = 100;
    public static final int DB_DNI_LENGTH = 8;
    public static final int DB_PHONE_LENGTH= 20;
    static final Logger logger = Logger.getLogger(AppConfig.class.getName());

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> logger.info("Config is working");
    }
}
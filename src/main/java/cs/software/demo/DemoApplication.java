package cs.software.demo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

import business.CitizenService;
import controller.CitizenController;
import data.dtos.CitizenDTO;
import data.entities.Citizen;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"controller", "business", "config"})
@EntityScan("data")
@EnableJpaRepositories("data.repositories")
public class DemoApplication {

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(DemoApplication.class, args);
    }

}
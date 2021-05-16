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
        Logger logger = Logger.getLogger(DemoApplication.class.getName());

        final var Scanner = new Scanner(System.in);
        var sdf = new SimpleDateFormat("dd/MM/yyyy");

        logger.info(() -> "------------------------------------------------");
        logger.info("Ingrese su Dni: ");
        var id = Scanner.nextLong();
        var request = new CitizenController();

        do {
            var newCitizen = new CitizenDTO();
            logger.info("Usuario no registrado!");
            newCitizen.setDni(id);
            logger.info("Ingrese los siguientes datos:");
            Scanner.nextLine();
            logger.info("Nombre: ");
            newCitizen.setName(Scanner.nextLine());
            logger.info("Apellido: ");
            newCitizen.setSurname(Scanner.nextLine());
            logger.info("Telefono : ");
            newCitizen.setPhoneNum(Scanner.nextLine());
            logger.info("Email : ");
            newCitizen.setEmail(Scanner.nextLine());

            var randomDay = new Random();
            var date = Calendar.getInstance();
            date.set(1970, Calendar.JANUARY, (randomDay.nextInt(31 - 1) + 2));

            newCitizen.setDate(date.getTime());
            request.postUser(newCitizen);
            logger.info("Se ha registrado al siguiente usuario: ");
            newCitizen.toString();
            logger.info("\n\tIngrese nuevamente su dni: ");
            id = Scanner.nextLong();
        } while(request.getUserById(id).equals(new Citizen()));

        logger.info("La fecha de vacunacion del ciudadano es: " + request.getVaccine(id).toString());
    }

}
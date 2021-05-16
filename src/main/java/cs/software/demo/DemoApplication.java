package cs.software.demo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import business.CitizenService;
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
        var Scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Ingrese su Dni: ");
        var id = Scanner.nextLong();
        System.out.print(id);

        //finding dni
        var A = new CitizenService();
        var request = A.findOneById(id);

        if(request.getDni() == null)
        {
            String name;
            String surname;
            Date date;
            String phone;
            String email;
            System.out.println("Usuario no registrado!");
            System.out.println("Ingrese los siguientes datos:");

            System.out.print("Nombre: ");
            name = Scanner.nextLine();
            System.out.print("Apellido: ");
            surname = Scanner.nextLine();
            System.out.print("Fono : ");
            phone = Scanner.nextLine();
            System.out.print("Email : ");
            email = Scanner.nextLine();

            request.replace(id,name, surname, A.getVaccine(id),phone, email);

        }

    }

}
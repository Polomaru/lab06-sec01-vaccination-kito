
package controller;

import business.CitizenService;
import cs.software.demo.APIHandling;
import cs.software.demo.DemoApplication;
import data.entities.Citizen;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    static final Logger logger = Logger.getLogger(DemoApplication.class.getName());
    static final Scanner scanner = new Scanner(System.in);
    static final String url = "http://ws-consultas.herokuapp.com/api/dni/";

    @Autowired
    private CitizenService userService;

    @PostMapping
    public Citizen postUser(@RequestBody Citizen userDTO){
        logger.info(() -> "-------------------[postUser()]------------------");
        return userService.save(userDTO);
    }

    @GetMapping("/{id}")
    public Citizen getUserById(@PathVariable Long id) throws IOException, JSONException {
        logger.info(() -> "-------------------[getUserById()]------------------");
        var request = APIHandling.readJsonFromUrl(url + id);
        if(request.isNull("dni")) {
            var citizen = userService.findOneById(id);
            if (citizen.getDni() == null) {
                logger.info(() -> "No se encontro usuarios con el id solicitado. Registrese a continuación:");
                citizen.setDni(id);
                logger.info(() -> "Nombre: ");
                citizen.setNames(scanner.nextLine());
                logger.info(() -> "Apellido(s): ");
                citizen.setSurnames(scanner.nextLine());
                logger.info(() -> "Año de nacimiento: ");
                citizen.setDate(new Date(scanner.nextInt(), Calendar.OCTOBER, 1));
                scanner.nextLine();
                logger.info(() -> "Telefono: ");
                citizen.setPhoneNum(scanner.nextLine());
                logger.info(() -> "Email");
                citizen.setEmail(scanner.nextLine());
                logger.info("Se almacenara el usuario: " + citizen.toString());
                userService.save(citizen);
            } else logger.info("Se encontro al usuario con el DNI " + id);
            return citizen;
        }
        return new Citizen();
    }

    @GetMapping("/all")
    public List<Citizen> getAll(){ return userService.getAll(); }

    @GetMapping("/vaccine/{id}")
    public Date getVaccine(@PathVariable Long id){
        logger.info(() -> "-------------------[getVaccine()]------------------");
        var vaccineDate = userService.getVaccine(id);
        logger.info(() ->
                "Ciudadano identificado por el DNI " +
                id +
                ", su cita de vacunación se encuentra programada para la fecha: " + vaccineDate
        );
        return vaccineDate;
    }


}
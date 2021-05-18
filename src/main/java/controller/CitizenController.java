
package controller;

import business.CitizenService;
import cs.software.demo.APIHandling;
import data.dtos.CitizenDTO;
import data.entities.Citizen;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RestController
@RequestMapping("/citizen")
public class CitizenController {

    static final Logger logger = Logger.getLogger(CitizenController.class.getName());
    static final Scanner scanner = new Scanner(System.in);
    static final String URL = "http://ws-consultas.herokuapp.com/api/dni/";

    @Autowired
    private CitizenService userService;


    @PostMapping("/POST")
    public Citizen postUser(@RequestBody CitizenDTO userDTO){
        logger.info(() -> "-------------------[postUser()]------------------");

        return userService.save(userDTO);
    }
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView form(){
        logger.info(() -> "-------------------[aaaaaaaaaaaaaaaaaaa()]------------------");
        return new ModelAndView("form");
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Lenght is not equal to 8")
    public static class NotFoundException extends RuntimeException {
    }

    @GetMapping("/{id}")
    public Citizen getUserById(@PathVariable Long id) throws IOException, JSONException {
        if ((int)(Math.log10(id)+1) != 8 )  { return new Citizen();}
        else{
        logger.info(() -> "-------------------[getUserById()]------------------");
        var request = APIHandling.readJsonFromUrl(URL + id.toString());
        if(request.isNull("dni")) {
            var citizen = userService.findOneById(id);
            if (citizen.getDni() == null) {
                var citizenDTO = new CitizenDTO();
                logger.info(() -> "No se encontro usuarios con el id solicitado. Registrese a continuación:");
                citizenDTO.setDni(id);
                logger.info(() -> "Nombre: ");
                citizenDTO.setNames(scanner.nextLine());
                logger.info(() -> "Apellido(s): ");
                citizenDTO.setSurnames(scanner.nextLine());
                logger.info(() -> "Año de nacimiento: ");
                var cal = Calendar.getInstance();
                cal.set(Calendar.YEAR, scanner.nextInt());
                cal.set(Calendar.MONTH, Calendar.OCTOBER);
                cal.set(Calendar.DAY_OF_MONTH, 1);
                var dateRepresentation = cal.getTime();
                citizenDTO.setDate(dateRepresentation);
                scanner.nextLine();
                logger.info(() -> "Telefono: ");
                citizenDTO.setPhoneNum(scanner.nextLine());
                logger.info(() -> "Email");
                citizenDTO.setEmail(scanner.nextLine());
                var temp = citizenDTO.toString();
                temp = temp.replaceAll("[\n\r\t]", "_");
                logger.info("Se almacenara el usuario: ");
                logger.info(temp);
                userService.save(citizenDTO);
            } else logger.log(Level.SEVERE,"Se encontro al usuario con el DNI: {0} ", id);
            return citizen;
        }
        return new Citizen();}
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
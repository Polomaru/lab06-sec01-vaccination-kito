
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

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RestController
@RequestMapping("/citizen")
public class CitizenController {

    static final Logger logger = Logger.getLogger(CitizenController.class.getName());
    static final String URL = "https://api-heroku-kito.herokuapp.com/citizen/";

    @Autowired
    private CitizenService userService;


    @PostMapping("/POST")
    public void  postUser(@RequestBody CitizenDTO userDTO){

        try{
            if ((int)(Math.log10(userDTO.getDni())+1) != 8 ){
                throw new NotFoundException();
            }
        }catch (NotFoundException gg){
            return ;
        }
        logger.info(() -> "-------------------[potUser()]------------------");
        try{
            APIHandling.readJsonFromUrl(URL + userDTO.getDni().toString());
        }
        catch (Exception e) {
            logger.info(String.valueOf(e));
            userService.save(userDTO);
        }

    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Length is not equal to 8")
    public static class NotFoundException extends RuntimeException {
    }

    @GetMapping("/{id}")
    public Citizen getUserById(@PathVariable Long id) throws IOException, JSONException {


        return userService.findOneById(id);
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
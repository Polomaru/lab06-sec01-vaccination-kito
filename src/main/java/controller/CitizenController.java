
package controller;

import business.CitizenService;
import data.dtos.CitizenDTO;
import data.entities.Citizen;
import data.entities.Citizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    private CitizenService userService;

    @PostMapping
    public Citizen postUser(@RequestBody CitizenDTO userDTO){
        return userService.save(userDTO);
    }

    @GetMapping("/{id}")
    public Citizen getUserById(@PathVariable Long id){
        return userService.findOneById(id);
    }

    @GetMapping("/all")
    public List<Citizen> getAll(){ return userService.getAll(); }

    @GetMapping("/vaccine/{id}")
    public Date getVaccine(@PathVariable Long id){
        return userService.getVaccine(id);
    }


}
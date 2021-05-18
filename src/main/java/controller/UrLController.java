package controller;

import business.CitizenService;
import data.repositories.CitizenRepository;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
public class UrLController {

    static final Logger logger = Logger.getLogger(CitizenController.class.getName());
    @Autowired
    private CitizenController citizenController ;


    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(){
        logger.info(() -> "-------------------[form()]------------------");
        return "form";
    }

    @GetMapping("/index/{id}")
    public String greeting( @PathVariable Long id,Model model) throws JSONException, IOException {
        var citizen = citizenController.getUserById(id);
        if(citizen.getDni() == null) return "redirect:/form";
        model.addAttribute("citizen", citizen);
        return "hello";
    }

}

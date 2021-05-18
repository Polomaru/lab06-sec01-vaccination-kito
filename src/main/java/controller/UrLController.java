package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
public class UrLController {

    static final Logger logger = Logger.getLogger(CitizenController.class.getName());


    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView form(){
        logger.info(() -> "-------------------[form()]------------------");
        return new ModelAndView("form");
    }

}

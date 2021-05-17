package business;

import data.entities.Citizen;
import data.repositories.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;
    static final Logger logger = Logger.getLogger(CitizenService.class.getName());
    public Citizen save(Citizen citizenDTO){
        var temp = citizenDTO.toString();
        temp = temp.replaceAll("[\n\r\t]", "_");
        logger.info(temp);
        citizenRepository.save(citizenDTO);
        return citizenDTO;
    }

    public Citizen findOneById(Long id){
        var citizen = new Citizen();
        Optional<Citizen> userOptional = citizenRepository.findById(id);
        if(userOptional.isPresent()) return userOptional.get();
        return citizen;
    }

    public List<Citizen> getAll(){
        return citizenRepository.findAll();
    }

    public Date getVaccine(Long id){
        var dobCalendar = Calendar.getInstance();
        dobCalendar.setTime(findOneById(id).getDate());
        int month = dobCalendar.get(Calendar.MONTH);
        var vaccineCalendar = Calendar.getInstance();
        vaccineCalendar.set(2021,Calendar.AUGUST,6 + (month/2));
        return vaccineCalendar.getTime();
    }

}
package business;

import data.dtos.CitizenDTO;
import data.entities.Citizen;
import data.repositories.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    public Citizen save(CitizenDTO citizenDTO){
        var citizen = new Citizen();
        citizen.setDni(citizen.getDni());
        citizen.setNames(citizenDTO.getName());
        citizen.setSurnames(citizenDTO.getSurname());
        citizen.setDate(citizenDTO.getDate());
        citizen.setEmail(citizenDTO.getEmail());
        citizen.setPhoneNum(citizenDTO.getPhoneNum());


//        return CitizenRepository.save(citizen);
        return citizen;
    }

    public Citizen findOneById(Long id){
        var Citizen = new Citizen();
        Optional<Citizen> userOptional = citizenRepository.findById(id);
        if(userOptional.isPresent()) return userOptional.get();
        else return  Citizen;
    }

    public List<Citizen> getAll(){
        return citizenRepository.findAll();
    }

    public Date getVaccine(Long id){
        Calendar dobCalendar = Calendar.getInstance();
        dobCalendar.setTime(findOneById(id).getDate());
        int month = dobCalendar.get(Calendar.MONTH);
        Calendar vaccineCalendar = Calendar.getInstance();
        vaccineCalendar.set(2021,Calendar.AUGUST,6 + (month/2));
        return vaccineCalendar.getTime();
    }

}
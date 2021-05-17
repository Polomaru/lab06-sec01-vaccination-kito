package data.dtos;

import java.util.Date;

public class CitizenDTO {
    Long dni;
    String names;
    String surnames;
    Date date;
    String phoneNum;
    String email;


    public CitizenDTO(){
        //DEFAULT CONSTRUCTOR
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    @Override
    public String toString() {
        return "CitizenDTO{" +
                "dni=" + dni +
                ", names='" + names + '\'' +
                ", surnames='" + surnames + '\'' +
                ", date=" + date +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
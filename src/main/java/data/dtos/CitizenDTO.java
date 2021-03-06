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

    public Long getDni() {return dni;}
    public String getNames() {return names;}
    public String getSurnames() {return surnames;}
    public Date getDate() { return date; }
    public String getPhoneNum() {return phoneNum;}
    public String getEmail() {return email;}

    public void setDni(Long dni) {this.dni = dni;}
    public void setNames(String names) {this.names = names;}
    public void setSurnames(String surnames) {this.surnames = surnames;}  
    public void setDate(Date date) {this.date = date;}
    public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}
    public void setEmail(String email) {this.email = email;}

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
}
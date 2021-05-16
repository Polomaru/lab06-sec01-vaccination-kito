package data.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persona")
public class Citizen {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dni",unique = true,updatable = false, length = 8)
    private Long dni;

    @Column(name = "nombres")
    private String names;

    @Column(name = "apellidos")
    private String surnames;

    @Column(name = "fecha_nacimiento")
    private Date date;

    @Column(name = "telefono", length = 20, unique = true)
    private String phoneNum;

    @Column(name = "email", unique = true)
    private String email;

    public Citizen() {
    }

    public Citizen(Long dni, String names, String surnames, Date date, String phoneNum, String email) {
        this.dni = dni;
        this.names = names;
        this.surnames = surnames;
        this.date = date;
        this.phoneNum = phoneNum;
        this.email = email;
    }
    public void replace(Long dni, String names, String surnames, Date date, String phoneNum, String email) {
        this.dni = dni;
        this.names = names;
        this.surnames = surnames;
        this.date = date;
        this.phoneNum = phoneNum;
        this.email = email;
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

    public Date getDate() { return date; }

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

    @Override
    public String toString() {
        return "Citizen{" +
                "dni=" + dni +
                ", names='" + names + '\'' +
                ", surnames='" + surnames + '\'' +
                ", date=" + date +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
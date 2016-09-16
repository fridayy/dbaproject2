package at.fhj.swd.DTO;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DType")
public class Person extends IdEntity {
    private String firstname;
    private String lastname;
    private LocalDate dateofbirth;
    private char gender;
    private String address;
    private String email;
    private String phonenumber;


    protected Person() {
    }

    public Person(PersonBuilder builder) {
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.dateofbirth = builder.dateofbirth;
        this.gender = builder.gender;
        this.address = builder.address;
        this.email = builder.email;
        this.phonenumber = builder.phonenumber;
    }

    public Person(long id, String firstname, String lastname, LocalDate dateofbirth, char gender, String address, String email, String phonenumber) {
        super(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phonenumber = phonenumber;
    }


    public String getFirstname() {
        return firstname;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getLastname() {
        return lastname;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public LocalDate getDateofbirth() {
        return dateofbirth;
    }


    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }


    public char getGender() {
        return gender;
    }


    public void setGender(char gender) {
        this.gender = gender;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhonenumber() {
        return phonenumber;
    }


    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }


}

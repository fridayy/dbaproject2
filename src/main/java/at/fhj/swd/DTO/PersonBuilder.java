package at.fhj.swd.DTO;

import java.time.LocalDate;

/**
 * bnjm (1410418084) -  14.01.2016.
 */
public class PersonBuilder {
    protected final String firstname;
    protected final String lastname;
    protected LocalDate dateofbirth;
    protected char gender;
    protected String address;
    protected String email;
    protected String phonenumber;

    public PersonBuilder(String firstname, String lastname) {
        if (firstname == null || lastname == null)
            throw new IllegalArgumentException();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public PersonBuilder withDateOfBirth(LocalDate dob) {
        this.dateofbirth = dob;
        return this;
    }

    public PersonBuilder withGender(Gender genderType) {
        if (genderType == Gender.MALE)
            this.gender = 'm';
        if (genderType == Gender.FEMALE)
            this.gender = 'w';
        return this;
    }

    public PersonBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public PersonBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public PersonBuilder withPhoneNumber(String phonenumber) {
        this.phonenumber = phonenumber;
        return this;
    }

    public Person build() {
        return new Person(this);
    }

}


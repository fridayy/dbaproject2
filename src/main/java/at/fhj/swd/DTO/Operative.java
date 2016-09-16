package at.fhj.swd.DTO;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "operative")
@PrimaryKeyJoinColumn(name = "person_id", referencedColumnName = "id")
public class Operative extends Person {
    private String office;

    public Operative() {
    }

    public Operative(long id, String firstname, String lastname, LocalDate dateofbirth, char gender, String address, String email, String phonenumber, String office) {
        super(id, firstname, lastname, dateofbirth, gender, address, email, phonenumber);
        this.office = office;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}

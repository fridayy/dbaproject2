package at.fhj.swd.DTO;

import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nation")
public class Nation extends IdEntity {
    private String name;
    private String alphacode;


    public Nation(long id, String name, String abbreviation) {
        super(id);
        this.name = name;
        this.alphacode = abbreviation;
    }

    public Nation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null)
            throw new IllegalArgumentException("Name can't be null.");
        this.name = name;
    }

    public String getAlphacode() {
        return alphacode;
    }

    public void setAlphacode(String alphaCode) {
        if (alphaCode == null)
            throw new IllegalArgumentException("Alpha Code can't be null.");
        this.alphacode = alphaCode;
    }


}

package at.fhj.swd.DTO;

import javax.persistence.*;

@Entity
@Table(name = "function")
public class Function extends IdEntity {
    @OneToOne
    @JoinColumn(
            name = "operative_person_id",
            referencedColumnName = "person_id"
    )
    private Operative operative;
    @Id
    @GeneratedValue
    private long id;
    private String title;

    public Function() {
    }

    public Function(Operative operative, long id, String title) {
        super(id);
        this.operative = operative;
        this.title = title;
    }

    public Operative getOperative() {
        return operative;
    }

    public void setOperative(Operative operative) {
        this.operative = operative;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

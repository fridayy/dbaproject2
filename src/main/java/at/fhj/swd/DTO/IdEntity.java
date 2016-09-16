package at.fhj.swd.DTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * bnjm (1410418084) -  19.11.2015.
 */
@MappedSuperclass
public abstract class IdEntity {
    @Id
    @GeneratedValue
    private long id;

    public IdEntity(long id) {
        setId(id);
    }

    protected IdEntity() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdEntity idEntity = (IdEntity) o;

        return id == idEntity.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}

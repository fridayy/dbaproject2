package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Function;
import at.fhj.swd.DTO.Operative;

import java.util.List;

/**
 * Created by bnjm on 11/20/15.
 */
public interface FunctionDAO {
    Function insert(Function f);

    Function update(Function f);

    void delete(Function f);

    Function findById(long id);

    List findAll();

    Function createFunction(Operative o, long id, String title);

    void reset();
}

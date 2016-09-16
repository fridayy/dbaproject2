package at.fhj.swd.DAO;

import at.fhj.swd.DTO.Player;

import java.util.List;

/**
 * bnjm (1410418084) -  07.01.2016.
 */
public interface PlayerDAO {
    Player insert(Player p);

    Player update(Player p);

    void delete(Player p);

    Player findById(long id);

    List findAll();

    Player createPlayer(); //TODO: create factory

    void reset();
}

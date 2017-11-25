package ru.melpholan.DAO;

import org.hibernate.Session;
import ru.melpholan.DAO.Impl.ProfessionException;
import ru.melpholan.entitty.Professions;

import java.sql.SQLException;
import java.util.List;

public interface ProfessionDAO {

    Session getSession();

    void setSession(Session session);

    //get all professions
    List<Professions> professionsList ();

    void addProfession(String professionName) throws SQLException, ProfessionException;

    Professions getProfessionByName(String professionName);

    void deleteProfession(String professionName) throws SQLException;
}

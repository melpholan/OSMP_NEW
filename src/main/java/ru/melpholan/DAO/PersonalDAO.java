package ru.melpholan.DAO;

import org.hibernate.Session;
import ru.melpholan.entitty.Adreses;
import ru.melpholan.entitty.Personal;
import ru.melpholan.entitty.Professions;
import ru.melpholan.exceptions.PersonalBuisnesException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface PersonalDAO {

    Session getSession();
    void setSession(Session session);

    //add Personal
    void addPersonal(String name, String surname, String patronymic, Date birthsday,
                     Date lastDateOfWorkLicense, Date dateOfEmployment, Professions profession) throws PersonalBuisnesException;

    //find all Personal by profession
    List<Personal> findAllByProfession(String profName);

    //find all Personal
    List<Personal> findAll();

    /***find with Vacations = duration***/
    List<Personal> findAllWithVacations(Integer start, Integer end);

    //find by Id
    Personal findById(Long id) throws SQLException;
    //Insert or update Personal

    Serializable save(Personal personal) throws SQLException;
    // delete Personal

    void delete(Personal personal)throws SQLException;

    Adreses findAdressById(Integer id);

    void deleteAllPersonal();
    void deleteAllAdresses();
}

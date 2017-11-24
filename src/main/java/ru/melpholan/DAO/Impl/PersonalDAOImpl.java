package ru.melpholan.DAO.Impl;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.melpholan.DAO.PersonalDAO;
import ru.melpholan.entitty.Adreses;
import ru.melpholan.entitty.Personal;
import ru.melpholan.entitty.Professions;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PersonalDAOImpl implements PersonalDAO {


    private  Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {

        this.session = session;

    }

    public void addPersonal(String name, String surname, String patronymic, Date birthsday, Date lastDateOfWorkLicense, Date dateOfEmployment, Professions profession) {
        Personal p = new Personal();
        p.setName(name);
        p.setSurname(surname);
        p.setPatronymic(patronymic);
        p.setLastDateOfWorkLicense(lastDateOfWorkLicense);
        p.setDateOfEmployment(dateOfEmployment);
        p.setBirthsday(birthsday);
        p.setProfession(profession);
        p.setProfession(profession);
        session.save(p);
    }

    public List<Personal> findAll() {
        return session.createQuery("from Personal ps").list();
    }

    public List<Personal> findAllByProfession(String professionName){
        Query query = session.createQuery("from Personal p where p.profession.professionName = :prName");
        query.setParameter("prName", professionName);
        return  query.list();
    }

    public Personal findById(Long id) throws SQLException {
        Query query = session.createQuery("from Personal ps where ps.idPersonal=:id");
        query.setParameter("id", id);
        return (Personal) query.uniqueResult();
    }


    public Adreses findAdressById(Integer id){
        Query query = session.createQuery("from Adreses ad where ad.idAdress=:id");
        query.setParameter("id",id);
        return (Adreses) query.uniqueResult();
    }

    public Personal save(Personal personal) throws SQLException {
        return null;
    }


    public void delete(Personal personal) throws SQLException {

        List<Personal> personals = session.createQuery(" from Personal ps ").list();
        for (Personal ps: personals
             ) {
            if(ps.equals(personal)){
                session.delete(ps);
            }
        }

    }

    public void deleteAllPersonal(){
        session.createQuery("delete from Personal p").executeUpdate();
    }

    public void deleteAllAdresses(){
        session.createQuery("delete from Adreses a").executeUpdate();
    }

    public List<Personal> findAllWithVacations(Integer start, Integer end) {
        return null;
    }


}

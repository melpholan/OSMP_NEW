package ru.melpholan.DAO.Impl;


import org.hibernate.Query;
import org.hibernate.Session;
import ru.melpholan.DAO.ProfessionDAO;
import ru.melpholan.entitty.Professions;

import java.sql.SQLException;
import java.util.List;

public class ProfessionDAOImpl implements ProfessionDAO {

    private  Session session = null;

    public  Session getSession(){
        return session;
    }

    public  void setSession(Session session){
        this.session = session;
    }

    //get all Professions
    public List<Professions> professionsList() {
        return session.createQuery("from Professions p").list();
    }

    //add Profession
    public void addProfession(String newProfessionName) throws SQLException, ProfessionException {

        Query query = session.createQuery("from Professions pr where professionName = :prName");
        query.setParameter("prName", newProfessionName);
        Professions result = (Professions)query.uniqueResult();

        if(result != null){
            throw new ProfessionException("This Profession already exist");
        }
        Professions professions = new Professions();
        professions.setProfessionName(newProfessionName);
        session.save(professions);
    }

    //get Profession by Name
    public Professions getProfessionByName(String professionName) {
        Query query = session.createQuery("from Professions pr where pr.professionName = :prName");
        query.setParameter("prName", professionName);
        Professions result = (Professions)query.uniqueResult();
        return result;
    }


    public void deleteProfession(String professionName) throws SQLException {

        Query query = session.createQuery("delete from Professions pr where pr.professionName = :prName");
        query.setParameter("prName", professionName);
    }
}

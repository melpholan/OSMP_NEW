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

    public List<Professions> professionsList() {
        return session.createQuery("from Professions p").list();
    }

    public void addProfession(String newProfessionName) throws SQLException, ProfessionException {

        List<Professions> professions = professionsList();
        Professions newProfession = new Professions();
        newProfession.setProfessionName(newProfessionName);

        for (Professions pr: professions
             ) {
            if(pr.equals(newProfession)){
                throw new ProfessionException("This Profession already exist");
            }
        }

        session.save(newProfession);
    }

    public void deleteProfession(String professionName) throws SQLException {

        Query query = session.createQuery("delete from Professions pr where pr.professionName = :prName");
        query.setParameter("prName", professionName);
    }
}

package ru.melpholan.entitty;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import ru.melpholan.DAO.Impl.PersonalDAOImpl;
import ru.melpholan.DAO.Impl.ProfessionDAOImpl;
import ru.melpholan.DAO.Impl.ProfessionException;
import ru.melpholan.DAO.PersonalDAO;
import ru.melpholan.DAO.ProfessionDAO;
import ru.melpholan.exceptions.PersonalBuisnesException;
import ru.melpholan.utils.HibernateUtil;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Main {

    private static SessionFactory sessionFactory =null;


    public static void main(String[] args) {

        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        PersonalDAO personalDAO = new PersonalDAOImpl();
        ProfessionDAO professionDAO = new ProfessionDAOImpl();
        professionDAO.setSession(session);
        personalDAO.setSession(session);

        String[] str = {"doctor", "feldsher","headDoctor","dispatcher"};

        Transaction tx = session.beginTransaction();
        for (String s: str
             ) {
            Professions p = new Professions();
            p.setProfessionName(s);
            session.save(p);
        }

        Professions pr = professionDAO.getProfessionByName("doctor");
        System.out.println(pr);


        try {
            personalDAO.addPersonal("Никитми", "Denis", "andr",
                    new Date("12/12/1979"),new Date("09/01/2005"), new Date("07/12/207"),pr);
        } catch (PersonalBuisnesException e) {
            e.printStackTrace();
        }

        Personal ps = new Personal();
        ps.setBirthsday(new Date("09/01/2005"));
        ps.setName("DOe");
        ps.setSurname("JohN");
        ps.setLastDateOfWorkLicense(new Date("09/01/2005"));
        ps.setDateOfEmployment(new Date("09/01/2005"));
        ps.setProfession(pr);

        try {
            personalDAO.save(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println("DONE");





      /*  ProfessionDAO pd = new ProfessionDAOImpl();
      /  pd.setSession(session);
        try {

            pd.addProfession("vrachhhh");
        }catch ( SQLException e){
            //NOP
        }catch (ProfessionException e){
            e.getMessage();
            tx.rollback();
        }

        /*

        personalDAO.addPersonal("Doe", "John",null, new Date(), new Date(),new Date(), profession);

        Personal p = new Personal();
        p.setName("Akulenko");
        p.setSurname("Denis");
        p.setLastDateOfWorkLicense(new Date());
        p.setDateOfDimissal(new Date());
        p.setDateOfEmployment(new Date());
        p.setBirthsday(new Date());
        p.setProfession(profession);

        Adreses adreses = new Adreses();
        adreses.setSity("PB");
        adreses.setStreet("SEDEE");
        adreses.setFlatNumber(22);
        adreses.setHouseNumber(33);
        adreses.setPersonal(p);
        session.save(adreses);


        p.setProfession((Professions)
                session.createQuery(
                        "from Professions p where professionName = 'feldsher'").uniqueResult()

        );

        session.save(p);

        Contacts contacts = new Contacts();
        contacts.setMobilePhone("3536363663646447");
        contacts.setEmil("mail.ru");
        contacts.setHomePhone(null);
        contacts.setPersonal(p);
       // p.addContacts(contacts);
        session.save(contacts);
       // p.setProfession(professions);
       // Professions pr;
       // pr =(Professions) session.createQuery("from Professions p where p.professionName = 'doctor'").uniqueResult();
       // System.out.println(pr);
       // p.setProfession(pr);
        System.out.println(p);
        //session.save(p);

        List<Personal> all = personalDAO.findAll();


        for (Personal ps: all
             ) {
            System.out.println(ps);
        }
*/
        System.out.println(tx.getStatus());
        if(tx.getStatus() == TransactionStatus.ACTIVE)
        {tx.commit();}

        if (session != null && session.isOpen()) {

            session.close();


        }
        HibernateUtil.destroy();
    }

    /*
    Personal p = new Personal();
        p.setName("Akulenko");
        p.setSurname("Denis");
        p.setLastDateOfWorkLicense(new Date());
        p.setDateOfDimissal(new Date());
        p.setDateOfEmployment(new Date());
        p.setBirthsday(new Date());
    Professions pr;
    pr =(Professions) session.createQuery("from Professions p where p.professionName = 'doctor'").uniqueResult();
        System.out.println(pr);
        p.setProfession(pr);
        System.out.println(p);
        session.save(p);
        */
}



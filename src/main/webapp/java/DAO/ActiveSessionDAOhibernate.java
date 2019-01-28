package DAO;

import model.ActiveSession;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ActiveSessionDAOhibernate implements ActiveSessionDAO {


    public String getSessionTokenFromDataBase() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();

        Query query = menager.createQuery("SELECT sessionToken FROM ActiveSession");
        List<String> headerList = query.getResultList();

        menager.getTransaction().commit();
        menager.close();
        factory.close();
        if (headerList.size() > 0) {
            return headerList.get(0);
        }
        else {
           return "EmptyDataBase";
        }
    }


    public void clearActiveSessionInDataBase() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();

        Query query = menager.createQuery("DELETE FROM ActiveSession");
        query.executeUpdate();
        menager.getTransaction().commit();
        menager.close();
        factory.close();
    }

    public void addSessionTokenToDataBase(String token) {

        ActiveSession session = new ActiveSession();
        session.setSessionToken(token);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();
        menager.persist(session);
        menager.getTransaction().commit();
        menager.close();
        factory.close();
    }

}

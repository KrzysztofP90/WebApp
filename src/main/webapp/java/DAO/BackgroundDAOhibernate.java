package DAO;

import model.Background;
import org.hibernate.cfg.QuerySecondPass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class BackgroundDAOhibernate implements BackgroundDAO {


    public String[] getAlliassesFromDataBase() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();

        Query query = menager.createQuery("SELECT allias FROM Background");
        List<String> alliasList = query.getResultList();

        String[] arrayOfAlliases = new String[alliasList.size()];

        for (int i = 0; i < alliasList.size(); i++) {
            arrayOfAlliases[i] = alliasList.get(i);
        }
        menager.getTransaction().commit();
        menager.close();
        factory.close();

        return arrayOfAlliases;
    }


    public String getNameByAllias(String allias) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();

         Query query= menager.createQuery(
                "SELECT a FROM Background a WHERE a.allias=:al", Background.class);
        query.setParameter("al", allias);
        List<Background> backgroundsList = query.getResultList();

        String name = "";
        for (Background background : backgroundsList ) {
            if (background.getAllias().equals(allias)) {
                name = background.getName();
            }
        }
        menager.getTransaction().commit();
        menager.close();
        factory.close();
        return name;
    }


    public String getNameOfActiveBackground() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();

        Query query= menager.createQuery(
                "SELECT a FROM Background a WHERE a.active=true", Background.class);
        List<Background> backgroundsList = query.getResultList();

        menager.getTransaction().commit();
        menager.close();
        factory.close();
        return  backgroundsList.get(0).getName();
    }


    public String getAlliasOfActiveBackground() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();

        Query query= menager.createQuery(
                "SELECT a FROM Background a WHERE a.active=true", Background.class);
        List<Background> backgroundsList = query.getResultList();

        menager.getTransaction().commit();
        menager.close();
        factory.close();
        return  backgroundsList.get(0).getAllias();
    }


    public void setActiveBackgroundByAllias(String allias) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();

        Query queryToRemoveOldActiveBackground = menager.createQuery(
                "UPDATE Background a SET a.active=:t where a.allias=:al");
        queryToRemoveOldActiveBackground.setParameter("t", true);
        queryToRemoveOldActiveBackground.setParameter("al", allias);
        queryToRemoveOldActiveBackground.executeUpdate();

        menager.getTransaction().commit();
        menager.close();
        factory.close();
    }


    public void setUnactiveBackgroundByAllias(String allias) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();

        Query queryToRemoveOldActiveBackground = menager.createQuery(
                "UPDATE Background a SET a.active=:f where a.allias=:al");
        queryToRemoveOldActiveBackground.setParameter("f", false);
        queryToRemoveOldActiveBackground.setParameter("al", allias);
        queryToRemoveOldActiveBackground.executeUpdate();

        menager.getTransaction().commit();
        menager.close();
        factory.close();
    }

}

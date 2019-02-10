package DAO;

import model.Background;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class BackgroundDAOhibernate implements BackgroundDAO {


    public List<String> getAlliassesFromDataBase() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();

        Query query = menager.createQuery("SELECT allias FROM Background");
        List<String> alliasList = query.getResultList();

        menager.getTransaction().commit();
        menager.close();
        factory.close();

        return alliasList;
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
        return name;
    }


    public String getNameOfActiveBackground() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();

        Query query= menager.createQuery(
                "SELECT a FROM Background a WHERE a.active=true", Background.class);
        List<Background> backgroundsList = query.getResultList();
        
        return  backgroundsList.get(0).getName();
    }





}

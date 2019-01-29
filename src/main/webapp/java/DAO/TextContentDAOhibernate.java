package DAO;

import model.TextContent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class TextContentDAOhibernate implements TextContentDAO {



    public String getTextContentHeaderByID(int id) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();

        Query query = menager.createQuery("SELECT header FROM TextContent WHERE id= " + id);
        List<String> headerList = query.getResultList();

        menager.getTransaction().commit();
        menager.close();
        factory.close();

        return headerList.get(0);
    }


    public String getTextContentDescribeByID(int id) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();

        Query query = menager.createQuery("SELECT describe FROM TextContent WHERE id= " + id);
        List<String> headerList = query.getResultList();

        menager.getTransaction().commit();
        menager.close();
        factory.close();

        return headerList.get(0);
    }


    public void updateTextContentHeaderById(int id, String value) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();

        Query query = menager.createQuery("UPDATE TextContent SET header=" + value + " WHERE id=" + id);
        query.executeUpdate();

        menager.close();
        factory.close();
    }


    public void updateTextContentDescribeById(int id, String value) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();

        Query query = menager.createQuery("UPDATE TextContent SET describe=" + value + " WHERE id=" + id);
        query.executeUpdate();

        menager.close();
        factory.close();
    }
}

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


    public void updateTextContentHeaderById(long id, String value) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();

//        Query query = menager.createQuery("UPDATE TextContent SET header=:header WHERE id=:id");
//        query.setParameter("header",value);
//        query.setParameter("id",id);
        Query query = menager.createQuery("UPDATE TextContent a SET a.header='"+value+"' WHERE a.id=" + id);
        query.executeUpdate();

        menager.getTransaction().commit();
        menager.close();
        factory.close();
    }


    public void updateTextContentDescribeById(long id, String value) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();

//        Query query = menager.createQuery("UPDATE TextContent SET describe=:describe WHERE id=:id");
//        query.setParameter("describe",value);
//        query.setParameter("id",value);
        Query query = menager.createQuery("UPDATE TextContent a SET a.describe='"+value+"' WHERE a.id=" + id);
        query.executeUpdate();

        menager.getTransaction().commit();
        menager.close();
        factory.close();
    }
}

package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class MenuOptionDAOhibernate implements MenuOptionDAO {


    public String getTitleOfMenuOptionById(int id) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();

        Query query = menager.createQuery("SELECT title FROM MenuOption WHERE id= " + id);
        List<String> headerList = query.getResultList();

        menager.getTransaction().commit();
        menager.close();
        factory.close();

        return headerList.get(0);
    }
}

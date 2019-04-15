package JPA;

import model.Background;
import model.MenuOption;
import model.TextContent;
import model.Client;
import org.hibernate.mapping.Backref;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataBaseInitializator {


    private void initDataBase(EntityManager menager) {

        MenuOption firstOption = new MenuOption();
        firstOption.setTitle("Option 1");
        MenuOption secondOption = new MenuOption();
        secondOption.setTitle("Option 2");
        MenuOption thirdOption = new MenuOption();
        thirdOption.setTitle("Option 3");

        TextContent intro = new TextContent();
        intro.setHeader("intro - Header");
        intro.setDescribe("Introduction to web site!");

        TextContent welcomeHeader = new TextContent();
        welcomeHeader.setHeader("Welcome - Header");
        welcomeHeader.setDescribe("Welcome Dear Customer! This is our special service for You");

        TextContent additionalDescribe = new TextContent();
        additionalDescribe.setHeader("Describe - Header");
        additionalDescribe.setDescribe("You will be satisfied. We are sure about our professional !");

        TextContent option1Content = new TextContent();
        option1Content.setHeader("Option1 - Header");
        option1Content.setDescribe("This is our first special service for You our Dear Customer! You will" +
                "be satisfied. We are sure about our professionalist !");
        TextContent option2Content = new TextContent();
        option2Content.setHeader("Option2 - Header");
        option2Content.setDescribe("This is our second special service for You our Dear Customer! You will" +
                "be satisfied. We are sure about our professionalist !");
        TextContent option3Content = new TextContent();
        option3Content.setHeader("Option3 - Header");
        option3Content.setDescribe("This is our third special service for You our Dear Customer! You will" +
                "be satisfied. We are sure about our professionalist !");

        MenuOption footer = new MenuOption();
        footer.setTitle("We invite to co-operate!!!");

        Background defaultBackground = new Background("default.jpeg", true, "Default");

        Background backgroundDark = new Background("backgroundDark.jpg", false, "DarkBackground");

        Background balls = new Background("balls.png", false, "Balls");

        Background clouds = new Background("clouds.jpg", false, "Clouds");

        Background cyber = new Background("cyber.jpg", false, "Cyber");

        Background gameDev = new Background("gameDev.jpg", false, "GameDevelop");

        Background grass = new Background("grass.jpg", false, "Grass");

        Background green = new Background("green.jpg", false, "Green");

        Background ligths = new Background("lights.jpg", false, "Lights");

        Background ocean = new Background("ocean.png", false, "Ocean");

        Background redBlack = new Background("redBlack.jpg", false, "Red&Black");

        Background strange = new Background("strange.jpg", false, "Strange");

        Background technology = new Background("technology.png", false, "Technology");



        menager.getTransaction().begin();

        menager.persist(firstOption);
        menager.persist(secondOption);
        menager.persist(thirdOption);

        menager.persist(intro);
        menager.persist(welcomeHeader);
        menager.persist(additionalDescribe);
        menager.persist(option1Content);
        menager.persist(option2Content);
        menager.persist(option3Content);

        menager.persist(footer);


        menager.persist(defaultBackground);
        menager.persist(backgroundDark);
        menager.persist(balls);
        menager.persist(clouds);
        menager.persist(cyber);
        menager.persist(gameDev);
        menager.persist(grass);
        menager.persist(green);
        menager.persist(ligths);
        menager.persist(ocean);
        menager.persist(redBlack);
        menager.persist(strange);
        menager.persist(technology);

        menager.getTransaction().commit();
    }


    private void initUserLoginAndPassword(EntityManager menager) {
//        String password = "";
//        String login = "";
//        try {
//            BufferedReader bf = new BufferedReader(new FileReader(new File("src/main/resources/access.txt")));
//            login = bf.readLine();
//            password = bf.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Client user1 = new Client();
        user1.setLogin("admin");
        user1.setPassword("admin");

        menager.getTransaction().begin();
        menager.persist(user1);
        menager.getTransaction().commit();
    }


    public static void main(String[] args) {

        DataBaseInitializator initializator = new DataBaseInitializator();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CMS");
        EntityManager menager = factory.createEntityManager();


//        initializator.initDataBase(menager);
//
//        initializator.initUserLoginAndPassword(menager);

        menager.close();
        factory.close();
    }
}

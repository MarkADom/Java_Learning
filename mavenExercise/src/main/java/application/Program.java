package application;

import dominio.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
    public static void main(String[] args) {

        /*
        User p1 = new User(null, "Carlos da Silva", "carlos@gmail.com");
        User p2 = new User(null, "Joaquim Torres", "joaquim@gmail.com");
        User p3 = new User(null, "Ana Maria", "ana@gmail.com");
        */

        //Creating entity manager.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        //Connection to database.
        EntityManager em = emf.createEntityManager();

        /*
        //If is not only a reading of the database we need to apply a transaction
        em.getTransaction().begin();
        //inserting users in database using persist()
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();
        */

        /*
        //Searching object byId on database.
        User u = em.find(User.class,2);
        System.out.println(u);
        */

        //Deleting object from database. JPA only can remove entity monitored.

        User u = em.find(User.class, 2);
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
        System.out.println("Done!");

        em.close();
        emf.close();
    }
}

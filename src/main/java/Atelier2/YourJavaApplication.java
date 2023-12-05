package Atelier2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ourJavaApplication {

    public static void main(String[] args) {
        // Load EntityManagerFactory from persistence.xml
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

        // Create EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Perform database operations using the EntityManager

        // Close EntityManager
        entityManager.close();

        // Close EntityManagerFactory when your application shuts down
        entityManagerFactory.close();
    }
}


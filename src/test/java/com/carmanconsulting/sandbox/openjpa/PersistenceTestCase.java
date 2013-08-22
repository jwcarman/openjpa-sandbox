package com.carmanconsulting.sandbox.openjpa;

import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created with IntelliJ IDEA.
 * User: jcarman
 * Date: 8/22/13
 * Time: 7:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class PersistenceTestCase
{
    private EntityManager entityManager;

    @After
    public void commitTransaction()
    {
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Before
    public void createEntityManager()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("openjpa");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
    }
}

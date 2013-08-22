package com.carmanconsulting.sandbox.openjpa;

import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class PersistenceTestCase
{
//----------------------------------------------------------------------------------------------------------------------
// Fields
//----------------------------------------------------------------------------------------------------------------------

    private EntityManager entityManager;

//----------------------------------------------------------------------------------------------------------------------
// Other Methods
//----------------------------------------------------------------------------------------------------------------------

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

    protected EntityManager getEntityManager()
    {
        return entityManager;
    }
}

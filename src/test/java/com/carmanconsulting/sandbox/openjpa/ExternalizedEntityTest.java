package com.carmanconsulting.sandbox.openjpa;

import org.junit.Test;

import java.net.InetAddress;

import static org.junit.Assert.*;

public class ExternalizedEntityTest extends PersistenceTestCase
{
//----------------------------------------------------------------------------------------------------------------------
// Other Methods
//----------------------------------------------------------------------------------------------------------------------

    @Test
    public void testPersisting() throws Exception
    {
        ExternalizedFieldEntity entity = new ExternalizedFieldEntity();
        final InetAddress address = InetAddress.getByName("192.168.1.1");
        entity.setInetAddress(address);
        getEntityManager().persist(entity);
        getEntityManager().flush();
        getEntityManager().clear();
        ExternalizedFieldEntity found = getEntityManager().find(ExternalizedFieldEntity.class, entity.getId());
        assertNotNull(found);
        assertNotSame(entity, found);
        assertEquals(address, found.getInetAddress());
    }
}

package com.carmanconsulting.sandbox.openjpa;

import javax.persistence.Id;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: jcarman
 * Date: 8/22/13
 * Time: 7:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class UuidEntity
{
    @Id
    private String id = UUID.randomUUID().toString();

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof ExternalizedFieldEntity))
        {
            return false;
        }

        ExternalizedFieldEntity that = (ExternalizedFieldEntity) o;

        if (!id.equals(that.id))
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }
}

package com.carmanconsulting.sandbox.openjpa;

import org.apache.openjpa.persistence.Externalizer;
import org.apache.openjpa.persistence.Factory;
import org.apache.openjpa.persistence.Persistent;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Entity
public class ExternalizedFieldEntity extends UuidEntity
{
//----------------------------------------------------------------------------------------------------------------------
// Fields
//----------------------------------------------------------------------------------------------------------------------

    @Externalizer("ExternalizedFieldEntity.toHostAddress")
    @Factory("ExternalizedFieldEntity.toInetAddress")
    @Column(name="ip_address")
    @Persistent
    private InetAddress inetAddress;

//----------------------------------------------------------------------------------------------------------------------
// Static Methods
//----------------------------------------------------------------------------------------------------------------------

    public static String toHostAddress(InetAddress inetAddress)
    {
        return inetAddress.getHostAddress();
    }

    public static InetAddress toInetAddress(String ipAddress)
    {
        try
        {
            return ipAddress == null ? null : InetAddress.getByName(ipAddress);
        }
        catch (UnknownHostException e)
        {
            throw new RuntimeException("Unable to map by ip address.", e );
        }
    }

//----------------------------------------------------------------------------------------------------------------------
// Getter/Setter Methods
//----------------------------------------------------------------------------------------------------------------------

    public InetAddress getInetAddress()
    {
        return inetAddress;
    }

    public void setInetAddress(InetAddress inetAddress)
    {
        this.inetAddress = inetAddress;
    }
}

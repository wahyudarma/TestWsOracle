package com.wahyu.main;

import javax.xml.ws.Endpoint;
import com.wahyu.services.EmployeeServices;
import com.wahyu.services.PackageServices;

public class MainPublisher
{
    public static void main(String[]args)
    {
    //  Employee
//        Endpoint.publish("http://localhost:8889/Java-Ws-Oracle/ws/javaoracle", new EmployeeServices());

    // Package
        Endpoint.publish("http://localhost:8889/Java-Ws-Oracle/ws/javaoracle", new PackageServices());
    }
}


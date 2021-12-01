package com.wahyu.main;

import javax.xml.ws.Endpoint;
import com.wahyu.services.EmployeeServices;

public class MainPublisher
{
    public static void main(String[]args)
    {
        Endpoint.publish("http://localhost:8889/Java-Ws-Oracle/ws/javaoracle", new EmployeeServices());
    }
}


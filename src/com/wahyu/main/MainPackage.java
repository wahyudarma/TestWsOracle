package com.wahyu.main;

import com.wahyu.interfaces.IPackages;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;


public class MainPackage {
    public static void main(String[]args)
    {
        URL wsdlUrl = null;

        try {
            wsdlUrl = new URL("http://localhost:8889/Java-Ws-Oracle/ws/javaoracle?wsdl");
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        QName qName = new QName("http://services.wahyu.com/","PackageServicesService");

        Service service = Service.create(wsdlUrl, qName);
        IPackages iPackages = service.getPort(IPackages.class);
    }
}


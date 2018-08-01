package com.example;

import com.example.service.HelloWorld;
import com.example.service.HelloWorldImpl;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;


public class Server {

    protected Server() throws Exception {
        // START SNIPPET: publish
        HelloWorldImpl implementor = new HelloWorldImpl();
        JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
        svrFactory.setServiceClass(HelloWorld.class);
        svrFactory.setAddress("http://localhost:8080/helloWorld");
        svrFactory.setServiceBean(implementor);
        svrFactory.create();
        // END SNIPPET: publish
    }

    public static void main(String args[]) throws Exception {
        new Server();
        System.out.println("Server ready...");

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(HelloWorld.class);
        factory.setAddress("http://localhost:8080/helloWorld");
        HelloWorld client = (HelloWorld) factory.create();
        String reply = client.hello("HI");
        System.out.println("Server said: " + reply);

        Thread.sleep(5 * 6000 * 1000);
        System.out.println("Server exiting");



        System.exit(0);
    }
}
package com.example.service;

import com.example.entity.User;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.jws.WebService;

@WebService(endpointInterface = "com.example.service.HelloWorld", serviceName = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    private Map<Integer, User> users = new LinkedHashMap<>();

    public String hello(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }

    public String helloUser(User user) {
        System.out.println("sayHiToUser called");
        users.put(users.size() + 1, user);
        return "Hello "  + user.getName();
    }

    public Map<Integer, User> getUsers() {
        System.out.println("getUsers called");
        return users;
    }
}
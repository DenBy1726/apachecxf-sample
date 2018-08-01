package com.example.service;

import com.example.adapter.IntegerUserMapAdapter;
import com.example.entity.User;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Map;

@WebService
public interface HelloWorld {

    String hello(String text);

    String helloUser(User user);

    @XmlJavaTypeAdapter(IntegerUserMapAdapter.class)
    Map<Integer, User> getUsers();
}

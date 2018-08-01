package com.example.entity;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Student")
public class UserImpl implements User {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserImpl() {
    }

    public UserImpl(String name) {

        this.name = name;
    }
// constructors, getter and setter
}
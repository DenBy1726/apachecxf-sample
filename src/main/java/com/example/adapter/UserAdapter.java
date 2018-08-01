package com.example.adapter;

import com.example.entity.User;
import com.example.entity.UserImpl;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class UserAdapter extends XmlAdapter<UserImpl, User> {
    public UserImpl marshal(User user) throws Exception {
        if (user instanceof UserImpl) {
            return (UserImpl) user;
        }
        return new UserImpl(user.getName());
    }

    public User unmarshal(UserImpl user) throws Exception {
        return user;
    }
}
package org.example.socialmedia.services;

import org.example.socialmedia.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<User> store = new ArrayList<>();

    public UserService(){
        store.add(new User(UUID.randomUUID().toString(), "Harsh", "harsh@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(), "Harsh1", "harsh1@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(), "Harsh2", "harsh2@gmail.com"));
    }

    public List<User> getUsers(){
        return this.store;
    }

}

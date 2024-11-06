package org.restApi.service;

import org.restApi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "Von", 33, "von@mail.com");
        User user2 = new User(2, "Tony", 21, "tony@mail.com");
        User user3 = new User(3, "Mary", 27, "mary@mail.com");
        User user4 = new User(4, "Anne", 36, "anne@mail.com");
        User user5 = new User(5, "Mark", 44, "mark@mail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user4));
    }

    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for(User user : userList){
            if (id == user.getId()){
                optional = optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}

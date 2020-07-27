package org.sqli.staysafe.repositories.impl;

import org.springframework.stereotype.Repository;
import org.sqli.staysafe.models.entities.User;
import org.sqli.staysafe.repositories.UserRepository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    
    private static Map<Long, User> users = new HashMap<>();

    @Override
    public User findUserById(long id) {
        return users.get(id);
    }

    @Override
    public void saveUser(User user) {
        users.put(user.getId(), user);
    }
}

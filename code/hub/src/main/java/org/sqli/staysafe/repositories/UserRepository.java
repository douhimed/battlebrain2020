package org.sqli.staysafe.repositories;

import org.sqli.staysafe.models.entities.User;

public interface UserRepository {

    User findUserById(long id);

    void saveUser(User user);
}

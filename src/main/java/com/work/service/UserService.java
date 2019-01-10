package com.work.service;
import com.work.Entity.User;
import java.util.List;
public interface UserService {
    User addUser(User user);
    User findOne(String name);
    List<User> findAll();
    void deleteUser(String name);
    User UpdateUser(User user);
}

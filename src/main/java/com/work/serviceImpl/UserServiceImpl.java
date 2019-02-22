package com.work.serviceImpl;
import com.work.Entity.User;
import com.work.Repository.UserRepository;
import com.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User addUser(User user){
        return userRepository.save(user);
    }
    public User findOne(String name){
        List< User > userList = userRepository.findAllByUserName( name );
        User user = new User();

        for( User key : userList )
        {
            user = key;
        }
        return user;
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public void deleteUser(String name){
        userRepository.deleteById(name);
    }
    public User UpdateUser(User user){
        return userRepository.save(user);
    }
}

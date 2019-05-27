package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserRepository> {
    UserService(UserRepository repository) {
        super(repository);
    }

    @Override
    public User update(User newUser, Long id) {
        getLogger().info("Updating an entity " + User.class.getName());
        User oldUser = get(id);
        oldUser.setName(newUser.getName());
        oldUser.setPassword(newUser.getPassword());
        return oldUser;
    }
}

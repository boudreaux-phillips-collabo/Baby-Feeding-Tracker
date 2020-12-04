package com.tracker.feeding.services;

import com.tracker.feeding.models.User;
import com.tracker.feeding.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Arrays;

public class UserService implements IUserService {
    @Autowired
    private UserRepository userDao;

    @Transactional
    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        if (emailExists(user.getEmail())) {
            throw new UserAlreadyExistsException("An account already exists with email address " + user.getEmail());
        }
        User user = new User();
        user.setFirst_name(user.getFirst_name);
        user.setLast_name(user.getLast_name());
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        user.setRoles(Arrays.asList("ROLE_USER"));
        return userDao.save(user);
    }

    private boolean emailExists(String email) {
        return userdao.findByEmail(email) != null;
    }

}

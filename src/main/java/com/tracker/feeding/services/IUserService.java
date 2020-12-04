package com.tracker.feeding.services;

import com.tracker.feeding.models.User;


public interface IUserService {
    User saveUser(User user)
        throws UserAlreadyExistsException;
}

package com.app.services;

import com.app.datastore.UserData;
import com.app.exceptions.ExceptionType;
import com.app.exceptions.FoodDeliveryException;
import com.app.model.User;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserData userData;

    @Autowired
    public UserService(UserData userData) {
        this.userData = userData;
    }

    public void addUser(@NonNull final User user) {
        if (userData.getUserById().containsKey(user.getId())) {
            throw new FoodDeliveryException(ExceptionType.USER_ALREADY_EXISTS, "userId already exists");
        }
        userData.getUserById().put(user.getId(), user);
    }

    public void deleteUser(@NonNull final String userId) {
        if (!userData.getUserById().containsKey(userId)) {
            throw new FoodDeliveryException(ExceptionType.USER_NOT_FOUND, "user not found");
        }
        userData.getUserById().remove(userId);
    }

    public void updateUser(@NonNull final User user) {
        if (!userData.getUserById().containsKey(user.getId())) {
            throw new FoodDeliveryException(ExceptionType.USER_NOT_FOUND, "user not found");
        }
        userData.getUserById().put(user.getId(), user);
    }

    public User getUser(@NonNull final String userId) {
        if (!userData.getUserById().containsKey(userId)) {
            throw new FoodDeliveryException(ExceptionType.USER_NOT_FOUND, "user not found");
        }
        return userData.getUserById().get(userId);
    }
}

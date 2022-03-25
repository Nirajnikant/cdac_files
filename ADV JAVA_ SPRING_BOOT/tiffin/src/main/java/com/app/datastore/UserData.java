package com.app.datastore;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.app.model.User;

import lombok.Getter;

@Component
@Getter
public class UserData {
    private Map<String, User> userById = new HashMap<>();
}

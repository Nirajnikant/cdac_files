package com.app.datastore;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.app.model.Order;

import lombok.Getter;

@Component
@Getter
public class OrderData {
    private Map<String, Order> orderById = new HashMap<>();
    private Map<String, List<String>> orderIdsByUserId = new HashMap<>();

}

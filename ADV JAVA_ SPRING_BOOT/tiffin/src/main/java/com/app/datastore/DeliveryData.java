package com.app.datastore;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.app.model.Delivery;

import lombok.Getter;

@Component
@Getter
public class DeliveryData {
    private Map<String, Delivery> deliveryById = new HashMap<>();
    private Map<String, List<String>> deliveryIdsByDeliveryBoyId = new HashMap<>();
}

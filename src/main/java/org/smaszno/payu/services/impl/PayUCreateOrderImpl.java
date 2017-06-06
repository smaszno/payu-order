package org.smaszno.payu.services.impl;

import org.smaszno.payu.model.AuthTokenResponse;
import org.smaszno.payu.model.Order;
import org.smaszno.payu.model.OrderResponse;
import org.smaszno.payu.services.PayUCreateOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by smaszno on 2017-06-05.
 */
@Service
public class PayUCreateOrderImpl implements PayUCreateOrder {

    private static final String ENV_PREFIX = "payu.create_order.";

    URI uri;

    @Autowired
    public PayUCreateOrderImpl(Environment env) {
        uri = URI.create(env.getProperty(ENV_PREFIX + "url"));
    }

    public OrderResponse createOrder(AuthTokenResponse authTokenResponse, Order order) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(HttpHeaders.AUTHORIZATION, authTokenResponse.getAsHeader());
        RequestEntity<Order> requestEntity = new RequestEntity<>(order, headers, HttpMethod.POST, uri, Order.class);
        ResponseEntity<OrderResponse> response  = restTemplate.postForEntity(uri, requestEntity, OrderResponse.class);
        return response.getBody();

    }


}

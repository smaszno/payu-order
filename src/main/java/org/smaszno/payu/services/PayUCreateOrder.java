package org.smaszno.payu.services;

import org.smaszno.payu.model.AuthTokenResponse;
import org.smaszno.payu.model.Order;
import org.smaszno.payu.model.OrderResponse;
import org.springframework.stereotype.Service;

/**
 * Created by smaszno on 2017-06-06.
 */
@Service
public interface PayUCreateOrder {
    OrderResponse createOrder(AuthTokenResponse authTokenResponse, Order order);
}

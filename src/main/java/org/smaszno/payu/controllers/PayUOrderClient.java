package org.smaszno.payu.controllers;

import org.smaszno.payu.model.AuthTokenResponse;
import org.smaszno.payu.model.Order;
import org.smaszno.payu.model.OrderResponse;
import org.smaszno.payu.services.PayUAuthorize;
import org.smaszno.payu.services.PayUCreateOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by smaszno on 04/06/2017.
 */
@Controller
public class PayUOrderClient  {


    @Autowired
    PayUAuthorize payUAuthorize;
    @Autowired
    PayUCreateOrder payUCreateOrder;


    public AuthTokenResponse authorize()
    {
        return payUAuthorize.authorize();
    }

    public OrderResponse order(AuthTokenResponse authTokenResponse, Order order)
    {
        order.setMerchantPosId(payUAuthorize.getClientId());
        return payUCreateOrder.createOrder(authTokenResponse, order);
    }


    public OrderResponse orderWithAuthorization(Order order)
    {
        AuthTokenResponse authTokenResponse = authorize();
        if (authTokenResponse != null && authTokenResponse.getAccessToken() != null) {
            return order(authTokenResponse, order);
        }
        return null;
    }




}

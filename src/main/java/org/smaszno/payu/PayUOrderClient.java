package org.smaszno.payu;

import org.smaszno.payu.model.AuthTokenResponse;
import org.smaszno.payu.model.Order;
import org.smaszno.payu.model.OrderResponse;
import org.smaszno.payu.services.PayUAuthorize;
import org.smaszno.payu.services.PayUCreateOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

/**
 * Created by smaszno on 04/06/2017.
 */
@Controller
public class PayUOrderClient  {



    PayUAuthorize payUAuthorize;
    PayUCreateOrder payUCreateOrder;

    @Autowired
    public PayUOrderClient(PayUAuthorize payUAuthorize, PayUCreateOrder payUCreateOrder) {
        this.payUAuthorize = payUAuthorize;
        this.payUCreateOrder = payUCreateOrder;
    }

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

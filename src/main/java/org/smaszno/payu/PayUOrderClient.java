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
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

/**
 * Created by smaszno on 04/06/2017.
 */
@SpringBootApplication
public class PayUOrderClient implements CommandLineRunner {



    PayUAuthorize payUAuthorize;
    PayUCreateOrder payUCreateOrder;

    @Autowired
    public PayUOrderClient(PayUAuthorize payUAuthorize, PayUCreateOrder payUCreateOrder) {
        this.payUAuthorize = payUAuthorize;
        this.payUCreateOrder = payUCreateOrder;
    }

    @Override
    public void run(String... strings) throws Exception {
        AuthTokenResponse resp = payUAuthorize.authorize();
        if (resp != null && resp.getAccessToken() != null)
            payUCreateOrder.createOrder(resp, Order.generateMock());
    }

    public static void main(String []args)
    {
        SpringApplication.run(PayUOrderClient.class, args);
    }



}

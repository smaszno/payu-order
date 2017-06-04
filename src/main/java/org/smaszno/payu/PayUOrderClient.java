package org.smaszno.payu;

import org.smaszno.payu.model.AuthToken;
import org.smaszno.payu.model.Order;
import org.smaszno.payu.model.OrderResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

/**
 * Created by smaszno on 04/06/2017.
 */
@SpringBootApplication
public class PayUOrderClient {


    private static void placeOrderForShop(Order order, AuthToken authToken, String url) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(HttpHeaders.AUTHORIZATION, authToken.toString());
        RequestEntity<Order> requestEntity = new RequestEntity<>(order, headers, HttpMethod.POST, URI.create(url), Order.class);

        ResponseEntity<OrderResponse> response  = restTemplate.postForEntity(URI.create(url), requestEntity, OrderResponse.class);


        HttpStatus responseStatusCode = response.getStatusCode();
    }



    public static void main(String []args)
    {
        SpringApplication.run(PayUOrderClient.class, args);

        try {
            placeOrderForShop(Order.generateMock(), AuthToken.generateMock(), "https://secure.payu.com/api/v2_1/orders/");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }



}

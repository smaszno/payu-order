package org.smaszno.payu;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smaszno.payu.config.AppConfigTest;
import org.smaszno.payu.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by smaszno on 2017-06-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {AppConfigTest.class, PayUOrderClient.class})
public class PayUOrderClientTest {

    @Autowired
    PayUOrderClient payUOrderClient;

    AuthTokenResponse authTokenResponseMock;
    Order orderMock;

    @Test
    public void authorize() throws Exception {
        AuthTokenResponse authTokenResponse = payUOrderClient.authorize();
        assertTrue("authorize: access token should not be empty", authTokenResponse.getAccessToken() != null);
        assertTrue("authorize: token type should not be empty", authTokenResponse.getTokenType() != null);
    }

    private void checkOrderResponse(OrderResponse orderResponse)
    {
        assertTrue("order: status should not be empty", orderResponse.getStatus() != null);
        assertTrue("order: redirectUri should not be empty", orderResponse.getRedirectUri() != null);
        assertTrue("order: orderId should not be empty", orderResponse.getOrderId() != null);
        OrderResponseStatus status = orderResponse.getStatus();
        assertEquals("order: status code should be equal to SUCCESS", status.getStatusCode(), "SUCCESS");

    }


    @Test
    public void order() throws Exception {
        checkOrderResponse(payUOrderClient.order(authTokenResponseMock, orderMock));
    }

    @Test
    public void orderWithAuthorization() throws Exception {
        checkOrderResponse(payUOrderClient.orderWithAuthorization(orderMock));
    }


    @Before
    public void setUp() throws Exception {
        authTokenResponseMock = generateAuthTokenResponseMock();
        orderMock = generateOrderMock();
    }

    private  Order generateOrderMock() {
        Order order = new Order();
        order.setNotifyUrl("https://your.eshop.com/notify");
        order.setCustomerIp("127.0.0.1");

        order.setDescription("RTV market");
        order.setCurrencyCode("PLN");
        order.setTotalAmount(21000);
        order.addProduct(generateProductMock("Wireless mouse", 15000, 1));
        order.addProduct(generateProductMock("HDMI cable", 6000, 1));
        return order;
    }

    private Product generateProductMock(String name, Integer unitPrice, Integer quantity)
    {
        Product product = new Product();
        product.setName(name);
        product.setUnitPrice(unitPrice);
        product.setQuantity(quantity);
        product.setListingDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        return product;
    }

    private AuthTokenResponse generateAuthTokenResponseMock()
    {
        AuthTokenResponse at = new AuthTokenResponse();
        at.setTokenType("bearer");
        at.setAccessToken("3e5cac39-7e38-4139-8fd6-30adc06a61bd");
        return at;
    }

}
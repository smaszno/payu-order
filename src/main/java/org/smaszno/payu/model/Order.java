package org.smaszno.payu.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smaszno on 04/06/2017.
 */
@Data
public class Order {

    String extOrderId;

    String notifyUrl;
    String orderUrl;
    String customerIp;
    String merchantPosId;
    Integer validityTime;
    String description;
    String additionalDescription;
    String currencyCode;
    Integer totalAmount;
    String continueUrl;
    OrderSettings settings;
    Buyer buyer;

    List<ShippingMethod> shippingMethods = new ArrayList<>();
    List<Product> products = new ArrayList<>();







    public void addProduct(Product product) {
        products.add(product);
    }

    public void addShippingMethod(ShippingMethod product) {
        shippingMethods.add(product);
    }

    public static Order generateMock() {
        Order order = new Order();
        order.notifyUrl = "https://your.eshop.com/notify";
        order.customerIp = "127.0.0.1";
        order.merchantPosId = "145227";
        order.description = "RTV market";
        order.currencyCode = "PLN";
        order.totalAmount = 21000;
        order.addProduct(Product.generateMock("Wireless mouse", 15000, 1));
        order.addProduct(Product.generateMock("HDMI cable", 6000, 1));
        return order;
    }

}
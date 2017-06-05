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


}
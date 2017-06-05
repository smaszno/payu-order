package org.smaszno.payu.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.smaszno.payu.serializers.ProductListingDateDeserializer;
import org.smaszno.payu.serializers.ProductListingDateSerializer;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by smaszno on 04/06/2017.
 */

@Data
public class Product {




    String name;
    Integer unitPrice;
    Integer quantity;
    boolean virtual = false;

    @JsonSerialize(using = ProductListingDateSerializer.class)
    @JsonDeserialize(using = ProductListingDateDeserializer.class)
    Date listingDate;


    public static Product generateMock(String name, Integer unitPrice, Integer quantity)
    {
        Product product = new Product();
        product.name = name;
        product.unitPrice = unitPrice;
        product.quantity = quantity;
        product.listingDate = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        return product;
    }

}

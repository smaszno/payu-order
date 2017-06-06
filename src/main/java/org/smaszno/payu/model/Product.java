package org.smaszno.payu.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.smaszno.payu.serializers.ProductListingDateDeserializer;
import org.smaszno.payu.serializers.ProductListingDateSerializer;

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



}

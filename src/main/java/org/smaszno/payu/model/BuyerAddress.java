package org.smaszno.payu.model;

import lombok.Data;

/**
 * Created by smaszno on 04/06/2017.
 */
@Data
public class BuyerAddress {
    String street;
    String postalBox;
    String postalCode;
    String city;
    String state;
    String countryCode;
    String name;
    String recipientName;
    String recipientEmail;
    String recipientPhone;
}

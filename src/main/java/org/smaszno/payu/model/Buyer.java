package org.smaszno.payu.model;

import lombok.Data;

/**
 * Created by smaszno on 04/06/2017.
 */
@Data
public class Buyer {


    String customerIp;
    String extCustomerId;
    String email;
    String phone;
    String firstName;
    String lastName;
    String nin;
    String language;
    BuyerAddress delivery;
    BuyerAddress billing;
    BuyerInvoice invoice;
}

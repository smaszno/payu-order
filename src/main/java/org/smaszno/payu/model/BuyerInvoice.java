package org.smaszno.payu.model;

import lombok.Data;

/**
 * Created by smaszno on 04/06/2017.
 */
@Data
public class BuyerInvoice extends BuyerAddress {

    String tin;
    boolean eInvoiceRequested = false;
}

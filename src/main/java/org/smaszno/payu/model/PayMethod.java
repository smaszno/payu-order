package org.smaszno.payu.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by smaszno on 04/06/2017.
 */
@Data
@AllArgsConstructor
public class PayMethod {

    public enum Types
    {
        PBL, CARD_TOKEN, BANK_TOKEN;
    }


    String type;
    String value;
    String authorizationCode;
}

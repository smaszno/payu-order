package org.smaszno.payu.model;

import lombok.Data;

/**
 * Created by smaszno on 04/06/2017.
 */
@Data
public class AuthToken {
    String type;
    String code;


    public String toString()
    {
        return type + " "+ code;
    }

    public static AuthToken generateMock()
    {
        AuthToken at = new AuthToken();
        at.type = "bearer";
        at.code = "3e5cac39-7e38-4139-8fd6-30adc06a61bd";
        return at;
    }
}

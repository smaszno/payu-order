package org.smaszno.payu.services;

import org.smaszno.payu.model.AuthTokenResponse;
import org.springframework.stereotype.Service;

/**
 * Created by smaszno on 2017-06-06.
 */
@Service
public interface PayUAuthorize {
    AuthTokenResponse authorize();
    String getClientId();
}

package org.smaszno.payu.services.impl;

import org.smaszno.payu.model.AuthTokenResponse;
import org.smaszno.payu.services.PayUAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;

/**
 * Created by smaszno on 2017-06-05.
 */
@Service
public class PayUAuthorizeImpl implements PayUAuthorize {

    private static final String ENV_PREFIX = "payu.authorize.";

    private enum FormParam { GRANT_TYPE, CLIENT_ID, CLIENT_SECRET};



    URI uri;
    LinkedHashMap <FormParam, String> formParamsCache = new LinkedHashMap<>(FormParam.values().length);

    @Autowired
    public PayUAuthorizeImpl(Environment env)
    {
        uri = URI.create(env.getProperty(ENV_PREFIX + "url"));
        for (FormParam formParam : FormParam.values() )
            formParamsCache.put(formParam, env.getProperty(ENV_PREFIX + formParam.name().toLowerCase()));

    }


    public AuthTokenResponse authorize()
    {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap(FormParam.values().length);
        for (FormParam formParam : FormParam.values() )
            form.add(formParam.name().toLowerCase(), formParamsCache.get(formParam));

        ResponseEntity<AuthTokenResponse> response  = restTemplate.postForEntity(uri, form, AuthTokenResponse.class);
        return response.getBody();
    }


    public String getClientId()
    {
        return formParamsCache.get(FormParam.CLIENT_ID);
    }


}

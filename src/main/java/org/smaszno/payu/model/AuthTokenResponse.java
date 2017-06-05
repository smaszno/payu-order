package org.smaszno.payu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by smaszno on 04/06/2017.
 */

@Data
public class AuthTokenResponse {

    @JsonProperty("access_token")
    String accessToken;
    @JsonProperty("token_type")
    String tokenType;
    @JsonProperty("refresh_token")
    String refreshToken;
    @JsonProperty("expires_in")
    String expiresIn;
    @JsonProperty("grant_type")
    String grantType;


  /*  public String toString()
    {
        return tokenType + " "+ accessToken;
    }
*/

    public String getAsHeader()
    {
        return tokenType + " "+ accessToken;
    }

    public static AuthTokenResponse generateMock()
    {
        AuthTokenResponse at = new AuthTokenResponse();
        at.tokenType = "bearer";
        at.accessToken = "3e5cac39-7e38-4139-8fd6-30adc06a61bd";
        return at;
    }
}

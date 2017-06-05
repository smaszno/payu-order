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


}

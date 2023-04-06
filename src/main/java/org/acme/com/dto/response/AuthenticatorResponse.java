package org.acme.com.dto.response;

import org.acme.com.dto.UserDTOResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticatorResponse {

    private UserDTOResponse user;

    private String token;

    private boolean authenticated;
    
}

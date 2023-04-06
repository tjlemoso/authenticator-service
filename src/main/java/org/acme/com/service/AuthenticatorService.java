package org.acme.com.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.acme.com.client.UserService;
import org.acme.com.dto.UserDTOResponse;
import org.acme.com.dto.response.AuthenticatorResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class AuthenticatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticatorService.class);


    @Inject @RestClient UserService userService;
    

    public AuthenticatorResponse validadeUser(String name, String password){

        UserDTOResponse user = userService.getUserByName(name);


        if(user.getPassword().equals(password)){

            LOGGER.info("password equal");

            UserDTOResponse userResponse = new UserDTOResponse();
            userResponse.setUserId(user.getUserId());
            userResponse.setIsAdmin(user.getIsAdmin());
            userResponse.setName(user.getName());
            userResponse.setPassword(user.getPassword());
            
            AuthenticatorResponse response = new AuthenticatorResponse();
            response.setUser(userResponse);
            response.setToken("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlivFI8qB4D0y2jy0CfEqFyy46R0o7S8TKpsx5xbHKoU1VWg6QkQm+ntyIv1p4kE1sPEQO73+HY8+Bzs75XwRTYL1BmR1w8J5hmjVWjc6R2BTBGAYRPFRhor3kpM6ni2SPmNNhurEAHw7TaqszP5eUF/F9+KEBWkwVta+PZ37bwqSE4sCb1soZFrVz/UT/LF4tYpuVYt3YbqToZ3pZOZ9AX2o1GCG3xwOjkc4x0W7ezbQZdC9iftPxVHR8irOijJRRjcPDtA6vPKpzLl6CyYnsIYPd99ltwxTHjr3npfv/3Lw50bAkbT4HeLFxTx4flEoZLKO/g0bAoV2uqBhkA9xnQIDAQAB");
            response.setAuthenticated(true);

            return response;

        } 
        AuthenticatorResponse response = new AuthenticatorResponse();
        //response.setAuthenticated(true);
        return response ;
    }
}

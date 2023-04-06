package org.acme.com.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.acme.com.dto.response.AuthenticatorResponse;
import org.acme.com.service.AuthenticatorService;

@Path("authenticator")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class AuthenticatorResource {
    
    @Inject AuthenticatorService authenticatorService;

    @POST
    @Path("/{name}/password/{password}")
    public Response authenticate(@PathParam("name") String name, @PathParam("password") String password) {
        
        AuthenticatorResponse result = authenticatorService.validadeUser(name, password);
        
        return Response.ok(result).status(200).build();
    }
}

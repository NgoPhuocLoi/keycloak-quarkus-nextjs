package org.acme.user;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserResource {

    @Inject
    SecurityIdentity identity;

    @Path("/me")
    @GET
    public Response me() {
        return Response.status(200).entity(new User(identity.getPrincipal().getName())).build();
    }
}

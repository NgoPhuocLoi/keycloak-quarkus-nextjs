package org.acme.user;

import jakarta.ws.rs.core.MediaType;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/admin")
@Authenticated
public class AdminResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("ADMIN")
    public String admin() {
        return "granted";
    }
}

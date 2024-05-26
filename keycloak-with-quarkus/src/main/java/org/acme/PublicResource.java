package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/public")
public class PublicResource {

    @GET
    public String publicResource() {
        return "public";
    }
}

package com.carlos.restaurantbooking.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

// Documentation from https://muserver.io/jaxrs from A basic example
@Path("/v1/")
public class WelcomeController {

    @GET
    @Produces("text/plain")
    public String get() {
        return """
                Welcome!
                                
                Endpoints:
                -> POST /v1/customer/booking
                -> GET /v1/owner/booking
                
                Documentation:
                ->API HTML: http://localhost:8080/api/api.html
                ->API JSON: http://localhost:8080/api/openapi.json
                """;
    }


}

package com.carlos.restaurantbooking;

import com.carlos.restaurantbooking.controller.BookingController;
import com.carlos.restaurantbooking.controller.WelcomeController;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import io.muserver.ContextHandlerBuilder;
import io.muserver.MuServer;
import io.muserver.MuServerBuilder;
import io.muserver.rest.CORSConfigBuilder;
import io.muserver.rest.RestHandlerBuilder;

public class RestaurantbookingApplication {


    public static void main(String[] args) {

        BookingController bookingController = new BookingController();


        MuServer server = MuServerBuilder.httpServer()
                // Add more addHandler if you need
                // Http configuration documentation at https://muserver.io/https
                .withHttpPort(8080)
                .addHandler(
                        // Context path documentation at https://muserver.io/contexts
                        ContextHandlerBuilder.context("api")
                                .addHandler(RestHandlerBuilder.restHandler(new WelcomeController())
                                ))
                .addHandler(
                        ContextHandlerBuilder.context("api")
                                .addHandler(
                                        RestHandlerBuilder.restHandler(bookingController)
                                                .addCustomReader(new JacksonJaxbJsonProvider())
                                                .addCustomWriter(new JacksonJaxbJsonProvider()))
                )
                .addHandler(
                        ContextHandlerBuilder.context("api")
                                .addHandler(createRestHandler())
                )
                .start();
        System.out.println("Server started on " + server.uri().resolve("/api/v1"));
        System.out.println("API HTML: " + server.uri().resolve("/api/api.html"));
        System.out.println("API JSON: " + server.uri().resolve("/api/openapi.json"));
    }

    //see https://muserver.io/jaxrs#documentation
    public static RestHandlerBuilder createRestHandler() {
        return RestHandlerBuilder.restHandler(new BookingController())
                .withCORS(CORSConfigBuilder.corsConfig().withAllowedOriginRegex(".*"))
                .withOpenApiHtmlUrl("/api.html")
                .withOpenApiJsonUrl("/openapi.json");


    }

}

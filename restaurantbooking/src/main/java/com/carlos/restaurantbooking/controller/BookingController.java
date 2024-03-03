package com.carlos.restaurantbooking.controller;

import com.carlos.restaurantbooking.model.Booking;
import io.muserver.rest.ApiResponse;
import io.muserver.rest.Description;
import io.muserver.rest.Required;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import java.util.List;

// Documentation from https://muserver.io/jaxrs from Serialisation with Jackson JAX-RS

@Path("/v1/")
@Description(value = "A human user", details = "Use this API to get and create bookings at the restaurant")
public class BookingController {

    @GET
    @Path("/owner/booking/")
    @Description("Existing bookings")
    @Produces("application/json")
    @ApiResponse(code = "200", message = "Success")
    public List<Booking> getBooking() {
        List<Booking> bookings = new ArrayList<>();
        Booking bookingOne = new Booking();
        bookingOne.setCustomerName("Carlos");
        bookingOne.setTableSize(3);
        bookingOne.setDate(LocalDate.of(2024, 3, 1).toString());
        bookingOne.setReservationStart(LocalTime.of(10, 0).toString());
        bookingOne.setReservationEnd(LocalTime.of(12, 0).toString());

        bookings.add(bookingOne);
        Booking bookingTwo = new Booking();
        bookingTwo.setCustomerName("Esquivel");
        bookingTwo.setTableSize(5);
        bookingTwo.setDate(LocalDate.of(2024, 3, 3).toString());
        bookingTwo.setReservationStart(LocalTime.of(14, 0).toString());
        bookingTwo.setReservationEnd(LocalTime.of(16, 0).toString());
        bookings.add(bookingTwo);

        return bookings;

    }

    @POST
    @Path("/customer/booking/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Description("Make a booking")
    @ApiResponse(code = "201", message = "The booking was created")
    @ApiResponse(code = "100", message = "The name was not specified")
    @ApiResponse(code = "101", message = "The table size must be equal to or greater than two and less than 11")
    @ApiResponse(code = "102", message = "The date that you want to reserve is incorrect. It must by the following format YYYY-mm-dd. ")
    public Response create(
            @Description("A unique Customer Name for the new booking")
            @Required @FormParam("customerName") String customerName,
            @Description("The table of the size that you want")
            @Required @FormParam("tableSize") int tableSize,
            @Description("The date that you want to reserve. It must by the following format YYYY-mm-dd")
            @Required @FormParam("date") String date,
            @Description("The start time of your reservation (example 10:00) Note: remember Your reservation lasts two hours from the start time ")
            @Required @FormParam("reservationStart") String localTime) {


        // Some data validations
        if (customerName.isEmpty()) {
            return Response.status(100).build();
        }
        if (tableSize > 10 || tableSize <= 2) {
            return Response.status(101).build();
        }
        // Add extra validation
        return Response.status(201).build();

    }

    // You can add more methods as you request


}



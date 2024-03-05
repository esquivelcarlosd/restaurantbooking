package com.carlos.restaurantbooking.controller;

import com.carlos.restaurantbooking.model.Booking;
import com.carlos.restaurantbooking.service.BookingService;
import io.muserver.rest.ApiResponse;
import io.muserver.rest.Description;
import io.muserver.rest.Required;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/v1/")
@Description(value = "A human user", details = "Use this API to get and create bookings at the restaurant")
public class BookingController {

    // Documentation https://muserver.io/jaxrs#documentation
    @GET
    @Path("/owner/booking/{dateFromRequest}")
    @Description("Existing bookings")
    @Produces("application/json")
    @ApiResponse(code = "200", message = "Success")
    public List<Booking> getBookingByDate(
            @Description("The booking that you want to search by date")
            @Required @PathParam("dateFromRequest") String dateFromRequest) {

        List<Booking> bookingByDate = new ArrayList<>();
        String year = String.valueOf(dateFromRequest.charAt(0)) + String.valueOf(dateFromRequest.charAt(1)) + String.valueOf(dateFromRequest.charAt(2)) + String.valueOf(dateFromRequest.charAt(3));
        String month = String.valueOf(dateFromRequest.charAt(4)) + String.valueOf(dateFromRequest.charAt(5));
        String day = String.valueOf(dateFromRequest.charAt(6)) + String.valueOf(dateFromRequest.charAt(7));

        for (int i = 0; i < BookingService.gettAllBookingsList().size(); i++) {
            if (BookingService.gettAllBookingsList().get(i).getBookingDate().equals(year + "-" + month + "-" + day)) {
                bookingByDate.add(BookingService.gettAllBookingsList().get(i));
            }
        }


        return bookingByDate;
    }

    @GET
    @Path("/owner/booking/")
    @Description("Existing bookings")
    @Produces("application/json")
    @ApiResponse(code = "200", message = "Success")
    public List<Booking> getBookings() {
        return BookingService.gettAllBookingsList();
    }

    @POST
    @Path("/customer/booking/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Description("Make a booking")
    @ApiResponse(code = "201", message = "The booking was created")
    @ApiResponse(code = "422", message = "Wrong data according to the validations")
    public Response create(
            @Description("A unique Customer Name for the new booking")
            @Required @FormParam("customerName") String customerName,
            @Description("The table of the size that you want")
            @Required @FormParam("tableSize") int tableSize,
            @Description("The date that you want to reserve. It must by the following format YYYY-mm-dd")
            @Required @FormParam("bookingDate") String bookingDate,
            @Description("The start time of your reservation (example 10) Note: remember Your reservation lasts two hours from the start time and The reservation time must be between 13 to 22 horus")
            @Required @FormParam("reservationStart") int reservationStartHour) {


        if (customerName.isEmpty()) {
            return Response.status(422).build();
        }
        if (tableSize > 10 || tableSize <= 2) {
            return Response.status(422).build();
        }
        if (reservationStartHour < 13 || reservationStartHour > 22) {
            return Response.status(422).build();
        }

        // Add more validations
        Booking newBooking = new Booking();
        newBooking.setCustomerName(customerName);
        newBooking.setTableSize(tableSize);
        newBooking.setBookingDate(bookingDate);
        newBooking.setReservationStartHour(reservationStartHour);
        newBooking.setReservationEndHour(reservationStartHour + 2);
        BookingService.addNewBooking(newBooking);
        return Response.status(201).build();

    }

    // You can add more methods as you request


}



package com.carlos.restaurantbooking.service;

import com.carlos.restaurantbooking.model.Booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingService {

    // This class represents a database
    // Other classes like repository could be implemented with JDBC/JPARepository to the data persistence.
    private static final List<Booking> bookings = new ArrayList<>();

    static {
        Booking bookingOne = new Booking();
        bookingOne.setCustomerName("Carlos");
        bookingOne.setTableSize(3);
        bookingOne.setDate(LocalDate.of(2024, 3, 1).toString());
        bookingOne.setReservationStartHour(17);
        bookingOne.setReservationEndHour(19);

        bookings.add(bookingOne);
        Booking bookingTwo = new Booking();
        bookingTwo.setCustomerName("Esquivel");
        bookingTwo.setTableSize(5);
        bookingTwo.setDate(LocalDate.of(2024, 3, 3).toString());
        bookingTwo.setReservationStartHour(16);
        bookingTwo.setReservationEndHour(18);
        bookings.add(bookingTwo);
    }

    public static List<Booking> gettAllBookingsList() {
        return bookings;
    }

    public static void addNewBooking(Booking booking) {
        bookings.add(booking);
    }
}

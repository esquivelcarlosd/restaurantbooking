package com.carlos.restaurantbooking.model;

import java.time.LocalDate;

public class Booking {

    private String customerName;
    private int tableSize;
    private String bookingDate;

    private int reservationStartHour;

    private int reservationEndHour;

    public Booking() {

    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getReservationStartHour() {
        return reservationStartHour;
    }

    public void setReservationStartHour(int reservationStartHour) {
        this.reservationStartHour = reservationStartHour;
    }

    public int getReservationEndHour() {
        return reservationEndHour;
    }

    public void setReservationEndHour(int reservationEndHour) {
        this.reservationEndHour = reservationEndHour;
    }
}

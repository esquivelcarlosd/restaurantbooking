package com.carlos.restaurantbooking.model;

public class Booking {

    private String customerName;
    private int tableSize;
    private String date; // Remove

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

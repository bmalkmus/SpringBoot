package com.bmalk.springboot.lil.learningspring.data.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reservationID;
    @Column(name = "ROOM_ID")
    private long roomID;
    @Column(name = "GUEST_ID")
    private long guestID;
    @Column(name = "RES_DATE")
    private Date resDate;


    public long getReservationID() {
        return this.reservationID;
    }

    public void setReservationID(long reservationID) {
        this.reservationID = reservationID;
    }

    public long getRoomID() {
        return this.roomID;
    }

    public void setRoomID(long roomID) {
        this.roomID = roomID;
    }

    public long getGuestID() {
        return this.guestID;
    }

    public void setGuestID(long guestID) {
        this.guestID = guestID;
    }

    public Date getResDate() {
        return this.resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }

}

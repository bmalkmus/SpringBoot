package com.bmalk.springboot.lil.learningspring.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bmalk.springboot.lil.learningspring.business.domain.RoomReservation;
import com.bmalk.springboot.lil.learningspring.data.entity.Guest;
import com.bmalk.springboot.lil.learningspring.data.entity.Reservation;
import com.bmalk.springboot.lil.learningspring.data.entity.Room;
import com.bmalk.springboot.lil.learningspring.data.repository.GuestRepository;
import com.bmalk.springboot.lil.learningspring.data.repository.ReservationRepository;
import com.bmalk.springboot.lil.learningspring.data.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }



    public List <RoomReservation> getRoomReservationForDate(Date date){
        Iterable<Room> rooms= this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getRoomId(), roomReservation);
        });
        Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomID());
            roomReservation.setDate(date);

            Guest guest = this.guestRepository.findById(reservation.getGuestID()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestID());
        });
        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long id: roomReservationMap.keySet()){
            roomReservations.add(roomReservationMap.get(id));
        }
        return roomReservations;
    }
}

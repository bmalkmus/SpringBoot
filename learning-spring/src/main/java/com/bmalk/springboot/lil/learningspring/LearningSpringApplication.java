package com.bmalk.springboot.lil.learningspring;

import com.bmalk.springboot.lil.learningspring.data.entity.Guest;
import com.bmalk.springboot.lil.learningspring.data.entity.Reservation;
import com.bmalk.springboot.lil.learningspring.data.entity.Room;
import com.bmalk.springboot.lil.learningspring.data.repository.GuestRepository;
import com.bmalk.springboot.lil.learningspring.data.repository.ReservationRepository;
import com.bmalk.springboot.lil.learningspring.data.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LearningSpringApplication {

	public static void main(String[] args) {
        SpringApplication.run(LearningSpringApplication.class, args);
    }

    @RestController
    @RequestMapping(value = "/rooms")
    public class RoomController{
        @Autowired
        private RoomRepository roomRepository;

        @GetMapping
        public Iterable<Room> getRooms(){
            return this.roomRepository.findAll();
        }

    }

    @RestController
    @RequestMapping(value = "/guests")
    public class GuestController{
        @Autowired
        private GuestRepository guestRepository;

        @GetMapping
        public Iterable<Guest> getGuests(){
            return this.guestRepository.findAll();
        }

    }

    @RestController
    @RequestMapping(value = "/reservations")
    public class ReservationController{
        @Autowired
        private ReservationRepository reservationRepository;

        @GetMapping
        public Iterable<Reservation> getRervastions(){
            return this.reservationRepository.findAll();
        }

    }

}

package com.bmalk.springboot.lil.learningspring.web;

import java.util.List;

import com.bmalk.springboot.lil.learningspring.business.service.ReservationService;
import com.bmalk.springboot.lil.learningspring.data.entity.Guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guests")
public class GuestWebController {
    private final ReservationService reservationService;

    @Autowired
    public GuestWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getGuests(Model model){
        List<Guest> guestList = this.reservationService.getHotelGuests();
        model.addAttribute("guestList", guestList);
        return "guests";
    }

}

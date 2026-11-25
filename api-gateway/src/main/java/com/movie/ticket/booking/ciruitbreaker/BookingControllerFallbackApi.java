package com.movie.ticket.booking.ciruitbreaker;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Mono;

@RestController
public class BookingControllerFallbackApi {

    @GetMapping("/booking-fallback")
    public String bookingFallBack(){
     return "Booking-service is in maintaince mode please try after some time";
    }

}

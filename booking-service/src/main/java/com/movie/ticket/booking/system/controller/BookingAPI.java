package com.movie.ticket.booking.system.controller;



import com.movie.ticket.booking.system.constants.LoggerConstants;
import com.movie.ticket.booking.system.dtos.BookingDTO;
import com.movie.ticket.booking.system.dtos.BookingStatus;
import com.movie.ticket.booking.system.services.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@Slf4j
public class BookingAPI {

//    @Autowired
//    private PaymentServiceBroker paymentServiceBroker;

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {

        log.info(LoggerConstants.ENTERED_CONTROLLER_MESSAGE.getValue(),"create booking",this.getClass(),bookingDTO.toString());
        BookingDTO bookingdto = bookingService.createBooking(bookingDTO);
        log.info(LoggerConstants.EXITING_CONTROLLER_MESSAGE.getValue(),"create booking",this.getClass(),bookingDTO.toString());
        return new ResponseEntity<>(bookingdto, HttpStatus.CREATED);
    }

}

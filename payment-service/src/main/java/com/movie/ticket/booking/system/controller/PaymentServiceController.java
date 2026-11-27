package com.movie.ticket.booking.system.controller;

import com.movie.ticket.booking.system.constants.LoggerConstants;
import com.movie.ticket.booking.system.dtos.BookingDTO;
import com.movie.ticket.booking.system.dtos.PaymentDTO;
import com.movie.ticket.booking.system.enums.PaymentStatus;
import com.movie.ticket.booking.system.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/payments")
@Slf4j
public class PaymentServiceController {


    @Autowired
    private PaymentService paymentService;


    @PostMapping
    public BookingDTO createPayment(@RequestBody BookingDTO bookingDTO) {

        log.info(LoggerConstants.ENTERED_CONTROLLER_MESSAGE.getValue(), "create booking", this.getClass(), bookingDTO.toString());
        return this.paymentService.createPayment(bookingDTO);
    }

}

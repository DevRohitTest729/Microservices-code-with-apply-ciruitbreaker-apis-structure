package com.movie.ticket.booking.system.service;

import com.movie.ticket.booking.system.dtos.BookingDTO;

public interface PaymentService {

    BookingDTO createPayment(BookingDTO bookingDTO);

}


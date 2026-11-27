package com.movie.ticket.booking.system.services;

import com.movie.ticket.booking.system.dtos.BookingDTO;

public interface BookingService {

    BookingDTO createBooking(BookingDTO bookingDTO);
}

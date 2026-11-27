package com.movie.ticket.booking.system.services.impl;

import com.movie.ticket.booking.system.broker.PaymentServiceBroker;
import com.movie.ticket.booking.system.dtos.BookingDTO;
import com.movie.ticket.booking.system.dtos.BookingStatus;
import com.movie.ticket.booking.system.entity.BookingEntity;

import com.movie.ticket.booking.system.repositories.BookingRespository;
import com.movie.ticket.booking.system.services.BookingService;
import com.movie.ticket.booking.system.utils.mapper.BookingMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookingServiceIMPL implements BookingService {

    @Autowired
    private BookingRespository respository;

    @Autowired
    private PaymentServiceBroker paymentServiceBroker;

    @Autowired
    private BookingMapper bookingMapper;
    private String message;

    @Override
    @Transactional
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        BookingEntity bookingEntity = null;

        bookingEntity = bookingMapper.toBookingEntity(bookingDTO);
        bookingEntity.setBookingStatus(BookingStatus.PENDING);

        BookingEntity bookingEntitySaved = respository.save(bookingEntity);
        // call paymnet service
        BookingDTO bookingDTOResponseFromPayment = this.paymentServiceBroker.createPayment(bookingDTO);
        bookingEntity.setBookingStatus(bookingDTOResponseFromPayment.getBookingStatus());

        BookingDTO bookingDTOSetDataAfterpayment = bookingMapper.toBookingDTO(bookingEntity);

        bookingDTOSetDataAfterpayment.setBookingStatus(bookingDTOResponseFromPayment.getBookingStatus());

        return bookingDTOSetDataAfterpayment;

    }
}

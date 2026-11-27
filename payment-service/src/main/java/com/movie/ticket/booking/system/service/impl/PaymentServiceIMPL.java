package com.movie.ticket.booking.system.service.impl;

import com.movie.ticket.booking.system.constants.LoggerConstants;
import com.movie.ticket.booking.system.dtos.BookingDTO;
import com.movie.ticket.booking.system.dtos.BookingStatus;
import com.movie.ticket.booking.system.entities.PaymentEntity;
import com.movie.ticket.booking.system.enums.PaymentStatus;
import com.movie.ticket.booking.system.repositories.PaymentRespository;
import com.movie.ticket.booking.system.service.PaymentService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class PaymentServiceIMPL implements PaymentService {

    @Autowired
    private PaymentRespository paymentRespository;

    @Autowired
    private  StripePaymentGateway stripePaymentGateway;

    @Override
    @Transactional
    public BookingDTO createPayment(BookingDTO bookingDTO) {

        log.info(LoggerConstants.ENTERED_SERVICE_MESSAGE.getValue(),"create payment",this.getClass(),bookingDTO.toString());


        PaymentEntity paymentEntity = PaymentEntity.builder()
                .paymentStatus(PaymentStatus.PENDING)
                .paymentAmount(bookingDTO.getBookingAmt())
                .bookingId(bookingDTO.getUserId())
                .paymenDateTime(LocalDateTime.now())
                .build();

        PaymentEntity paymentEntitySaved = this.paymentRespository.save(paymentEntity);
        // make call to strip payment service
        PaymentStatus paymentStatus = this.stripePaymentGateway.makePayment(paymentEntitySaved.getPaymentAmount());

        if(paymentStatus.equals(PaymentStatus.APPROVED)){
            paymentEntitySaved.setPaymentStatus(PaymentStatus.CONFIRMED);
            bookingDTO.setBookingStatus(BookingStatus.CONFIRMED);
        }else{
            paymentEntitySaved.setPaymentStatus(PaymentStatus.FAILED);
            bookingDTO.setBookingStatus(BookingStatus.CANCELLED);
        }

        return bookingDTO;

    }
}

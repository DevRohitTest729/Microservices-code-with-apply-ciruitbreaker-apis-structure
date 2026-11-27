package com.movie.ticket.booking.system.dtos;

import com.movie.ticket.booking.system.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO {
    private UUID bookingId;
    private PaymentStatus paymentStatus;
    private Double paymentAmount;
}

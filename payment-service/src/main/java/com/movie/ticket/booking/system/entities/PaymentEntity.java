package com.movie.ticket.booking.system.entities;

import com.movie.ticket.booking.system.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
@Builder
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID paymentId;
    @Column(name = "booking_id")
    private String bookingId;
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "payment_status", joinColumns = @JoinColumn(name = "payment_id"))
    private PaymentStatus paymentStatus;
    @Column(name = "payment_amount")
    private Double paymentAmount;
    @Column(name = "payment_date_time")
    private LocalDateTime paymenDateTime;
}

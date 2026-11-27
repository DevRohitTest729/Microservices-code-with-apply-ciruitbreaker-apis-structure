package com.movie.ticket.booking.system.entity;


import com.movie.ticket.booking.system.dtos.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="bookings")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bookingId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "movie_id")
    private Integer movieId;
    @Column(name = "seats_id")
    @ElementCollection
    @CollectionTable(name = "booking_seats", joinColumns = @JoinColumn(name = "booking_id"))
    private List<String> seats;
    @Column(name = "show_date_id")
    private LocalDate showDate;
    @Column(name = "show_time_id")
    private LocalTime showTime;
    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status")
    private BookingStatus bookingStatus;
    @Column(name = "booking_amount")
    private Double bookingAmt;
}

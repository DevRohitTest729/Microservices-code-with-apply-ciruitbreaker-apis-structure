package com.movie.ticket.booking.system.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookingDTO {

    private UUID bookingId;
    @NotBlank(message = "UserId is required")
    @NotNull
    private String userId;
    @Positive(message = "movie id is mandatory")
    @NotNull
    private Integer movieId;
    @NotNull(message = "user must have booked at least one seat")
    private List<String> seats;
    @NotNull(message = "show date is mandatory")
    private LocalDate showDate;
    @NotNull(message = "show time is mandatory")
    private LocalTime showTime;
    @NotNull(message = "booking amount is mandatory")
    @Positive(message = "amount must be greater than zero")
    private Double bookingAmt;
    private BookingStatus bookingStatus;
}

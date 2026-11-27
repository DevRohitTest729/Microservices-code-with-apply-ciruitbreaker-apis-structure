package com.movie.ticket.booking.system.repositories;

import com.movie.ticket.booking.system.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRespository  extends JpaRepository<BookingEntity, UUID> {
}

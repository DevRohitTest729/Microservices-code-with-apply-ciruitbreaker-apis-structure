package com.movie.ticket.booking.system.repositories;

import com.movie.ticket.booking.system.entities.PaymentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PaymentRespository extends CrudRepository<PaymentEntity, UUID> {
}

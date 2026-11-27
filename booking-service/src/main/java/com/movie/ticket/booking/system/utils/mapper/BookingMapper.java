package com.movie.ticket.booking.system.utils.mapper;


import com.movie.ticket.booking.system.dtos.BookingDTO;
import com.movie.ticket.booking.system.entity.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(target = "bookingId", ignore = true)
    @Mapping(target = "bookingStatus", ignore = true)
    BookingEntity toBookingEntity(BookingDTO bookingDTO);

    // dto to entity
//    @Mapping(target = "bookingId", ignore = true)
    BookingDTO toBookingDTO(BookingEntity bookingEntity);
}

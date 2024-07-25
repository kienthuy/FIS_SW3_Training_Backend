package com.fis.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fis.portal.model.Booking;

@Mapper
public interface BookingMapper {
    List<Booking> search(Booking payload);
    int count(Booking payload);
    int create(Booking booking);
    int update(Booking booking);
    Booking findById(String id);
}

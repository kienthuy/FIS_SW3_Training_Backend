package com.fis.portal.service;

import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Booking;

public interface IBookingService {

    BaseResponse search(Booking request);

    BaseResponse create(Booking booking);

    BaseResponse update(Booking booking);
    
}

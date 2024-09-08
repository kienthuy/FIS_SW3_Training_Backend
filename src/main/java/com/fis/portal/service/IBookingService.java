package com.fis.portal.service;

import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Booking;

public interface IBookingService {

	BaseListResponse search(Booking request);

    BaseResponse create(Booking booking);

    BaseResponse update(Booking booking);
    
}

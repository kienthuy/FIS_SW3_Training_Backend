package com.fis.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.portal.mapper.BookingMapper;
import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Booking;
import com.fis.portal.service.IBookingService;

@Service
public class BookingServiceimpl implements IBookingService {

    @Autowired
    private BookingMapper bookingMapper;

    @Override
    public BaseResponse search(Booking request) {
        List<Booking> list = bookingMapper.search(request);
        int totalRecords = bookingMapper.count(request);
        return new BaseListResponse(list, totalRecords);
    }

    @Override
    public BaseResponse create(Booking booking) {
        try {
            Booking existingBooking = bookingMapper.findById(booking.getId());
            if (existingBooking != null) {
                return new BaseResponse("2", "Booking đã tồn tại trong hệ thống");
            }

            int result = bookingMapper.create(booking);
            if (result > 0) {
                return new BaseResponse("0", "Tạo booking thành công");
            } else {
                return new BaseResponse("1", "Tạo booking thất bại");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseResponse("1", "Tạo booking thất bại");
        }
    }

    @Override
    public BaseResponse update(Booking booking) {
        try {
            int result = bookingMapper.update(booking);
            if (result > 0) {
                return new BaseResponse("0", "Cập nhật booking thành công");
            } else {
                return new BaseResponse("1", "Cập nhật booking thất bại");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseResponse("1", "Cập nhật booking thất bại");
        }
    }


}

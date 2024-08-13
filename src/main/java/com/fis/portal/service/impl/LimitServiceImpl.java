package com.fis.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.portal.mapper.LimitMapper;
import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Limit;
import com.fis.portal.service.ILimitService;

@Service
public class LimitServiceImpl implements ILimitService {

    @Autowired
    private LimitMapper limitMapper;

    @Override
    public BaseResponse search(Limit request) {
        try {
            List<Limit> list = limitMapper.search(request);
            int totalRecords = limitMapper.count(request);
            return new BaseListResponse(list, totalRecords);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseResponse("1", "Tìm kiếm hạn mức sử dụng thất bại");
        }
    }

    @Override
    public BaseResponse create(Limit limit) {
        try {
            // Kiểm tra xem hạn mức sử dụng đã tồn tại chưa
            Limit existingLimit = limitMapper.findByCode(limit.getCode());
            if (existingLimit != null) {
                return new BaseResponse("2", "Hạn mức sử dụng đã tồn tại trong hệ thống");
            }

            // Thực hiện tạo mới hạn mức sử dụng
            int result = limitMapper.create(limit);
            if (result > 0) {
                return new BaseResponse("0", "Tạo hạn mức sử dụng thành công");
            } else {
                return new BaseResponse("1", "Tạo hạn mức sử dụng thất bại");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseResponse("1", "Tạo hạn mức sử dụng thất bại");
        }
    }

    @Override
    public BaseResponse update(Limit limit) {
        try {
            // Thực hiện cập nhật thông tin hạn mức sử dụng
            int result = limitMapper.update(limit);
            if (result > 0) {
                return new BaseResponse("0", "Cập nhật hạn mức sử dụng thành công");
            } else {
                return new BaseResponse("1", "Cập nhật hạn mức sử dụng thất bại");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseResponse("1", "Cập nhật hạn mức sử dụng thất bại");
        }
    }
}

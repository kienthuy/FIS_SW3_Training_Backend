package com.fis.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.portal.mapper.CurrencyMapper;
import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Currency;
import com.fis.portal.service.ICurrencyService;

@Service
public class CurrencyServiceImpl implements ICurrencyService {

    @Autowired
    private CurrencyMapper currencyMapper;

    @Override
    public BaseResponse search(Currency request) {
        try {
            List<Currency> list = currencyMapper.search(request);
            int totalRecords = currencyMapper.count(request);
            return new BaseListResponse(list, totalRecords);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseResponse("1", "Tìm kiếm loại tiền thất bại");
        }
    }

    @Override
    public BaseResponse create(Currency currency) {
        try {
            // Kiểm tra xem loại tiền đã tồn tại chưa
            Currency existingCurrency = currencyMapper.findByCode(currency.getCode());
            if (existingCurrency != null) {
                return new BaseResponse("2", "Loại tiền đã tồn tại trong hệ thống");
            }

            // Thực hiện tạo mới loại tiền
            int result = currencyMapper.create(currency);
            if (result > 0) {
                return new BaseResponse("0", "Tạo loại tiền thành công");
            } else {
                return new BaseResponse("1", "Tạo loại tiền thất bại");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseResponse("1", "Tạo loại tiền thất bại");
        }
    }

    @Override
    public BaseResponse update(Currency currency) {
        try {
            // Thực hiện cập nhật thông tin loại tiền
            int result = currencyMapper.update(currency);
            if (result > 0) {
                return new BaseResponse("0", "Cập nhật loại tiền thành công");
            } else {
                return new BaseResponse("1", "Cập nhật loại tiền thất bại");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseResponse("1", "Cập nhật loại tiền thất bại");
        }
    }
}

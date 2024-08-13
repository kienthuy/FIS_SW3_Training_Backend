package com.fis.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.portal.mapper.AccountMapper;
import com.fis.portal.model.Account;
import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Product;
import com.fis.portal.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public BaseResponse search(Account request) {
        List<Account> list = accountMapper.search(request);
        int totalRecords = accountMapper.count(request);
        return new BaseListResponse(list, totalRecords);
    }

    @Override
    public BaseResponse create(Account account) {
        try {
            Product existingAccount = accountMapper.findByCode(account.getCode());
            if (existingAccount != null) {
                return new BaseResponse("2", "Dịch vụ đã tồn tại trong hệ thống");
            }

            int result = accountMapper.create(account);
            if (result > 0) {
                return new BaseResponse("0", "Tạo dịch vụ thành công");
            } else {
                return new BaseResponse("1", "Tạo dịch vụ thất bại");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseResponse("1", "Tạo dịch vụ thất bại");
        }
    }

    @Override
    public BaseResponse update(Account account) {
        try {
            int result = accountMapper.update(account);
            if (result > 0) {
                return new BaseResponse("0", "Cập nhật thành công");
            } else {
                return new BaseResponse("1", "Cập nhật thất bại");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseResponse("1", "Cập nhật thất bại");
        }
    }


}

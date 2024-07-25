package com.fis.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.portal.mapper.UserMapper;
import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.User;
import com.fis.portal.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public BaseResponse search(User request) {
		// TODO Auto-generated method stub
		List<User> list = userMapper.search(request);
		int totalRecords = userMapper.count(request);
		return new BaseListResponse(list, totalRecords);
	}

	@Override
	public BaseResponse create(User user) {
		// TODO Auto-generated method stub
		try {
            // Kiểm tra xem người dùng đã tồn tại chưa
            User existingUser = userMapper.findByCode(user.getCode());
            if (existingUser != null) {
                return new BaseResponse("2","Người dùng đã tồn tại trong hệ thống");
            }
            
            // Thực hiện tạo mới người dùng
            int result = userMapper.create(user);
            if(result > 0) {
            	return new BaseResponse("0","Tạo người dùng thành công");
            }else {
            	return new BaseResponse("1","Tạo người dùng thất bại");
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
            return new BaseResponse("1","Tạo người dùng thất bại");
        }
    }

	@Override
    public BaseResponse update(User user) {
        try {
            // Thực hiện cập nhật thông tin người dùng
            int result = userMapper.update(user);
            if (result > 0) {
                return new BaseResponse("0","Cập nhật người dùng thành công");
            } else {
            	return new BaseResponse("1","Cập nhật người dùng thất bại");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseResponse("1","Cập nhật người dùng thất bại");
        }
    }
}

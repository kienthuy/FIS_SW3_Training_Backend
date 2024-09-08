package com.fis.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.portal.mapper.RoleMapper;
import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BasePaging;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Role;
import com.fis.portal.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public BaseListResponse search(Role request) {
        try {
            List<Role> list = roleMapper.search(request);
            int totalRecords = roleMapper.count(request);
            
            BasePaging basePaging = new BasePaging();
	        basePaging.setData(list);
	        basePaging.setTotal(totalRecords);
	        
	        return new BaseListResponse("OK", true , basePaging);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseListResponse("NO OK", false , null);
        }
    }

    @Override
	public BaseResponse create(Role role) {
		// TODO Auto-generated method stub
		try {
            // Kiểm tra xem vai trò đã tồn tại chưa
            Role existingRole = roleMapper.findByCode(role.getCode());
            if (existingRole != null) {
                return new BaseResponse("2","Vai trò đã tồn tại trong hệ thống");
            }
            
            // Thực hiện tạo mới người dùng
            int result = roleMapper.create(role);
            if(result > 0) {
            	return new BaseResponse("0","Tạo vai trò thành công");
            }else {
            	return new BaseResponse("1","Tạo vai trò thất bại");
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
            return new BaseResponse("1","Tạo vai trò thất bại");
        }
    }

	@Override
    public BaseResponse update(Role role) {
        try {
            // Thực hiện cập nhật thông tin người dùng
            int result = roleMapper.update(role);
            if (result > 0) {
                return new BaseResponse("0","Cập nhật vai trò thành công");
            } else {
            	return new BaseResponse("1","Cập nhật vai trò thất bại");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseResponse("1","Cập nhật vai trò thất bại");
        }
    }
}


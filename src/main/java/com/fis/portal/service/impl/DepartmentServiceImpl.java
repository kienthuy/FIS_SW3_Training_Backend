package com.fis.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.portal.mapper.DepartmentMapper;
import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BasePaging;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Department;
import com.fis.portal.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public BaseListResponse search(Department request) {
        List<Department> list = departmentMapper.search(request);
        int totalRecords = departmentMapper.count(request);
        
        BasePaging basePaging = new BasePaging();
        basePaging.setData(list);
        basePaging.setTotal(totalRecords);
        
        return new BaseListResponse("OK", true , basePaging);
    }

    @Override
	public BaseResponse create(Department department) {
		try {
            // Kiểm tra xem người dùng đã tồn tại chưa
            Department existingDepartment = departmentMapper.findByCode(department.getCode());
            if (existingDepartment != null) {
                return new BaseResponse("2","Phòng ban đã tồn tại trong hệ thống");
            }
            
            // Thực hiện tạo mới người dùng
            int result = departmentMapper.create(department);
            if(result > 0) {
            	return new BaseResponse("0","Tạo phòng ban thành công");
            }else {
            	return new BaseResponse("1","Tạo phòng ban thất bại");
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
            return new BaseResponse("1","Tạo phòng ban thất bại");
        }
    }

	@Override
    public BaseResponse update(Department department) {
        try {
            // Thực hiện cập nhật thông tin người dùng
            int result = departmentMapper.update(department);
            if (result > 0) {
                return new BaseResponse("0","Cập nhật phòng ban thành công");
            } else {
            	return new BaseResponse("1","Cập nhật phòng ban thất bại");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseResponse("1","Cập nhật phòng ban thất bại");
        }
    }
}


package com.fis.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.portal.mapper.PositionMapper;
import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BasePaging;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Position;
import com.fis.portal.service.IPositionService;

@Service
public class PositionServiceimpl implements IPositionService{
	 @Autowired
	    private PositionMapper positionMapper;

	    @Override
	    public BaseListResponse search(Position request) {
	        List<Position> list = positionMapper.search(request);
	        int totalRecords = positionMapper.count(request);
	        
	        BasePaging basePaging = new BasePaging();
	        basePaging.setData(list);
	        basePaging.setTotal(totalRecords);
	        
	        return new BaseListResponse("OK", true , basePaging);
	    }

	    @Override
		public BaseResponse create(Position position) {
			// TODO Auto-generated method stub
			try {
	            // Kiểm tra xem người dùng đã tồn tại chưa
	            Position existingPosition = positionMapper.findByCode(position.getCode());
	            if (existingPosition != null) {
	                return new BaseResponse("2","Phòng ban đã tồn tại trong hệ thống");
	            }
	            
	            // Thực hiện tạo mới người dùng
	            int result = positionMapper.create(position);
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
	    public BaseResponse update(Position position) {
	        try {
	            // Thực hiện cập nhật thông tin người dùng
	            int result = positionMapper.update(position);
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



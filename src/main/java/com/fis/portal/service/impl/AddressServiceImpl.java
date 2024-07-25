package com.fis.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.portal.mapper.AddressMapper;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Branch;
import com.fis.portal.model.District;
import com.fis.portal.model.Product;
import com.fis.portal.model.Province;
import com.fis.portal.model.Ward;
import com.fis.portal.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService{
	
	@Autowired
	private AddressMapper mapper;

	@Override
	public BaseResponse getProvince(Province request) {
		try {
			List<Province> list = mapper.getProvince(request);
	        return new BaseResponse(list, "0", "Get province success");
		} catch (Exception e) {
	        return new BaseResponse(null, "1", "Get province failed");
		}
		
	}

	@Override
	public BaseResponse getDistrict(District request) {
		try {
			List<District> list = mapper.getDistrict(request);
	        return new BaseResponse(list, "0", "Get district success");
		} catch (Exception e) {
	        return new BaseResponse(null, "1", "Get district failed");
		}
		
	}

	@Override
	public BaseResponse getWard(Ward request) {
		try {
			List<Ward> list = mapper.getWard(request);
	        return new BaseResponse(list, "0", "Get ward success");
		} catch (Exception e) {
	        return new BaseResponse(null, "1", "Get ward failed");
		}
		
	}
	
	@Override
	public BaseResponse getBranch(Branch request) {
		try {
			List<Branch> list = mapper.getBranch(request);
	        return new BaseResponse(list, "0", "Get branch success");
		} catch (Exception e) {
	        return new BaseResponse(null, "1", "Get branch failed");
		}
		
	}
	
	@Override
	public BaseResponse getProduct(Product request) {
		try {
			List<Product> list = mapper.getProduct(request);
	        return new BaseResponse(list, "0", "Get product success");
		} catch (Exception e) {
	        return new BaseResponse(null, "1", "Get product failed");
		}
		
	}
	
	
	
}

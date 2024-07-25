package com.fis.portal.service;

import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Branch;
import com.fis.portal.model.District;
import com.fis.portal.model.Product;
import com.fis.portal.model.Province;
import com.fis.portal.model.Ward;

public interface IAddressService {
	
	BaseResponse getProvince(Province request);
	BaseResponse getDistrict(District request);
	BaseResponse getWard(Ward request);
	BaseResponse getBranch(Branch request);
	BaseResponse getProduct(Product request);
}

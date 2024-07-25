package com.fis.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fis.portal.model.Branch;
import com.fis.portal.model.District;
import com.fis.portal.model.Product;
import com.fis.portal.model.Province;
import com.fis.portal.model.Ward;

@Mapper
public interface AddressMapper {
	
	List<Province> getProvince(Province payload);
	List<District> getDistrict(District payload);
	List<Ward> getWard(Ward payload);
	List<Branch> getBranch(Branch payload);
	List<Product> getProduct(Product payload);
	
	
}

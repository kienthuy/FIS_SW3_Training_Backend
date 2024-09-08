package com.fis.portal.service;

import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Product;

public interface IProductService {

	BaseListResponse search(Product request);

    BaseResponse create(Product product);

    BaseResponse update(Product product);
    
}

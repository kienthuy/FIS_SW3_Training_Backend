package com.fis.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.portal.mapper.ProductMapper;
import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Product;
import com.fis.portal.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public BaseResponse search(Product request) {
        List<Product> list = productMapper.search(request);
        int totalRecords = productMapper.count(request);
        return new BaseListResponse(list, totalRecords);
    }

    @Override
    public BaseResponse create(Product product) {
        try {
            Product existingProduct = productMapper.findByCode(product.getCode());
            if (existingProduct != null) {
                return new BaseResponse("2", "Dịch vụ đã tồn tại trong hệ thống");
            }

            int result = productMapper.create(product);
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
    public BaseResponse update(Product product) {
        try {
            int result = productMapper.update(product);
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

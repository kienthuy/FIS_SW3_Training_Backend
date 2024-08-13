package com.fis.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.portal.mapper.BranchMapper;
import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Branch;
import com.fis.portal.service.IBranchService;

@Service
public class BranchServiceImpl implements IBranchService {

    @Autowired
    private BranchMapper branchMapper;

    @Override
    public BaseResponse search(Branch request) {
        List<Branch> list = branchMapper.search(request);
        int totalRecords = branchMapper.count(request);
        return new BaseListResponse(list, totalRecords);
    }

    @Override
    public BaseResponse create(Branch branch) {
        try {
            Branch existingBranch = branchMapper.findByCode(branch.getCode());
            if (existingBranch != null) {
                return new BaseResponse("2", "Chi nhánh đã tồn tại trong hệ thống");
            }

            int result = branchMapper.create(branch);
            if (result > 0) {
                return new BaseResponse("0", "Tạo chi nhánh thành công");
            } else {
                return new BaseResponse("1", "Tạo chi nhánh thất bại");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseResponse("1", "Tạo chi nhánh thất bại");
        }
    }

    @Override
    public BaseResponse update(Branch branch) {
        try {
            int result = branchMapper.update(branch);
            if (result > 0) {
                return new BaseResponse("0", "Cập nhật booking thành công");
            } else {
                return new BaseResponse("1", "Cập nhật booking thất bại");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseResponse("1", "Cập nhật booking thất bại");
        }
    }


}

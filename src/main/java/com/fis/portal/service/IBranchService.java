package com.fis.portal.service;

import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Branch;

public interface IBranchService {

	BaseListResponse search(Branch request);

    BaseResponse create(Branch branch);

    BaseResponse update(Branch branch);
    
}

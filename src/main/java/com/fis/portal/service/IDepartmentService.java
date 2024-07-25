package com.fis.portal.service;

import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Department;

public interface IDepartmentService {
    BaseResponse search(Department request);
    BaseResponse create(Department department);
    BaseResponse update(Department department);
	BaseResponse getAllDepartments();
   }

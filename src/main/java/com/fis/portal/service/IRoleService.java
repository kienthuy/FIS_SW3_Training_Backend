package com.fis.portal.service;

import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Role;

public interface IRoleService {
    BaseResponse search(Role request);
    BaseResponse create(Role role);
    BaseResponse update(Role role);
   }

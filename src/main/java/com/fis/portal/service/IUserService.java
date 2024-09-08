package com.fis.portal.service;

import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.User;

public interface IUserService {
	
	BaseListResponse search(User request);

	BaseResponse update(User user);

	BaseResponse create(User user);

	
}

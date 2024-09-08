package com.fis.portal.service;

import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Limit;

public interface ILimitService {
	
	BaseListResponse search(Limit request);

	BaseResponse update(Limit limit);

	BaseResponse create(Limit limit);

	
}

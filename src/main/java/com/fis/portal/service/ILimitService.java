package com.fis.portal.service;

import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Limit;

public interface ILimitService {
	
	BaseResponse search(Limit request);

	BaseResponse update(Limit limit);

	BaseResponse create(Limit limit);

	
}

package com.fis.portal.service;

import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Menu;

public interface IMenuService {
	
	BaseListResponse search(Menu request);

	BaseResponse update(Menu menu);

	BaseResponse create(Menu menu);

	BaseResponse findMenuByRole();
}

package com.fis.portal.service;

import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Currency;

public interface ICurrencyService {
	
	BaseResponse search(Currency request);

	BaseResponse update(Currency currency);

	BaseResponse create(Currency currency);

	
}


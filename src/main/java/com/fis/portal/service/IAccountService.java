package com.fis.portal.service;

import com.fis.portal.model.Account;
import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BaseResponse;

public interface IAccountService {

	BaseListResponse search(Account request);

    BaseResponse create(Account account);

    BaseResponse update(Account account);
    
}

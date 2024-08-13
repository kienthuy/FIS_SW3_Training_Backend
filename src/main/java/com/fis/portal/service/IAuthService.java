package com.fis.portal.service;

import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.User;

public interface IAuthService {
  BaseResponse authentication(User request);

  BaseResponse register(User user);
}

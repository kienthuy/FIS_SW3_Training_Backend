package com.fis.portal.service;

import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BaseResponse;

import com.fis.portal.model.Position;

public interface IPositionService {
	BaseListResponse search(Position request);
    BaseResponse create(Position position);
    BaseResponse update(Position position);
}

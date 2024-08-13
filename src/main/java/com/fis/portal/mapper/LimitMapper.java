package com.fis.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fis.portal.model.Limit;

@Mapper
public interface LimitMapper {
    List<Limit> search(Limit payload);
    int count(Limit payload);
    int update(Limit limit);
    int create(Limit limit);
    Limit findByCode(String code);
}

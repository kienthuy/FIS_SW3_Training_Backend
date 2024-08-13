package com.fis.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fis.portal.model.Currency;

@Mapper
public interface CurrencyMapper {
    List<Currency> search(Currency payload);
    int count(Currency payload);
    int update(Currency currency);
    int create(Currency currency);
    Currency findByCode(String code);
}

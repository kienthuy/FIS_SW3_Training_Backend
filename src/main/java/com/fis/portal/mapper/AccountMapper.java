package com.fis.portal.mapper;

import java.util.List;

import com.fis.portal.model.Account;
import com.fis.portal.model.Product;

public interface AccountMapper {
    List<Account> search(Account payload);
    int count(Account payload);
    int create(Account account);
    int update(Account account);
    Product findByCode(String code);
}
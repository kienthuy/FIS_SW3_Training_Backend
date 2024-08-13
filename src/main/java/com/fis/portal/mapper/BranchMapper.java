package com.fis.portal.mapper;

import java.util.List;

import com.fis.portal.model.Branch;


public interface BranchMapper {
    List<Branch> search(Branch payload);
    int count(Branch payload);
    int create(Branch booking);
    int update(Branch booking);
    Branch findByCode(String code);
}
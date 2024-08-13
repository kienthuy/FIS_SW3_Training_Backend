package com.fis.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fis.portal.model.Role;

@Mapper
public interface RoleMapper {
	List<Role> search(Role payload);
    int count(Role payload);
	int update(Role role);
	int create(Role role);
	Role findByCode(String code);
    
}

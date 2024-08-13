package com.fis.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fis.portal.model.User;

@Mapper
public interface UserMapper {
	List<User> search(User payload);
    int count(User payload);
	int update(User user);
	int create(User user);
	User findByCode(String code);
	int register(User user);
    
}

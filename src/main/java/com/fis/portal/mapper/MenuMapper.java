package com.fis.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fis.portal.model.Menu;

@Mapper
public interface MenuMapper {
	List<Menu> search(Menu payload);
    int count(Menu payload);
	int update(Menu menu);
	int create(Menu menu);
	Menu findByCode(String code);
	List<Menu> findPathByRoleCode(String roleCode);
    
}

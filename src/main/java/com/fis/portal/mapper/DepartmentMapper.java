package com.fis.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fis.portal.model.Department;

@Mapper
public interface DepartmentMapper {
    List<Department> search(Department payload);
    int count(Department payload);
    int update(Department department);
    int create(Department department);
    Department findByCode(String code);
    List<Department> getAllDepartments();

}

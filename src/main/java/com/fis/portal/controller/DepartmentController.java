package com.fis.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Department;
import com.fis.portal.service.IDepartmentService;

@CrossOrigin()
@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
    @Autowired
    IDepartmentService departmentService;
    
    @PostMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseListResponse> search(@RequestBody Department request) {
        return new ResponseEntity<>(departmentService.search(request), HttpStatus.OK);
    }
    
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> create(@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.create(department), HttpStatus.CREATED);
    }
    
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> update(@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.update(department), HttpStatus.OK);
    }

}

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

import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Menu;
import com.fis.portal.model.Role;
import com.fis.portal.service.IMenuService;
import com.fis.portal.service.IRoleService;

@CrossOrigin()
@RestController
@RequestMapping(value = "/role")
public class RoleController {
	@Autowired
    IRoleService roleService;
	
	@PostMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> search(@RequestBody Role request) {
        return new ResponseEntity<>(roleService.search(request), HttpStatus.OK);
    }
	// Thêm phương thức create
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> create(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.create(role), HttpStatus.CREATED);
    }
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> update(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.update(role), HttpStatus.OK);
    }

}

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
import com.fis.portal.model.Menu;
import com.fis.portal.service.IMenuService;

@CrossOrigin()
@RestController
@RequestMapping(value = "/menu")
public class MenuController {
	@Autowired
    IMenuService menuService;
	
	@PostMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseListResponse> search(@RequestBody Menu request) {
        return new ResponseEntity<>(menuService.search(request), HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> create(@RequestBody Menu menu) {
        return new ResponseEntity<>(menuService.create(menu), HttpStatus.CREATED);
    }
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> update(@RequestBody Menu menu) {
        return new ResponseEntity<>(menuService.update(menu), HttpStatus.OK);
    }

}

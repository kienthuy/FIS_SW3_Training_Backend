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
import com.fis.portal.model.Branch;
import com.fis.portal.model.District;
import com.fis.portal.model.Product;
import com.fis.portal.model.Province;
import com.fis.portal.model.Ward;
import com.fis.portal.service.IAddressService;

@CrossOrigin
@RestController
@RequestMapping(value = "/address")
public class AddressController {

	@Autowired
	private IAddressService service;

	@PostMapping(value = "/getProvince", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> search(@RequestBody Province request) {
		return new ResponseEntity<>(service.getProvince(request), HttpStatus.OK);
	}
	
	@PostMapping(value = "/getDistrict", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> search(@RequestBody District request) {
		return new ResponseEntity<>(service.getDistrict(request), HttpStatus.OK);
	}
	
	@PostMapping(value = "/getWard", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> search(@RequestBody Ward request) {
		return new ResponseEntity<>(service.getWard(request), HttpStatus.OK);
	}
	@PostMapping(value = "/getBranch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> search(@RequestBody Branch request) {
		return new ResponseEntity<>(service.getBranch(request), HttpStatus.OK);
	}
	@PostMapping(value = "/getProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> search(@RequestBody Product request) {
		return new ResponseEntity<>(service.getProduct(request), HttpStatus.OK);
	}



}

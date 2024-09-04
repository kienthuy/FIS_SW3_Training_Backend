package com.fis.portal.controller;

import com.fis.portal.model.BaseResponse;
import com.fis.portal.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping(value = "/theme")
public class ThemeController {
    @Autowired
    IMenuService menuService;

    @PostMapping(value = "/getSidebar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getSidebar() {
        return new ResponseEntity<>(menuService.findMenuByRole(), HttpStatus.OK);
    }
}

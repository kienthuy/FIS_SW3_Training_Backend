package com.fis.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fis.portal.mapper.MenuMapper;
import com.fis.portal.model.BaseListResponse;
import com.fis.portal.model.BasePaging;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.Menu;
import com.fis.portal.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public BaseListResponse search(Menu request) {
        List<Menu> list = menuMapper.search(request);
        int totalRecords = menuMapper.count(request);
        
        BasePaging basePaging = new BasePaging();
        basePaging.setData(list);
        basePaging.setTotal(totalRecords);
        
        return new BaseListResponse("OK", true , basePaging);
    }

    @Override
    public BaseResponse create(Menu menu) {
        try {
            Menu existingMenu = menuMapper.findByCode(menu.getCode());
            if (existingMenu != null) {
                return new BaseResponse("2", "Dịch vụ đã tồn tại trong hệ thống");
            }

            int result = menuMapper.create(menu);
            if (result > 0) {
                return new BaseResponse("0", "Tạo dịch vụ thành công");
            } else {
                return new BaseResponse("1", "Tạo dịch vụ thất bại");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseResponse("1", "Tạo dịch vụ thất bại");
        }
    }

    @Override
    public BaseResponse update(Menu menu) {
        try {
            int result = menuMapper.update(menu);
            if (result > 0) {
                return new BaseResponse("0", "Cập nhật thành công");
            } else {
                return new BaseResponse("1", "Cập nhật thất bại");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BaseResponse("1", "Cập nhật thất bại");
        }
    }

    @Override
    public BaseResponse findMenuByRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String roleCode = String.valueOf(authentication.getAuthorities().iterator().next());
        return new BaseResponse(menuMapper.findPathByRoleCode(roleCode)) ;
    }
}

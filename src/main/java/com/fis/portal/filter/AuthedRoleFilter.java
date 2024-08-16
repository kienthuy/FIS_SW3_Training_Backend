package com.fis.portal.filter;

import com.fis.portal.mapper.MenuMapper;
import com.fis.portal.mapper.MenuRoleMapper;
import com.fis.portal.mapping.AuthedMapping;
import com.fis.portal.model.Menu;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Order(2)
public class AuthedRoleFilter extends OncePerRequestFilter {

  @Autowired
  private MenuMapper menuMapper;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
          throws ServletException, IOException {
    var path = request.getRequestURI().split("/api/portal")[1];
    var authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!hasAuthentication(path) && Objects.nonNull(authentication)) {
      var roleCode = String.valueOf(authentication.getAuthorities().iterator().next());
      if (!checkPath(roleCode, path)) {
        response.setStatus(HttpStatus.FORBIDDEN.value());
      }
    }
    filterChain.doFilter(request, response);
  }

  private boolean hasAuthentication(String uri) {
    return Arrays.stream(AuthedMapping.MATCHERS).anyMatch(authed ->
            StringUtils.endsWithIgnoreCase(authed, uri));
  }

  private boolean checkPath(String roleCode, String path) {
    var menus = menuMapper.findPathByRoleCode(roleCode);
    if (Objects.nonNull(menus)) {
      for (var menu : menus) {
        if (StringUtils.endsWithIgnoreCase(menu.getPath(), path)) {
          return true;
        }
      }
    }
    return false;
  }
}

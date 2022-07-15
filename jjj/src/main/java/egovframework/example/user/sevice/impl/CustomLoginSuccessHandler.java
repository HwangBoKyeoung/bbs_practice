package egovframework.example.user.sevice.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth)
			throws IOException, ServletException {
//		로그인 이후 추가적으로 처리할 내용
		System.out.println("=====================로그인 성공==================");
		
		List<String> roleNames = new ArrayList<>();
		
		auth.getAuthorities().forEach(authority->{
			roleNames.add(authority.getAuthority());
		});
		
		if(roleNames.contains("ROLE_USER")) {
			resp.sendRedirect("home.do");
			return;
		}
		if(roleNames.contains("ROLE_ADMIN")) {
			resp.sendRedirect("costSelectList.do");
			return;
		}
		
		resp.sendRedirect("/");
	}

}

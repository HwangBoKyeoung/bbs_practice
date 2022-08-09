package egovframework.example.user.sevice.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req
									  , HttpServletResponse resp
									  , Authentication auth) throws IOException
																  , ServletException {
		
//		로그인 이후 추가적으로 처리할 내용
		System.out.println("=====================로그인 성공==================");
		
		List<String> roleNames = new ArrayList<>();
		
		auth.getAuthorities().forEach(authority->{
			roleNames.add(authority.getAuthority());
		});
		
		HttpSession session = req.getSession();
		
//		원래 사용자가 가고자 했던 정보 참조
		HttpSessionRequestCache cache = new HttpSessionRequestCache();
		SavedRequest saved = cache.getRequest(req, resp);
		
		String redirectUrl;
		if(saved != null) {
			redirectUrl = saved.getRedirectUrl();
			if(roleNames.contains("ROLE_USER")) {
				resp.sendRedirect(redirectUrl);
				session.setAttribute("sessionAuth", "user");
				return;
			}
			if(roleNames.contains("ROLE_ADMIN")) {
				resp.sendRedirect(redirectUrl);
				session.setAttribute("sessionAuth", "admin");
				return;
			}
		} else {
			if(roleNames.contains("ROLE_USER")) {
				resp.sendRedirect("userMyPage.do");
				session.setAttribute("sessionAuth", "user");
				return;
			}
			if(roleNames.contains("ROLE_ADMIN")) {
				resp.sendRedirect("costSelectList.do");
				session.setAttribute("sessionAuth", "admin");
				return;
			}
		}
		
		resp.sendRedirect("/");
	}

}

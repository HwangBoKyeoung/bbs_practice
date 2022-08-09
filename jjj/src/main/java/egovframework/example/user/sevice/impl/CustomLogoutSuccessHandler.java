package egovframework.example.user.sevice.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest req
							  , HttpServletResponse resp
							  , Authentication auth) throws IOException
														  , ServletException {
		
		if(auth != null && auth.getDetails() != null) {
			try {
				req.getSession().invalidate();
				req.getSession(true);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		/*Cookie[] cookies = req.getCookies();	//모든 쿠키의 정보를 cookies에 저장
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				cookies[i].setMaxAge(0);		//유효시간을 0으로 설정
				resp.addCookie(cookies[i]);		//응답에 추가하여 만료시키기
			}
		}*/
		
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.sendRedirect("userLogout.do");
		
	}

}

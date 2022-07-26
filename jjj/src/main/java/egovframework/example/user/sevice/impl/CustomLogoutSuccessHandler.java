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
							  , Authentication auth) throws IOException, ServletException {
		
		if(auth != null && auth.getDetails() != null) {
			try {
				req.getSession().invalidate();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.sendRedirect("userLogout.do");
		
	}

}

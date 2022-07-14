package egovframework.example.cmmn.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value="/")
	public String home(@AuthenticationPrincipal UserDetails user) {
		
		return "home/home";
	}
	
	@RequestMapping("/home.do")
	public String home(Model model) {
		return "home/home";
	}
	
}

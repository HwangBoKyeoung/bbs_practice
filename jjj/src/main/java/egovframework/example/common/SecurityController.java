package egovframework.example.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	
	@RequestMapping("/error_401.do")
	public String error_401() {
		return "security/error_401";
	}
	
}

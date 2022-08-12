package egovframework.example.home.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "home/home";
	}
	
	@RequestMapping("/home.do")
	public String home(Model model) {
		return "home/home";
	}
	
}

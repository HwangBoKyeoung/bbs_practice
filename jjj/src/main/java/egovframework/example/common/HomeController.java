package egovframework.example.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value="/")
	public String home() {
		return "home/home";
	}
	
	@RequestMapping("/home.do")
	public String home(Model model) {
		return "home/home";
	}
	
	@RequestMapping("/companyMap.do")
	public String companyMap() {
		return "company/companyMap";
	}
	
	@RequestMapping("/todoList.do")
	public String todoList() {
		return "cmmn/todoList";
	}
	
}

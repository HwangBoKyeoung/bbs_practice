package egovframework.example.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
//	home으로 이동(서버 실행하자 마자 보이는 페이지)
	@RequestMapping(value="/")
	public String home() {
		return "home/home";
	}
	
//	home으로 이동
	@RequestMapping("/home.do")
	public String home(Model model) {
		return "home/home";
	}
	
//	오시는길 만들 예정 페이지
	@RequestMapping("/companyMap.do")
	public String companyMap() {
		return "company/companyMap";
	}
	
//	나중에 지울 예정 : 해야할 것 작성
	@RequestMapping("/todoList.do")
	public String todoList() {
		return "cmmn/todoList";
	}
	
//	에디터 사용 예시
	@RequestMapping("/blank.do")
	public String blank() {
		return "home/blank";
	}
	
}

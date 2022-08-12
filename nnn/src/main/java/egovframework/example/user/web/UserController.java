package egovframework.example.user.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.user.service.UserService;
import egovframework.example.user.service.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping("/userSelectList.do")
	public String userSelectList(Model model) {
		List<UserVO> users = userService.userSelectList();
		model.addAttribute("users", users);
		
		return "user/userSelectList";
	}
	
	@RequestMapping("/userSelect.do")
	public String userSelect(UserVO vo
						   , Model model) {
		
		vo = userService.userSelect(vo);
		if(vo == null) {
			model.addAttribute("message", "회원 한 건 조회가 실패했습니다.");
			return "user/message";
		}
		
		model.addAttribute("user", vo);
		return "user/userSelect";
	}
	
	
}

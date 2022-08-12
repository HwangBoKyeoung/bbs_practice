package egovframework.example.user.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.user.service.UserService;
import egovframework.example.user.service.UserVO;

@Controller
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping("/userSelectList.do")
	public String userSelectList(Model model) {
		List<UserVO> users = userService.userSelectList();
		model.addAttribute("users", users);
		
		return "user/userSelectList";
	}
	
}

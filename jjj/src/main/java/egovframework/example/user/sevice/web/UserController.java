package egovframework.example.user.sevice.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.user.sevice.UserService;
import egovframework.example.user.sevice.UserVO;

@Controller
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@RequestMapping("/userLoginForm.do")
	public String userLoginForm() {
		return "user/userLoginForm";
	}
	
	@RequestMapping("/userRegisterForm.do")
	public String userRegisterForm() {
		return "user/userRegisterForm";
	}
	
//	아이디중복체크
	@ResponseBody
	@PostMapping("/ajaxIdChk.do")
	public int ajaxIdChk(UserVO vo) {
		int idNo = userService.userIdChk(vo);

		return idNo;
	}
	
	@PostMapping("/userRegister.do")
	public String userRegister(UserVO vo, HttpSession session, Model model) {
		String userPwd = vo.getUserPwd();
		String encPwd = bcryptPasswordEncoder.encode(userPwd);
		vo.setUserPwd(encPwd);
		
		int insert = userService.userInsert(vo);
		if(insert == 0) {
			model.addAttribute("message", "회원가입이 실패했습니다.");
			return "cmmn/error";
		}
		
		model.addAttribute("message", "회원가입이 성공하였습니다.");
		return "cmmn/success";
	}
	
	@PostMapping("/login.do")
	public String login(HttpSession session, UserVO vo, Model model) {
		String userPwd = vo.getUserPwd();
		String encPwd = bcryptPasswordEncoder.encode(userPwd);
		
		UserVO user = userService.userSelectLogin(vo);
		String oriPwd = user.getUserPwd();
		
		session.getAttribute("sessionId");
		
		System.out.println("========================================"+userPwd);
		System.out.println("========================================"+oriPwd);
		System.out.println("========================================"+encPwd);
		
		boolean pwdChk = bcryptPasswordEncoder.matches(oriPwd, encPwd);
		System.out.println("========================================"+pwdChk);
		
		if(user == null || !pwdChk) {
			model.addAttribute("message", "로그인이 실패했습니다.");
			return "cmmn/error";
		}
		session.setAttribute("sessionId", vo.getUserId());
		session.setAttribute("sessionAuth", vo.getUserRole());
		session.setAttribute("sessionName", vo.getUserName());
		
		model.addAttribute("message", "로그인이 성공하였습니다.");
		return "cmmn/success";
	}
	
	@RequestMapping("/userLogout.do")
	public String userLogout(Model model, HttpSession session) {
		session.invalidate();
		model.addAttribute("message", "로그아웃이 완료되었습니다.");
		return "cmmn/success";
	}
	
}

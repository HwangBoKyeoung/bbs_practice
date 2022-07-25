package egovframework.example.user.sevice.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.user.sevice.UserService;
import egovframework.example.user.sevice.UserVO;

@Controller
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping("/userLoginForm.do")
	public String userLoginForm() {
		return "user/userLoginForm";
	}
	
	@RequestMapping("/userRegisterForm.do")
	public String userRegisterForm() {
		return "user/userRegisterForm";
	}
	
	@PostMapping("/userRegister.do")
	public String userRegister(UserVO vo
							 , Model model
							 , @RequestParam("email1") String email1
							 , @RequestParam("email2") String email2
							 , @RequestParam("ihIdNum2") String ihIdNum2
							 , @RequestParam("ihIdNum3") String ihIdNum3
							 , HttpServletRequest req) {
		
//		이메일
		String userMail = email1 + "@" + email2;		
//		주민번호
		String ihidnum = ihIdNum2 + "-" + ihIdNum3;
		System.out.println("주민등록번호: " + ihidnum);
//		비밀번호
		String userPwd = vo.getUserPwd();
		
//		유효성검사
		boolean mail = vo.isEmail(userMail);
		boolean ihid = vo.isPersonalId(ihidnum);
		boolean pass = vo.isPwdChk(userPwd, vo.getUserId());
		boolean tels = vo.isTel(vo.getUserTel());
		boolean usid = vo.isAlphaNumber(vo.getUserId());
		
		if(!usid) {
			model.addAttribute("message", "아이디가 올바르지 않은 형태입니다.");

			return "user/message";
		}
		
		if(!(mail && ihid && pass && tels)) {
			if(!mail) {
				if(!(ihid || pass)) {
					model.addAttribute("message", "메일, 주민번호, 비밀번호 모두 올바르지 않은 형태입니다.");
				} else if(!(ihid || tels)) {
					model.addAttribute("message", "메일, 주민번호, 전화번호 모두 올바르지 않은 형태입니다.");
				} else if(!(pass || tels)) {
					model.addAttribute("message", "메일, 전화번호, 비밀번호 모두 올바르지 않은 형태입니다.");
				} else if(!pass) {
					model.addAttribute("message", "메일, 비밀번호 모두 올바르지 않은 형태입니다.");
				} else if(!ihid) {
					model.addAttribute("message", "메일, 주민번호 모두 올바르지 않은 형태입니다.");
				} else if(!tels) {
					model.addAttribute("message", "메일, 전화번호 모두 올바르지 않은 형태입니다.");
				} else {
					model.addAttribute("message", "메일이 올바르지 않은 형태입니다.");
				}
			} else if(!ihid) {
				if(!(pass || tels)) {
					model.addAttribute("message", "주민번호, 비밀번호, 전화번호 모두 올바르지 않은 형태입니다.");
				} else if(!pass) {
					model.addAttribute("message", "주민번호, 비밀번호 모두 올바르지 않은 형태입니다.");
				} else if(!tels) {
					model.addAttribute("message", "주민번호, 전화번호 모두 올바르지 않은 형태입니다.");
				} else {
					model.addAttribute("message", "주민번호가 올바르지 않은 형태입니다.");
				}
			} else if(!pass) {
				if(!tels) {
					model.addAttribute("message", "비밀번호와 전화번호 모두 올바르지 않은 형태입니다.");
				} else {
					model.addAttribute("message", "비밀번호가 올바르지 않은 형태입니다.");
				}
			} else {
				model.addAttribute("message", "메일, 주민번호, 비밀번호, 전화번호 모두 올바르지 않은 형태입니다.");
			}

			return "user/message";
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
		String result = encoder.encode(userPwd);
		vo.setUserPwd(result);
		
		int insert = userService.userInsert(vo);
		if(insert == 0) {
			model.addAttribute("message", "회원가입이 실패했습니다.");
			return "cmmn/error";
		}
		
		model.addAttribute("message", "회원가입이 성공하였습니다.");
		return "cmmn/success";
	}
	
	@RequestMapping("/findUserPasswordForm.do")
	public String findUserPasswordForm() {
		return "user/findUserPasswordForm";
	}
	
}

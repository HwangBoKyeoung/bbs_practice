package egovframework.example.user.web;

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
	
	@RequestMapping("/userLogout.do")
	public String userLogout(Model model) {
		model.addAttribute("message", "로그아웃이 완료되었습니다.");
		return "user/userLogout";
	}
	
	@RequestMapping("/userPasswordUpdateForm.do")
	public String userPasswordUpdateForm(Model model
									   , UserVO vo
									   , @RequestParam("mail") String mail) {
		
		vo.setUserMail(mail);
		model.addAttribute("tempPwd", vo.getUserRePwd());
		model.addAttribute("mail", vo.getUserMail());
		return "user/userPasswordUpdateForm";
	}
	
	@PostMapping("/userPasswordUpdate.do")
	public String userPasswordUpdate(UserVO vo
								   , @RequestParam("tempPwd") String tempPwd
								   , @RequestParam("updatePwd") String updatePwd
								   , Model model) {
		
		// 이메일을 통해 아이디 찾아오기
		String findIdResult = userService.findUserIdByMail(vo.getUserMail());
		
		if(findIdResult == null) {
			model.addAttribute("message", "임시비밀번호가 잘못되었습니다.");
			return "user/message";
		}
		
		// 비밀번호를 통해 찾은 아이디를 vo에 넣기
		vo.setUserId(findIdResult);
		// 새로운 비밀번호와 내 아이디 정보를 이용해 유효성 검사 진행
		boolean p1 = vo.isPwdChk(updatePwd, vo.getUserId());
		if(!p1) {
			model.addAttribute("message", "비밀번호의 형식이 올바르지 않습니다. 비밀번호는 '숫자', '문자', '특수문자' 무조건 1개 이상, 비밀번호 '최소 8자에서 최대 16자'까지 허용");
			return "user/message";
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
		String userPwd = encoder.encode(updatePwd);
		vo.setUserPwd(userPwd);
		int r = userService.findUserPassword(vo);
		
		if(r == 0) {
			model.addAttribute("message", "비밀번호 업데이트 실패했습니다.");
			return "cmmn/error";
		}
		
		return "redirect:/userLoginForm.do";
	}
	
}

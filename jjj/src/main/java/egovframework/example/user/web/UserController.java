package egovframework.example.user.web;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.cost.sevice.CostService;
import egovframework.example.cost.sevice.CostVO;
import egovframework.example.cost.sevice.CriteriaVO;
import egovframework.example.cost.sevice.PageVO;
import egovframework.example.user.sevice.UserService;
import egovframework.example.user.sevice.UserVO;

@Controller
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="costService")
	private CostService costService;
	
//	회원로그인 양식으로 이동 (로그인 처리: CustomUserDetailsService.java에서 확인 가능)
	@RequestMapping("/userLoginForm.do")
	public String userLoginForm() {
		return "user/userLoginForm";
	}
	
//	회원 회원가입 양식으로 이동
	@RequestMapping("/userRegisterForm.do")
	public String userRegisterForm() {
		return "user/userRegisterForm";
	}
	
//	회원가입 진행 중... 정규식 검사 (이메일, 주민번호, 전화번호)
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
		
//		정규식검사
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
		
		vo.setIhidnum(ihidnum);
		vo.setIhIdNum2(ihIdNum2);
		vo.setIhIdNum3(ihIdNum3);
		vo.setUserMail(userMail);
		
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
	
//	회원 비밀번호 찾기 양식
	@RequestMapping("/findUserPasswordForm.do")
	public String findUserPasswordForm() {
		return "user/findUserPasswordForm";
	}
	
//	회원 로그아웃 (로그아웃 성공 시, CustomLogoutSuccessHandler.java 파일 참고)
	@RequestMapping("/userLogout.do")
	public String userLogout(Model model) {
		model.addAttribute("message", "로그아웃이 완료되었습니다.");
		return "user/userLogout";
	}
	
//	회원 임시비밀번호-> 새로운 비밀번호로 수정하기 페이지
	@RequestMapping("/userPasswordUpdateForm.do")
	public String userPasswordUpdateForm(Model model
									   , UserVO vo
									   , @RequestParam("mail") String mail) {
		
		vo.setUserMail(mail);
		model.addAttribute("tempPwd", vo.getUserRePwd());
		model.addAttribute("mail", vo.getUserMail());
		
		return "user/userPasswordUpdateForm";
	}
	
//	수정된 비밀번호에 대한 정규식 검사 및 update 시켜주기
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
	
//	회원 마이페이지 이동
	@RequestMapping("/userMyPage.do")
	public String userMyPage(Model model
						   , CostVO cvo
						   , Principal principal
						   , CriteriaVO cri
						   , Map<String, Object> myPageMap) {
		
		cvo.setUserId(principal.getName());
		myPageMap.put("pageNum", cri.getPageNum());
		myPageMap.put("amount", cri.getAmount());
		myPageMap.put("userId", cvo.getUserId());
		
		PageVO pageVO = new PageVO(cri, costService.getTotalByUser(myPageMap));
		List<CostVO> costs = costService.getListByUser(myPageMap);
		
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("costList", costs);
		
		return "user/userMyPage";
	}
	
//	회원 수정 양식으로 이동
	@PostMapping("/userUpdateForm.do")
	public String userUpdateForm(Model model
							   , UserVO vo) {
		
		vo = userService.userSelectLogin(vo);
		
		if(vo==null) {
			model.addAttribute("message", "회원수정이 불가능합니다.");
			return "cmmn/error";
		}
		model.addAttribute("user", vo);
		return "user/userUpdateForm";
	}
	
	@PostMapping("/userUpdate.do")
	public String userUpdate(UserVO vo
						   , Model model
						   , HttpServletRequest req
						   , @RequestParam("userPwd1") String userPwd1
						   , @RequestParam("userPwd2") String userPwd2) {
		
		vo.setUserPwd(userPwd1);
		String emptyPwd = vo.getUserPwd();
		
//		정규식검사
		boolean mail = vo.isEmail(vo.getUserMail());
		boolean tels = vo.isTel(vo.getUserTel());
		boolean pass = false;
		if(emptyPwd.isEmpty() || emptyPwd.equals(null) || emptyPwd == "") {
			vo.setUserPwd(null);
			pass = true;
		} else {
			pass = vo.isPwdChk(vo.getUserPwd(), vo.getUserId());
		}
		
		if(!(mail && pass && tels)) {
			if(!(mail || pass)) {
				model.addAttribute("message", "메일과 비밀번호가 유효하지 않습니다.");
			} else if(!(pass || tels)) {
				model.addAttribute("message", "비밀번호와 전화번호가 유효하지 않습니다.");
			} else if(!(mail || tels)) {
				model.addAttribute("message", "메일과 전화번호가 유효하지 않습니다.");
			} else if(!mail) {
				model.addAttribute("message", "메일이 유효하지 않습니다.");
			} else if(!pass) {
				model.addAttribute("message", "비밀번호가 유효하지 않습니다.");
			} else if(!tels) {
				model.addAttribute("message", "전화번호가 유효하지 않습니다.");
			} else {
				model.addAttribute("message", "메일, 비밀번호, 전화번호 모두 유효하지 않습니다.");
			}
			
			return "user/message";
		}
		
		if(vo.getUserPwd() != null) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
			String pwd = encoder.encode(vo.getUserPwd());
			vo.setUserPwd(pwd);
			
			int update = userService.userUpdate(vo);
			
			if(update == 0) {
				model.addAttribute("message", "회원정보 수정에 실패하였습니다.");
				return "user/message";
			}
			
			model.addAttribute("message", "회원정보를 수정하였습니다. 다시 로그인하세요.");
			return "redirect:logout";
		} else {
			int update = userService.userUpdate(vo);
			
			if(update == 0) {
				model.addAttribute("message", "회원정보 수정에 실패하였습니다.");
				return "user/message";
			}
			
			model.addAttribute("message", "회원정보를 수정하였습니다.");
			return "cmmn/success";
		}
		
		
	}
	
	@RequestMapping("/userDeleteForm.do")
	public String userDeleteForm(Model model
							   , UserVO vo) {
		
		vo = userService.userSelectLogin(vo);
		if(vo == null) {
			model.addAttribute("message", "회원정보가 없습니다.");
			return "cmmn/error";
		}
		
		model.addAttribute("user", vo);
		return "user/userDeleteForm";
	}
	
	@RequestMapping("/userDelete.do")
	public String userDelete(UserVO vo
					 	   , Model model) {
		
		System.out.println("==================================="+vo);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
		String pwd = encoder.encode(vo.getUserPwd());
		vo.setUserPwd(pwd);
		
		int delete = userService.userDelete(vo);
		if(delete == 0) {
			model.addAttribute("message", "회원탈퇴가 실패했습니다.");
			return "cmmn/error";
		}
		
		model.addAttribute("message", "회원탈퇴 되었습니다.");
		return "redirect:logout";
	}
	
}

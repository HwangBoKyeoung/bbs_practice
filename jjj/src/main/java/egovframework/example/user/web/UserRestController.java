package egovframework.example.user.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import egovframework.example.user.sevice.UserService;
import egovframework.example.user.sevice.UserVO;

@RestController
public class UserRestController {
	
	@Resource(name="userService")
	private UserService userService;
	
//	아이디중복체크
	@PostMapping("/ajaxIdChk.do")
	public int ajaxIdChk(UserVO vo) {
		int idNo = userService.userIdChk(vo);
		boolean usid = vo.isId(vo.getUserId());
		
		if(!usid) {
			return -1;
		} else {
			return idNo;
		}
	}
	
//	비밀번호찾기 + 임시비밀번호 메일 보내기
	@PostMapping("/findUserPassword.do")
	public void findUserPassword(UserVO vo, Model model, HttpServletResponse resp) throws Exception {
		userService.findPwd(resp, vo);
	}
	
//	임시비밀번호 값이 관리자가 보낸 메일의 임시비밀번호와 동일한지 체크.
	@PostMapping("/ajaxUpdatePwdCompare.do")
	public String ajaxUpdatePwdCompare(@RequestParam("tempPwd") String tempPwd
									 , @RequestParam("compareVal") String compareVal) {
		System.out.println("전송한 임시비밀번호: " + compareVal + ", 유저가 작성한 임시비밀번호: " + tempPwd);
		if(!tempPwd.equals(compareVal)) {
			return "fail";
		}
		return "success";
	}
	
}

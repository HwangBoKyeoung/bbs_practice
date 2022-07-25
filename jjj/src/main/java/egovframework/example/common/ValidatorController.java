package egovframework.example.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.user.sevice.UserVO;

@Controller
public class ValidatorController {
	
	@RequestMapping("/exRegisterForm.do")
	public String exRegisterForm(Model model
							   , UserVO userVO) {
		model.addAttribute("userVO", userVO);
		return "validatorEx/exRegisterForm";
	}
	
	@PostMapping("/regEmailTest.do")
	public String regEmailTest(@RequestParam("email") String email
							 , @RequestParam("email2") String email2
							 , UserVO vo
							 , HttpServletRequest req) {
		
		System.out.println("===================================email: " + email + "@" + email2);
		String mailAddr = email + "@" + email2;
		boolean chk = vo.isEmail(mailAddr);
		if(!chk) {
			System.out.println("이전 페이지로 가는 것 맞는가????====================="+req.getHeader("Referer"));
			return "redirect:"+req.getHeader("Referer");
		}
		vo.setUserMail(mailAddr);
		System.out.println(vo.getUserMail());
		
		return null;
	}
	
	/*@PostMapping("/regIhIdNumTest.do")
	public String regIhIdNumTest(@ModelAttribute("userVO") UserVO userVO
							   , BindingResult bindingResult
							   , Model model
							   , HttpServletRequest req) {
		System.out.println("------------------------userVO" + userVO);
		beanValidator.validate(userVO, bindingResult);
		if(bindingResult.hasErrors()) {
			System.out.println("주민등록번호 유효성 검사 실패!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			return "redirect:" + req.getHeader("Referer");
		}
		System.out.println("주민등록번호 유효성 검사 성공!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		return null;
	}*/
	
}

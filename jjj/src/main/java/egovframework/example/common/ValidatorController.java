package egovframework.example.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.user.sevice.UserVO;

@Controller
public class ValidatorController {

	@Autowired
	private DefaultBeanValidator beanValidator;
	
	@RequestMapping("/exRegisterForm.do")
	public String exRegisterForm(Model model) {
		return "validatorEx/exRegisterForm";
	}
	
	@RequestMapping("/exRegister.do")
	public@ResponseBody String exRegister(@ModelAttribute("userVO") UserVO userVO
							, BindingResult bindingResult
							, Model model) throws Exception {
		
		beanValidator.validate(userVO, bindingResult);
		if(bindingResult.hasErrors()) {
			return "";
		}
		return null;
	}
	
}

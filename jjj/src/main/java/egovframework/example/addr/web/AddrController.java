package egovframework.example.addr.web;

import java.security.Principal;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.addr.sevice.AddrService;
import egovframework.example.addr.sevice.AddrVO;

@Controller
public class AddrController {
	
	@Resource(name="addrService")
	public AddrService addrService;
	
//	회원 주소지 등록 페이지 이동
	@RequestMapping("/userAddressInsertForm.do")
	public String userAddressInsertForm(Principal principal
									  , AddrVO avo
									  , Model model) {
		
		avo.setUserId(principal.getName());
		avo = addrService.selectAddrInfo(avo);
		if(avo != null) {
			model.addAttribute("message", "이미 주소지를 등록한 상태입니다.");
			return "user/addrSuccess";
		}
		
		return "user/userAddressInsertForm";
	}
	
	@PostMapping("/userAddrInsert.do")
	public String userAddrInsert(AddrVO vo
							   , Model model
							   , @RequestParam("addr1") String addr1
							   , @RequestParam("addr2") String addr2
							   , Principal principal) {
		
		if(principal == null || principal.equals(null)) {
			model.addAttribute("message", "로그아웃이 되었습니다.");
			return "user/error";
		}
		
		String newAddr = addr1 + ", " + addr2;
		vo.setNewAddr(newAddr);
		vo.setUserId(principal.getName());
		int insert = addrService.insertAddrInfo(vo);
		
		if(insert == 0) {
			model.addAttribute("message", "주소지 입력이 실패했습니다.");
			return "user/message";
		}
		
		model.addAttribute("message", "주소지 입력이 완료되었습니다.");
		return "user/addrSuccess";
	}
	
}

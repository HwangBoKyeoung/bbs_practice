package egovframework.example.free.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.free.sevice.FreeBulletinService;

@Controller
public class FreeBulletinController {
	
	@Resource(name="freeService")
	private FreeBulletinService freeService;
	
	@RequestMapping("/freeBulletinList.do")
	public String freeBulletinList() {
		return "free/freeBulletinList";
	}
	
	
}

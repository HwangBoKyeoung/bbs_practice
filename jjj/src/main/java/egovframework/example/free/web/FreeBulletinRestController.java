package egovframework.example.free.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.example.free.sevice.FreeBulletinReplyVO;
import egovframework.example.free.sevice.FreeBulletinService;

@RestController
public class FreeBulletinRestController {
	
	@Resource(name="freeService")
	private FreeBulletinService freeService;
	
	@RequestMapping("/ajaxInsertBulletinReply.do")
	public String ajaxInsertBulletinReply(FreeBulletinReplyVO rvo) {
		System.out.println("==========================="+rvo);
		int insertReply = freeService.insertFreeBulletinReply(rvo);
		
		if(insertReply == 0) {
			return "fail";
		}
		
		return "success";
	}
	
	@RequestMapping("/ajaxDeleteBulletinReply.do")
	public String ajaxDeleteBulletinReply(FreeBulletinReplyVO rvo) {
		int delete = freeService.deleteFreeBulletinReply(rvo);
		if(delete == 0) {
			return "fail";
		}
		return "success";
	}
	
	@RequestMapping("/ajaxUpdateDeleteBulletinReply.do")
	public String ajaxUpdateDeleteBulletinReply(FreeBulletinReplyVO rvo) {
		int updelete = freeService.updateDeleteFreeBulletinReply(rvo);
		if(updelete == 0) {
			return "fail";
		}
		return "success";
	}
	
}

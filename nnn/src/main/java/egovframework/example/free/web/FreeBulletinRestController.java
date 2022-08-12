package egovframework.example.free.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import egovframework.example.free.service.FreeBulletinReplyVO;
import egovframework.example.free.service.FreeBulletinService;
import egovframework.example.free.service.FreeBulletinVO;

@RestController
public class FreeBulletinRestController {
	
	@Resource(name="freeService")
	private FreeBulletinService freeService;
	
	@RequestMapping("/ajaxInsertBulletinReply.do")
	public String ajaxInsertBulletinReply(FreeBulletinReplyVO rvo
										, FreeBulletinVO vo) {
		
		System.out.println("==========================="+rvo);
		int insertReply = freeService.insertFreeBulletinReply(rvo);
		
		if(insertReply == 0) {
			return "fail";
		}
		
		vo.setFreeNo(rvo.getFreeNo());
		freeService.updateFreeBulletinHitDown(vo);
		
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
	public String ajaxUpdateDeleteBulletinReply(FreeBulletinReplyVO rvo
											  , FreeBulletinVO vo
											  , @RequestParam("freeNo") int freeNo) {
		
		int updelete = freeService.updateDeleteFreeBulletinReply(rvo);
		if(updelete == 0) {
			return "fail";
		}
		
		vo.setFreeNo(freeNo);
		freeService.updateFreeBulletinHitDown(vo);
		
		return "success";
	}
	
	@RequestMapping(value="/ajaxInsertBulletinReplyReply.do")
	public String ajaxInsertBulletinReplyReply(FreeBulletinReplyVO rvo
			  								 , FreeBulletinVO vo) {
		
		int insertResult = freeService.insertFreeBulletinReply(rvo);
		if(insertResult == 0) {
			return "fail";
		}
		
		vo.setFreeNo(rvo.getFreeNo());
		freeService.updateFreeBulletinHitDown(vo);
		
		return "success";
	}
	
}

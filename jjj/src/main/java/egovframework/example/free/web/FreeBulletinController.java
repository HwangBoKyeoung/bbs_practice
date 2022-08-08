package egovframework.example.free.web;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.cost.sevice.CriteriaVO;
import egovframework.example.cost.sevice.PageVO;
import egovframework.example.free.sevice.FreeBulletinReplyVO;
import egovframework.example.free.sevice.FreeBulletinService;
import egovframework.example.free.sevice.FreeBulletinVO;
import egovframework.example.user.sevice.UserVO;

@Controller
public class FreeBulletinController {
	
	@Resource(name="freeService")
	private FreeBulletinService freeService;
	
	@RequestMapping("/freeBulletinList.do")
	public String freeBulletinList(Model model
								 , CriteriaVO cri) {
		
//		List<FreeBulletinVO> list = freeService.selectListFreeBulletin();
		PageVO pageVO = new PageVO(cri, freeService.getTotal(cri));
		List<FreeBulletinVO> list = freeService.getList(cri);
		
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("frees", list);
		
		return "free/freeBulletinList";
	}
	
	@PostMapping("/freeSelect.do")
	public String freeSelect(FreeBulletinVO vo
						   , Model model
						   , FreeBulletinReplyVO rvo
						   , Principal p
						   , UserVO uvo) {
		
//		회원정보 가져가기
		String id = null;
		if(p != null) {
			id = p.getName();
		}
		
//		게시글 1건 조회
		vo = freeService.selectFreeBulletin(vo);
		
//		게시글에 대한 댓글 전체 조회
		rvo.setFreeNo(vo.getFreeNo());
		List<FreeBulletinReplyVO> list = freeService.selectListFreeBulletinReply(rvo);
		
		System.out.println("========================================="+list);
		
//		조회수 증가
		freeService.updateFreeBulletinHitUp(vo);
		
		model.addAttribute("free", vo);
		model.addAttribute("replys", list);
		
		model.addAttribute("userId", id);
		
		return "free/freeSelect";
	}
	
	@PostMapping("/freeUpdateForm.do")
	public String freeUpdateForm(FreeBulletinVO vo
				  			   , Model model) {
		
		model.addAttribute("free", vo);
		return "free/freeUpdateForm";
	}
	
	@PostMapping("/freeUpdate.do")
	public String freeUpdate(FreeBulletinVO vo
						   , Model model) {
		
		int update = freeService.updateFreeBulletin(vo);
		if(update == 0) {
			model.addAttribute("message", "게시글 수정이 실패하였습니다.");
			return "free/message";
		}
		
		return "redirect:/freeBulletinList.do";
	}
	
	@RequestMapping("/freeInsertForm.do")
	public String freeInsertForm(Principal p
							   , Model model) {
		
		System.out.println("=================================="+p);
		String id = null;
		
		if(p != null) {
			id = p.getName();
		}
		
		model.addAttribute("userId", id);
		
		return "free/freeInsertForm";
	}
	
	@PostMapping("/freeInsert.do")
	public String freeInsert(FreeBulletinVO vo
						   , Model model) {
		
		int insert = freeService.insertFreeBulletin(vo);
		
		if(insert == 0) {
			model.addAttribute("message", "게시글 등록이 실패했습니다.");
			return "free/message";
		}
		
		return "redirect:/freeBulletinList.do";
	}
	
	@PostMapping("/insertReReply.do")
	public String insertReReply(FreeBulletinReplyVO rvo
							  , Model model) {
		
		System.out.println("--------------------------------------------"+rvo);
		int insertResult = freeService.insertFreeBulletinReply(rvo);
		if(insertResult == 0) {
			model.addAttribute("message", "대댓글 입력이 실패했습니다.");
			return "free/message";
		}
		
		return "redirect:freeBulletinList.do";
	}
	
	@PostMapping("/updateReReply.do")
	public String updateReReply(FreeBulletinReplyVO rvo
							  , Model model) {
		
		int update = freeService.updateFreeBulletinReply(rvo);
		if(update == 0 ) {
			model.addAttribute("message", "댓글 수정이 실패했습니다.");
			return "free/message";
		}
		
		return "redirect:freeBulletinList.do";
	}
	
}

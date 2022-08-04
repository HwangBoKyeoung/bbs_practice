package egovframework.example.free.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.cost.sevice.CriteriaVO;
import egovframework.example.cost.sevice.PageVO;
import egovframework.example.free.sevice.FreeBulletinService;
import egovframework.example.free.sevice.FreeBulletinVO;

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
						   , Model model) {
		
		vo = freeService.selectFreeBulletin(vo);
		
		if(vo == null) {
			model.addAttribute("message", "게시글 1건 조회가 실패했습니다.");
			return "free/message";
		} 
		
		freeService.updateFreeBulletinHitUp(vo);
		model.addAttribute("free", vo);
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
	
	
}

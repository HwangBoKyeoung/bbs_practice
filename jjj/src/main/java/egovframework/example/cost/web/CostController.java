package egovframework.example.cost.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import egovframework.example.cost.sevice.CostReplyService;
import egovframework.example.cost.sevice.CostReplyVO;
import egovframework.example.cost.sevice.CostService;
import egovframework.example.cost.sevice.CostVO;
import egovframework.example.cost.sevice.CriteriaVO;
import egovframework.example.cost.sevice.PageVO;
import egovframework.example.user.sevice.UserService;
import egovframework.example.user.sevice.UserVO;

@Controller
public class CostController {

	@Resource(name = "costService")
	private CostService costService;

	@Resource(name = "costReplyService")
	private CostReplyService costReplyService;
	
	@Resource(name = "userService")
	private UserService userService;

	@Autowired
	private String uploadPath;

	@RequestMapping("/costSelectList.do")
	public String costSelectList(Model model, CriteriaVO cri) {
		PageVO pageVO = new PageVO(cri, costService.getTotal(cri));
		List<CostVO> costs = costService.getList(cri);

		model.addAttribute("pageVO", pageVO);
		model.addAttribute("costs", costs);

		return "cost/costSelectList";
	}

	@PostMapping("/costSelect.do")
	public String costSelect(CostVO vo, Model model, CostReplyVO rvo, Principal principal, UserVO uvo,
							@RequestParam("pageNum") int pageNum, @RequestParam("amount") int amount, 
							@RequestParam("searchType") String searchType, @RequestParam("searchName") String searchName) {
		String userId = principal.getName();
		uvo.setUserId(userId);
		uvo = userService.userSelectLogin(uvo);
		
		vo = costService.costSelect(vo);
		
		System.out.println("-=========================="+vo);
		System.out.println("==============이름비교: "+uvo.getUserName() + "+++" + vo.getCostBuyer());
		
		if(!uvo.getUserName().equals(vo.getCostBuyer())) {
			model.addAttribute("message", "게시글 작성자가 아니어서 열람이 불가합니다.");
			return "cost/error";
		}
		
		rvo.setCostNo(vo.getCostNo());
		List<CostReplyVO> replys = costReplyService.selectCostReply(rvo);
		
//		if (vo != null) {
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("amount", amount);
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchName", searchName);
		
		model.addAttribute("replys", replys);
		model.addAttribute("uploadPath", uploadPath);
		model.addAttribute("cost", vo);
		model.addAttribute("user", uvo);
//		}
		
		return "cost/costSelect";
//		model.addAttribute("message", "경비 한 건 조회에 실패했습니다.");
//		return "cmmn/error";

	}

	@PostMapping("/costUpdateForm.do")
	public String costUpdateForm(Model model, CostVO vo) {
		Date costDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strNowDate = sdf.format(costDate);

		System.out.println("날짜타입===============================" + strNowDate);
		vo = costService.costSelect(vo);
		if (vo == null) {
			model.addAttribute("message", "경비 수정 양식에 도달하지 못했습니다.");
			return "cmmn/error";
		}
		model.addAttribute("cost", vo);
		return "cost/costUpdateForm";
	}

	@PostMapping("/costUpdate.do")
	public String costUpdate(CostVO vo, Model model, MultipartFile file) {
		if(!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			System.out.println("=================u원래 파일 이름: " + fileName);
	
			String uuId = UUID.randomUUID().toString();
			String fileRename = uuId + fileName.substring(fileName.lastIndexOf("."));
			System.out.println("=================u변경 파일 이름: " + fileRename);
	
			File target = new File(uploadPath, fileRename);
			try {
				// 파일 전송
				FileCopyUtils.copy(file.getBytes(), target);
				fileRename = File.separator + fileRename;
				vo.setFileName(fileName);
				vo.setFileRename(fileRename);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		int update = costService.costUpdate(vo);
		if (update == 0) {
			model.addAttribute("message", "경비 수정이 실패했습니다.");
			return "cmmn/error";
		}

		return "redirect:/costSelectList.do";
	}

	@RequestMapping("/costInsertForm.do")
	public String costInsertForm(Principal principal, UserVO vo, Model model) {
		String userId = principal.getName();
		vo.setUserId(userId);
		vo = userService.userSelectLogin(vo);
		
		model.addAttribute("userName", vo.getUserName());
		return "cost/costInsertForm";
	}

	@PostMapping("/costInsert.do")
	public String costInsert(CostVO vo, Model model, MultipartFile files) {
//		MultipartFile 의 메소드 
//		String getName() : 파라미터 이름 리턴
//		String getOriginalFilename() : 업로드한 파일의 이름을 리턴
//		boolean isEmpty() : 업로드한 파일이 존재하지 않으면 true 리턴
//		long getSize() : 업로드한 파일의 크기를 리턴
		
		if(!files.isEmpty()) {
			String fileName = files.getOriginalFilename();

			String uuId = UUID.randomUUID().toString();
			String fileRename = uuId + fileName.substring(fileName.lastIndexOf("."));

			File target = new File(uploadPath, fileRename);
			try {
				// 파일 전송
				FileCopyUtils.copy(files.getBytes(), target);
				fileRename = File.separator + fileRename;
				vo.setFileName(fileName);
				vo.setFileRename(fileRename);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		int insert = costService.costInsert(vo);
		if (insert == 0) {
			model.addAttribute("message", "경비 한 건 등록이 실패했습니다.");
			return "cmmn/error";
		}

		return "redirect:/costSelectList.do";
	}

	@PostMapping("/costDelete.do")
	public String costDelete(CostVO vo, Model model) {
		int delete = costService.costDelete(vo);
		if (delete == 0) {
			model.addAttribute("message", "경비 한 건 삭제가 실패했습니다.");
			return "cmmn/error";
		}

		return "redirect:/costSelectList.do";
	}

	@RequestMapping("/costCalendar.do")
	public String costCalendar() {
		return "cost/costCalendar";
	}

}

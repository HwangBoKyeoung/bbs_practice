package egovframework.example.movie.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import egovframework.example.cost.sevice.CriteriaVO;
import egovframework.example.cost.sevice.PageVO;
import egovframework.example.movie.sevice.MovieCodeVO;
import egovframework.example.movie.sevice.MovieReplyVO;
import egovframework.example.movie.sevice.MovieService;
import egovframework.example.movie.sevice.MovieVO;
import egovframework.example.user.sevice.UserService;
import egovframework.example.user.sevice.UserVO;

@Controller
public class MovieController {
	
	@Resource(name="movieService")
	private MovieService movieService;
	
	@Resource(name="userService")
	private UserService userService;
	
//	영화 파일 업로드 경로
	@Autowired
	private String uploadPath;
	
//	영화 전체 조회 (페이징 처리 완료)
	@RequestMapping("/movieSelectList.do")
	public String movieSelectList(Model model
							    , CriteriaVO cri) {
		
		PageVO pageVO = new PageVO(cri, movieService.getTotal(cri));
		List<MovieVO> list = movieService.getList(cri);
		
		model.addAttribute("movies", list);
		model.addAttribute("pageVO", pageVO);
		
		return "movie/movieSelectList";
	}
	
//	영화 1건 조회, 평균 평점 계산
	@PostMapping("/movieSelect.do")
	public String movieSelect(MovieVO vo
							, Model model
							, UserVO uvo
							, Principal principal) {
		
		System.out.println("===================== 여긴 도달했는가?? ========================");
		
		String uId = principal.getName();
		uvo.setUserId(uId);
		
		List<MovieVO> list = movieService.selectMovie(vo);
		uvo = userService.userSelectLogin(uvo);
		MovieVO movie = movieService.selectMovieOne(vo);
		List<MovieReplyVO> replys = movieService.selectListReply(vo);
		
		float avg = movieService.avgReplyStar(vo);
		if(avg == 0) {
			model.addAttribute("avg", 0);
		} else {
			model.addAttribute("avg", avg);
		}
		
		if(vo == null) {
			model.addAttribute("message", "영화 한 건 조회가 실패했습니다.");
			return "cmmn/error";
		}

		movieService.updateMovieHit(vo);
		
		model.addAttribute("movie", movie);
		model.addAttribute("list", list);
		model.addAttribute("user", uvo);
		model.addAttribute("replys", replys);
		
		return "movie/movieSelect";
	}
	
//	영화 등록 양식
	@RequestMapping("/movieInsertForm.do")
	public String movieInsertForm() {
		return "movie/movieInsertForm";
	}
	
//	영화 등록 처리, 파일은 required => .isEmpty() 메서드 사용하지 않음
	@PostMapping("/movieInsert.do")
	public String movieInsert(Principal p
							, MovieVO vo
							, List<MultipartFile> files
							, MovieCodeVO cvo
							, Model model) {
		
		if(p == null) {
			return "security/error_auth";
		}
		String id = p.getName();
		vo.setUserId(id);
		
		int voResult = movieService.insertMovie(vo);
		
		List<MultipartFile> fileList = files;
		
		for(MultipartFile mf : fileList) {			
			String orinalFileName = mf.getOriginalFilename();
			String uId = UUID.randomUUID().toString();
			String fileRename = uId + orinalFileName.substring(orinalFileName.lastIndexOf("."));
			
			System.out.println("====================================="+fileRename);
			
			File target = new File(uploadPath, fileRename);
			try {
				FileCopyUtils.copy(mf.getBytes(), target);
				fileRename = File.separator + fileRename;;
				
				cvo.setMovieCdDetail(orinalFileName);
				cvo.setMovieCdRename(fileRename);
				
				System.out.println("********************fileOriginalName: "+cvo.getMovieCdDetail());
				System.out.println("********************fileRename: "+cvo.getMovieCdRename());
				
				movieService.insertMovieCode(cvo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(voResult == 0) {
			model.addAttribute("message", "영화등록이 실패했습니다.");
		}
		
		model.addAttribute("message", "영화등록이 성공했습니다.");
		return "movie/message";
	}
	
//	영화 1건 삭제
	@PostMapping("/movieDelete.do")
	public String movieDelete(MovieVO vo
							, Model model
							, MovieReplyVO rvo) {
		
		int deleteRe = movieService.deleteReplyMovie(rvo);
		
		if(deleteRe == 0) {
			model.addAttribute("message", "삭제가 실패했습니다.");
			return "cmmn/error";
		}
		
		int deleteCd = movieService.deleteMovieCode(vo);
		int delete = movieService.deleteMovie(vo);
		
		if(delete == 0 || deleteCd == 0) {
			model.addAttribute("message", "삭제가 실패했습니다.");
			return "cmmn/error";
		}
		
		model.addAttribute("message", "삭제를 성공했습니다.");
		return "cmmn/success";
	}
	
}

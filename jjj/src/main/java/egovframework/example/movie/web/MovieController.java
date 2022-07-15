package egovframework.example.movie.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.cost.sevice.CriteriaVO;
import egovframework.example.cost.sevice.PageVO;
import egovframework.example.movie.sevice.MovieService;
import egovframework.example.movie.sevice.MovieVO;

@Controller
public class MovieController {
	
	@Resource(name="movieService")
	private MovieService movieService;
	
	@RequestMapping("/movieSelectList.do")
	public String movieSelectList(Model model, CriteriaVO cri) {
		PageVO pageVO = new PageVO(cri, movieService.getTotal(cri));
		List<MovieVO> list = movieService.getList(cri);
		
		model.addAttribute("movies", list);
		model.addAttribute("pageVO", pageVO);
		
		return "movie/movieSelectList";
	}
	
	@RequestMapping("/movieInsertForm.do")
	public String movieInsertForm() {
		return "movie/movieInsertForm";
	}
	
	@PostMapping("/movieInsert.do")
	public String movieInsert(MovieVO vo) {
		
		return "";
	}
	
}

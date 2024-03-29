package egovframework.example.movie.web;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.example.movie.sevice.MovieReplyVO;
import egovframework.example.movie.sevice.MovieService;

@RestController
public class MovieRestController {
	
	@Resource(name="movieService")
	private MovieService movieService;
	
//	영화 댓글 등록
	@PostMapping("/ajaxInsertMovieReply.do")
	public String ajaxInsertMovieReply(MovieReplyVO rvo) {
		int insert = movieService.insertReply(rvo);
		if(insert == 0) {
			return "fail";
		}
		return "success";
	}
	
//	영화 댓글 삭제
	@PostMapping("/ajaxDeleteMovieReply.do")
	public String ajaxDeleteMovieReply(MovieReplyVO rvo) {
		int delete = movieService.deleteReply(rvo);
		if(delete == 0) {
			return "fail";
		}
		return "success";
	}
}

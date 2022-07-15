package egovframework.example.movie.sevice.impl;

import java.util.List;

import egovframework.example.cost.sevice.CriteriaVO;
import egovframework.example.movie.sevice.MovieVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("movieMapper")
public interface MovieMapper {

	List<MovieVO> selectListMovie();
	MovieVO selectMovie(MovieVO vo);
	int insertMovie(MovieVO vo);
	int updateMovie(MovieVO vo);
	int deleteMovie(MovieVO vo);
	
//	조회수증가(인기순위)
	void updateMovieHit(MovieVO vo);
	
//	페이징
	List<MovieVO> getList(CriteriaVO cri);
	int getTotal(CriteriaVO cri);
}

package egovframework.example.movie.sevice.impl;

import java.util.List;
import java.util.Map;

import egovframework.example.cost.sevice.CriteriaVO;
import egovframework.example.movie.sevice.MovieCodeVO;
import egovframework.example.movie.sevice.MovieReplyVO;
import egovframework.example.movie.sevice.MovieVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("movieMapper")
public interface MovieMapper {

	List<MovieVO> selectListMovie();
//	영화정보 1건조회
	MovieVO selectMovieOne(MovieVO vo);
//	영화 1건에 들어가는 첨부이미지 list 조회
	List<MovieVO> selectMovie(MovieVO vo);
	int insertMovie(MovieVO vo);
	int insertMovieCode(MovieCodeVO cvo);
	int updateMovie(MovieVO vo);
	int deleteMovie(MovieVO vo);
	int deleteMovieCode(MovieVO cvo);
	
//	조회수증가(인기순위)
	void updateMovieHit(MovieVO vo);
	
//	페이징
	List<MovieVO> getList(CriteriaVO cri);
	int getTotal(CriteriaVO cri);
	
//	프로시저사용-movies, movie_code 테이블 동시 insert
	int procedureCall(Map<String, Object> map);
	
//	movieCodeVO의 movie_cd_no 구하기
	int selectMovieCdNo();
	
//	영화댓글 기능
	List<MovieReplyVO> selectListReply(MovieVO vo);
	int deleteReply(MovieReplyVO rvo);
	int insertReply(MovieReplyVO rvo);
	
//	별점 평균 구하기 (영화)
	float avgReplyStar(MovieVO vo);
	
//	영화 삭제 => 영화댓글 삭제
	int deleteReplyMovie(MovieReplyVO rvo);
	
}

package egovframework.example.movie.sevice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egovframework.example.cost.sevice.CriteriaVO;
import egovframework.example.movie.sevice.MovieCodeVO;
import egovframework.example.movie.sevice.MovieVO;

@Repository("movieDAO")
public class MovieDAO {

	@Resource(name = "sqlSession")
	private SqlSession query;
	
	private static final String namespace = "movieMapper.";

	List<MovieVO> selectListMovie() {
		return query.selectList(namespace+"selectListMovie");
	}
	
//	영화정보 1건조회
	MovieVO selectMovieOne(MovieVO vo) {
		return query.selectOne(namespace+"selectMovieOne", vo);
	}
	
//	영화 1건에 들어가는 첨부이미지 list 조회
	List<MovieVO> selectMovie(MovieVO vo) {
		return query.selectList(namespace+"selectMovie", vo);
	}

	int insertMovie(MovieVO vo) {
		return query.insert(namespace+"insertMovie", vo);
	}

	int updateMovie(MovieVO vo) {
		return query.update(namespace+"updateMovie", vo);
	}

	int deleteMovie(MovieVO vo) {
		return query.delete(namespace+"deleteMovie", vo);
	}
	
	int deleteMovieCode(MovieVO cvo) {
		return query.delete(namespace+"deleteMovieCode", cvo);
	}
	
//	조회수증가(인기순위)
	void updateMovieHit(MovieVO vo) {
		query.update(namespace+"updateMovieHit", vo);
	}
	
//	페이징
	List<MovieVO> getList(CriteriaVO cri){
		return query.selectList(namespace+"getList", cri);
	}
	
	int getTotal(CriteriaVO cri) {
		return query.selectOne(namespace+"getTotal", cri);
	}
	
//	프로시저사용-movies, movie_code 테이블 동시 insert
	int procedureCall(Map<String, Object> map) {
		return query.insert(namespace+"procedureCall", map);
	}
	
//	movieCodeVO의 movie_cd_no 구하기
	int selectMovieCdNo() {
		return query.selectOne(namespace+"selectMovieCdNo");
	}
	
	int insertMovieCode(MovieCodeVO cvo) {
		return query.insert(namespace+"insertMovieCode", cvo);
	}

}

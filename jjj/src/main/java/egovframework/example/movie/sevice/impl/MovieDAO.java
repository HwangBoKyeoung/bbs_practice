package egovframework.example.movie.sevice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egovframework.example.cost.sevice.CriteriaVO;
import egovframework.example.movie.sevice.MovieVO;

@Repository("movieDAO")
public class MovieDAO {

	@Resource(name = "sqlSession")
	private SqlSession query;
	
	private static final String namespace = "movieMapper.";

	List<MovieVO> selectListMovie() {
		return query.selectList(namespace+"selectListMovie");
	}

	MovieVO selectMovie(MovieVO vo) {
		return query.selectOne(namespace+"selectMovie", vo);
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

}

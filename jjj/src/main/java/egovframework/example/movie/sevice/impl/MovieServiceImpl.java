package egovframework.example.movie.sevice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.cost.sevice.CriteriaVO;
import egovframework.example.movie.sevice.MovieService;
import egovframework.example.movie.sevice.MovieVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("movieService")
public class MovieServiceImpl extends EgovAbstractServiceImpl implements MovieService {
	
	@Resource(name="movieDAO")
	private MovieDAO movieDAO;
	
	@Override
	public List<MovieVO> selectListMovie() {
		return movieDAO.selectListMovie();
	}

	@Override
	public MovieVO selectMovie(MovieVO vo) {
		return movieDAO.selectMovie(vo);
	}

	@Override
	public int insertMovie(MovieVO vo) {
		return movieDAO.insertMovie(vo);
	}

	@Override
	public int updateMovie(MovieVO vo) {
		return movieDAO.updateMovie(vo);
	}

	@Override
	public int deleteMovie(MovieVO vo) {
		return movieDAO.deleteMovie(vo);
	}

	@Override
	public void updateMovieHit(MovieVO vo) {
		movieDAO.updateMovieHit(vo);
	}

	@Override
	public List<MovieVO> getList(CriteriaVO cri) {
		return movieDAO.getList(cri);
	}

	@Override
	public int getTotal(CriteriaVO cri) {
		return movieDAO.getTotal(cri);
	}

}

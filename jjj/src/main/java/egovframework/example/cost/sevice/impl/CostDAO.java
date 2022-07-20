package egovframework.example.cost.sevice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egovframework.example.cost.sevice.CostVO;
import egovframework.example.cost.sevice.CriteriaVO;

@Repository("costDAO")
public class CostDAO {
	
	@Resource(name="sqlSession")
	private SqlSession query;
	
	private static final String namespace = "costMapper.";
	
	public List<CostVO> costSelectList() {
		return query.selectList(namespace+"costSelectList");
	}

	public CostVO costSelect(CostVO vo) {
		return query.selectOne(namespace+"costSelect", vo);
	}

	public int costInsert(CostVO vo) {
		return query.insert(namespace+"costInsert", vo);
	}

	public int costDelete(CostVO vo) {
		return query.delete(namespace+"costDelete", vo);
	}

	public int costUpdate(CostVO vo) {
		return query.update(namespace+"costUpdate", vo);
	}
	
	List<CostVO> getList(CriteriaVO cri){
		return query.selectList(namespace+"getList", cri);
	}
	
	int getTotal(CriteriaVO cri) {
		return query.selectOne(namespace+"getTotal", cri);
	}
	
	List<CostVO> costCalendarList(){
		return query.selectList(namespace+"costCalendarList");
	}
	
}

package egovframework.example.cost.sevice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egovframework.example.cost.sevice.CostVO;
import egovframework.example.cost.sevice.CriteriaVO;

@Repository("costDAO")
public class CostDAO/* extends EgovAbstractMapper*/ {
	
	@Resource(name="sqlSession")
	private SqlSession query;
	
	public List<CostVO> costSelectList() {
		return query.selectList("costSelectList");
	}

	public CostVO costSelect(CostVO vo) {
		return query.selectOne("costSelect", vo);
	}

	public int costInsert(CostVO vo) {
		return query.insert("costInsert", vo);
	}

	public int costDelete(CostVO vo) {
		return query.delete("costDelete", vo);
	}

	public int costUpdate(CostVO vo) {
		return query.update("costUpdate", vo);
	}
	
	List<CostVO> getList(CriteriaVO cri){
		return query.selectList("getList", cri);
	}
	
	int getTotal(CriteriaVO cri) {
		return query.selectOne("getTotal", cri);
	}
	
	List<CostVO> costCalendarList(){
		return query.selectList("costCalendarList");
	}
	
}

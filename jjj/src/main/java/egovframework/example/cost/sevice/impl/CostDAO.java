package egovframework.example.cost.sevice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egovframework.example.cost.sevice.CostVO;
import egovframework.example.cost.sevice.CriteriaVO;

@Repository("costDAO")
public class CostDAO {
	
//	classpath:/egovframework/spring/context-mapper.xml에 sqlSessionTemplate 설정완료
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
	
//	페이징처리(마이페이지-본인 경비내역)
	List<CostVO> getListByUser(Map<String, Object> myPageMap){
		return query.selectList(namespace+"getListByUser", myPageMap);
	}
	
	int getTotalByUser(Map<String, Object> myPageMap) {
		return query.selectOne(namespace+"getTotalByUser", myPageMap);
	}
	
	List<CostVO> costCalendarList(){
		return query.selectList(namespace+"costCalendarList");
	}
	
//	연별/월별 경비 차트
	List<CostVO> costSumByYear(String year) {
		return query.selectList(namespace+"costSumByYear", year);
	}
	
//	마이페이지-자신의 경비사용내역
	List<CostVO> costSelectByUser(CostVO vo) {
		return query.selectList(namespace+"costSelectByUser", vo);
	}
	
}

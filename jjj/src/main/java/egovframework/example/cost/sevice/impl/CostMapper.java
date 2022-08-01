package egovframework.example.cost.sevice.impl;

import java.util.List;
import java.util.Map;

import egovframework.example.cost.sevice.CostVO;
import egovframework.example.cost.sevice.CriteriaVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("costMapper")
public interface CostMapper {
	
//	기본 CRUD
	List<CostVO> costSelectList();
	CostVO costSelect(CostVO vo);
	int costInsert(CostVO vo);
	int costDelete(CostVO vo);
	int costUpdate(CostVO vo);
	
	List<CostVO> getList(CriteriaVO cri);
	int getTotal(CriteriaVO cri);
	
//	페이징처리(마이페이지-본인 경비내역)
	List<CostVO> getListByUser(Map<String, Object> myPageMap);
	int getTotalByUser(Map<String, Object> myPageMap);
	
	List<CostVO> costCalendarList();
	
//	연별/월별 경비 차트
	List<CostVO> costSumByYear(String year);
	
//	마이페이지-자신의 경비사용내역
	List<CostVO> costSelectByUser(CostVO vo);
	
}

package egovframework.example.cost.sevice.impl;

import java.util.List;

import egovframework.example.cost.sevice.CostVO;
import egovframework.example.cost.sevice.CriteriaVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("costMapper")
public interface CostMapper {
	
	List<CostVO> costSelectList();
	CostVO costSelect(CostVO vo);
	int costInsert(CostVO vo);
	int costDelete(CostVO vo);
	int costUpdate(CostVO vo);
	
	List<CostVO> getList(CriteriaVO cri);
	int getTotal(CriteriaVO cri);
	
	List<CostVO> costCalendarList();
	
//	연별/월별 경비 차트
	List<CostVO> costSumByYear(String year);
	
}

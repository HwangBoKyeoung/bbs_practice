package egovframework.example.cost.sevice;

import java.util.List;

public interface CostService {
	
	List<CostVO> costSelectList();
	CostVO costSelect(CostVO vo);
	int costInsert(CostVO vo);
	int costDelete(CostVO vo);
	int costUpdate(CostVO vo);
	
//	페이징처리
	List<CostVO> getList(CriteriaVO cri);
	int getTotal(CriteriaVO cri);
	
//	캘린더처리
	List<CostVO> costCalendarList();
	
//	연별/월별 경비 차트
	List<CostVO> costSumByYear(String year);
	
}

package egovframework.example.cost.sevice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.cost.sevice.CostService;
import egovframework.example.cost.sevice.CostVO;
import egovframework.example.cost.sevice.CriteriaVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("costService")
public class CostServiceImpl extends EgovAbstractServiceImpl implements CostService {
	
	@Resource(name="costDAO")
	private CostDAO costDAO;
	
	@Override
	public List<CostVO> costSelectList() {
		return costDAO.costSelectList();
	}

	@Override
	public CostVO costSelect(CostVO vo) {
		return costDAO.costSelect(vo);
	}

	@Override
	public int costInsert(CostVO vo) {
		return costDAO.costInsert(vo);
	}

	@Override
	public int costDelete(CostVO vo) {
		return costDAO.costDelete(vo);
	}

	@Override
	public int costUpdate(CostVO vo) {
		return costDAO.costUpdate(vo);
	}

	@Override
	public List<CostVO> getList(CriteriaVO cri) {
		return costDAO.getList(cri);
	}

	@Override
	public int getTotal(CriteriaVO cri) {
		return costDAO.getTotal(cri);
	}

	@Override
	public List<CostVO> costCalendarList() {
		return costDAO.costCalendarList();
	}

	@Override
	public List<CostVO> costSumByYear(String year) {
		return costDAO.costSumByYear(year);
	}

}

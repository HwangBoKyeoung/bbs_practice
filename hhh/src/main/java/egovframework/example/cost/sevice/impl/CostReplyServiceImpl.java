package egovframework.example.cost.sevice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.cost.sevice.CostReplyService;
import egovframework.example.cost.sevice.CostReplyVO;

@Service("costReplyService")
public class CostReplyServiceImpl implements CostReplyService {
	
	@Resource(name="costReplyDAO")
	private CostReplyDAO costReplyDAO;

	@Override
	public List<CostReplyVO> selectCostReply(CostReplyVO vo) {
		return costReplyDAO.selectCostReply(vo);
	}

	@Override
	public int insertCostReply(CostReplyVO vo) {
		return costReplyDAO.insertCostReply(vo);
	}

	@Override
	public int updateCostReply(CostReplyVO vo) {
		return costReplyDAO.updateCostReply(vo);
	}

	@Override
	public int deleteCostReply(CostReplyVO vo) {
		return costReplyDAO.deleteCostReply(vo);
	}
	
}

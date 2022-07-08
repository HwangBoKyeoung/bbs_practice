package egovframework.example.cost.sevice;

import java.util.List;

public interface CostReplyService {
	
	List<CostReplyVO> selectCostReply(CostReplyVO vo);
	int insertCostReply(CostReplyVO vo);
	int updateCostReply(CostReplyVO vo);
	int deleteCostReply(CostReplyVO vo);
	
}

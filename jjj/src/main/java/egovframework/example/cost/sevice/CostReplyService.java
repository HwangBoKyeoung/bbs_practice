package egovframework.example.cost.sevice;

import java.util.List;

public interface CostReplyService {
	
//	기본 CRUD, 댓글 1건 조회는 있을 필요가 없기 때문에 만들지 않음
	List<CostReplyVO> selectCostReply(CostReplyVO vo);
	int insertCostReply(CostReplyVO vo);
	int updateCostReply(CostReplyVO vo);
	int deleteCostReply(CostReplyVO vo);
	
}

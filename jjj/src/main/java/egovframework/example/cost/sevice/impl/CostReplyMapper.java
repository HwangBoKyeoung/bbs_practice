package egovframework.example.cost.sevice.impl;

import java.util.List;

import egovframework.example.cost.sevice.CostReplyVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("costReplyMapper")
public interface CostReplyMapper {

	List<CostReplyVO> selectCostReply(CostReplyVO vo);
	int insertCostReply(CostReplyVO vo);
	int updateCostReply(CostReplyVO vo);
	int deleteCostReply(CostReplyVO vo);
	
}

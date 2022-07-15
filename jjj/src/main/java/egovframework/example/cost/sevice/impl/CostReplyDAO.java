package egovframework.example.cost.sevice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egovframework.example.cost.sevice.CostReplyVO;

@Repository("costReplyDAO")
public class CostReplyDAO {
	
	@Resource(name="sqlSession")
	private SqlSession query;
	
	private static final String namespace = "costReplyMapper.";
	
	List<CostReplyVO> selectCostReply(CostReplyVO vo) {
		return query.selectList(namespace+"selectCostReply", vo);
	}

	int insertCostReply(CostReplyVO vo) {
		return query.insert(namespace+"insertCostReply", vo);
	}

	int updateCostReply(CostReplyVO vo) {
		return query.update(namespace+"updateCostReply", vo);
	}

	int deleteCostReply(CostReplyVO vo) {
		return query.delete(namespace+"deleteCostReply", vo);
	}
	
}

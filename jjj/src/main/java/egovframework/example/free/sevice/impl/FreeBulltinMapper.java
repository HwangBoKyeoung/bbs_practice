package egovframework.example.free.sevice.impl;

import java.util.List;

import egovframework.example.cost.sevice.CriteriaVO;
import egovframework.example.free.sevice.FreeBulletinReplyVO;
import egovframework.example.free.sevice.FreeBulletinVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("freeMapper")
public interface FreeBulltinMapper {

//	자유게시판
	List<FreeBulletinVO> selectListFreeBulletin();
	FreeBulletinVO selectFreeBulletin(FreeBulletinVO vo);
	int insertFreeBulletin(FreeBulletinVO vo);
	int updateFreeBulletin(FreeBulletinVO vo);
	int deleteFreeBulletin(FreeBulletinVO vo);
	
//	자유게시판 조회수 증가
	void updateFreeBulletinHitUp(FreeBulletinVO vo);
	
//	자유게시판 조회수 감소
	void updateFreeBulletinHitDown(FreeBulletinVO vo);
	
//	자유게시판 댓글
	List<FreeBulletinReplyVO> selectListFreeBulletinReply(FreeBulletinReplyVO rvo);
	int insertFreeBulletinReply(FreeBulletinReplyVO rvo);
	int deleteFreeBulletinReply(FreeBulletinReplyVO rvo);
	int updateFreeBulletinReply(FreeBulletinReplyVO rvo);

//	자유게시판 댓글 삭제처리 => 완전 삭제가 아닌 화면에서 삭제된 댓글이라고만 보여주기
	int updateDeleteFreeBulletinReply(FreeBulletinReplyVO rvo);
	
//	자유게시판 페이징처리
	List<FreeBulletinVO> getList(CriteriaVO cri);
	int getTotal(CriteriaVO cri);
	
}

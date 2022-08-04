package egovframework.example.free.sevice.impl;

import java.util.List;

import egovframework.example.free.sevice.FreeBulletinReplyReplyVO;
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
	
//	자유게시판 댓글
	List<FreeBulletinReplyVO> selectListFreeBulletinReply(FreeBulletinReplyVO rvo);
	int insertFreeBulletinReply(FreeBulletinReplyVO rvo);
	int deleteFreeBulletinReply(FreeBulletinReplyVO rvo);
	
//	댓글의 대댓글
	List<FreeBulletinReplyReplyVO> selectListFreeBulletinReplyReply(FreeBulletinReplyReplyVO rrvo);
	int insertFreeBulletinReplyReply(FreeBulletinReplyReplyVO rrvo);
	int deleteFreeBulletinReplyReply(FreeBulletinReplyReplyVO rrvo);
	
}

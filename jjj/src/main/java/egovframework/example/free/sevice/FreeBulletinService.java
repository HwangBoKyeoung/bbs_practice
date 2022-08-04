package egovframework.example.free.sevice;

import java.util.List;

public interface FreeBulletinService {
	
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

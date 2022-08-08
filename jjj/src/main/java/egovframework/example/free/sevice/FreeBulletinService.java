package egovframework.example.free.sevice;

import java.util.List;

import egovframework.example.cost.sevice.CriteriaVO;

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
	
//	자유게시판 페이징처리
	List<FreeBulletinVO> getList(CriteriaVO cri);
	int getTotal(CriteriaVO cri);
	
}

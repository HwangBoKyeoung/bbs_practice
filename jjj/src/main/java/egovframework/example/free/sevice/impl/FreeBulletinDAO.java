package egovframework.example.free.sevice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egovframework.example.free.sevice.FreeBulletinReplyReplyVO;
import egovframework.example.free.sevice.FreeBulletinReplyVO;
import egovframework.example.free.sevice.FreeBulletinVO;

@Repository("freeDAO")
public class FreeBulletinDAO {

	@Resource(name="sqlSession")
	private SqlSession query;

	private static final String namespace = "freeMapper.";

	// 자유게시판
	List<FreeBulletinVO> selectListFreeBulletin() {
		return query.selectList(namespace + "selectListFreeBulletin");
	}

	FreeBulletinVO selectFreeBulletin(FreeBulletinVO vo) {
		return query.selectOne(namespace + "selectFreeBulletin", vo);
	}

	int insertFreeBulletin(FreeBulletinVO vo) {
		return query.insert(namespace + "insertFreeBulletin", vo);
	}

	int updateFreeBulletin(FreeBulletinVO vo) {
		return query.update(namespace + "updateFreeBulletin", vo);
	}

	int deleteFreeBulletin(FreeBulletinVO vo) {
		return query.delete(namespace + "deleteFreeBulletin", vo);
	}

	// 자유게시판 조회수 증가
	void updateFreeBulletinHitUp(FreeBulletinVO vo) {
		query.update(namespace + "updateFreeBulletinHitUp", vo);
	}

	// 자유게시판 댓글
	List<FreeBulletinReplyVO> selectListFreeBulletinReply(FreeBulletinReplyVO rvo) {
		return query.selectList(namespace + "selectListFreeBulletinReply", rvo);
	}

	int insertFreeBulletinReply(FreeBulletinReplyVO rvo) {
		return query.insert(namespace + "insertFreeBulletinReply", rvo);
	}

	int deleteFreeBulletinReply(FreeBulletinReplyVO rvo) {
		return query.delete(namespace + "deleteFreeBulletinReply", rvo);
	}

	// 댓글의 대댓글
	List<FreeBulletinReplyReplyVO> selectListFreeBulletinReplyReply(FreeBulletinReplyReplyVO rrvo) {
		return query.selectList(namespace + "selectListFreeBulletinReplyReply", rrvo);
	}

	int insertFreeBulletinReplyReply(FreeBulletinReplyReplyVO rrvo) {
		return query.insert(namespace + "insertFreeBulletinReplyReply", rrvo);
	}

	int deleteFreeBulletinReplyReply(FreeBulletinReplyReplyVO rrvo) {
		return query.delete(namespace + "deleteFreeBulletinReplyReply", rrvo);
	}
}

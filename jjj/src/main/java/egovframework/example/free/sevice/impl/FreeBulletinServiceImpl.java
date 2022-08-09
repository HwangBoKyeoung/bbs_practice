package egovframework.example.free.sevice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.cost.sevice.CriteriaVO;
import egovframework.example.free.sevice.FreeBulletinReplyVO;
import egovframework.example.free.sevice.FreeBulletinService;
import egovframework.example.free.sevice.FreeBulletinVO;

@Service("freeService")
public class FreeBulletinServiceImpl implements FreeBulletinService {
	
	@Resource(name="freeDAO")
	private FreeBulletinDAO freeDAO;
	
	@Override
	public List<FreeBulletinVO> selectListFreeBulletin() {
		return freeDAO.selectListFreeBulletin();
	}

	@Override
	public FreeBulletinVO selectFreeBulletin(FreeBulletinVO vo) {
		return freeDAO.selectFreeBulletin(vo);
	}

	@Override
	public int insertFreeBulletin(FreeBulletinVO vo) {
		return freeDAO.insertFreeBulletin(vo);
	}

	@Override
	public int updateFreeBulletin(FreeBulletinVO vo) {
		return freeDAO.updateFreeBulletin(vo);
	}

	@Override
	public int deleteFreeBulletin(FreeBulletinVO vo) {
		return freeDAO.deleteFreeBulletin(vo);
	}

	@Override
	public void updateFreeBulletinHitUp(FreeBulletinVO vo) {
		freeDAO.updateFreeBulletinHitUp(vo);
	}

	@Override
	public List<FreeBulletinReplyVO> selectListFreeBulletinReply(FreeBulletinReplyVO rvo) {
		return freeDAO.selectListFreeBulletinReply(rvo);
	}

	@Override
	public int insertFreeBulletinReply(FreeBulletinReplyVO rvo) {
		return freeDAO.insertFreeBulletinReply(rvo);
	}

	@Override
	public int deleteFreeBulletinReply(FreeBulletinReplyVO rvo) {
		return freeDAO.deleteFreeBulletinReply(rvo);
	}

	@Override
	public List<FreeBulletinVO> getList(CriteriaVO cri) {
		return freeDAO.getList(cri);
	}

	@Override
	public int getTotal(CriteriaVO cri) {
		return freeDAO.getTotal(cri);
	}

	@Override
	public int updateFreeBulletinReply(FreeBulletinReplyVO rvo) {
		return freeDAO.updateFreeBulletinReply(rvo);
	}

	@Override
	public int updateDeleteFreeBulletinReply(FreeBulletinReplyVO rvo) {
		return freeDAO.updateDeleteFreeBulletinReply(rvo);
	}

	@Override
	public void updateFreeBulletinHitDown(FreeBulletinVO vo) {
		freeDAO.updateFreeBulletinHitDown(vo);
	}

}

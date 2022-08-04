package egovframework.example.addr.sevice.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egovframework.example.addr.sevice.AddrVO;

@Repository("addrDAO")
public class AddrDAO {
	
	@Resource(name="sqlSession")
	private SqlSession query;
	
	private static final String namespace = "addrMapper.";
	
//	내 주소지 보기
	AddrVO selectAddrInfo(AddrVO vo) {
		return query.selectOne(namespace+"selectAddrInfo", vo);
	}

//	주소지 입력
	int insertAddrInfo(AddrVO vo) {
		return query.insert(namespace+"insertAddrInfo", vo);
	}
	
//	주소지 삭제
	int deleteAddrInfo(AddrVO vo) {
		return query.delete(namespace+"deleteAddrInfo", vo);
	}
	
//	주소지 수정
	int updateAddrInfo(AddrVO vo) {
		return query.update(namespace+"updateAddrInfo", vo);
	}
	
}

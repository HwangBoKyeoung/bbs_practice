package egovframework.example.addr.sevice.impl;

import egovframework.example.addr.sevice.AddrVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("addrMapper")
public interface AddrMapper {

//	주소지 입력
	int insertAddrInfo(AddrVO vo);
//	주소지 삭제
	int deleteAddrInfo(AddrVO vo);
//	주소지 수정
	int updateAddrInfo(AddrVO vo);
	
}

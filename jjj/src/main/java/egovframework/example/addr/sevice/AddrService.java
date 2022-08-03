package egovframework.example.addr.sevice;

public interface AddrService {
	
//	주소지 입력
	int insertAddrInfo(AddrVO vo);
//	주소지 삭제
	int deleteAddrInfo(AddrVO vo);
//	주소지 수정
	int updateAddrInfo(AddrVO vo);
	
}

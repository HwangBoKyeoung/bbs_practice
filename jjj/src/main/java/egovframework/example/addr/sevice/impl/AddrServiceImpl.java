package egovframework.example.addr.sevice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.addr.sevice.AddrService;
import egovframework.example.addr.sevice.AddrVO;

@Service("addrService")
public class AddrServiceImpl implements AddrService {
	
	@Resource(name="addrDAO")
	private AddrDAO addrDAO;
	
	@Override
	public AddrVO selectAddrInfo(AddrVO vo) {
		return addrDAO.selectAddrInfo(vo);
	}
	
	@Override
	public int insertAddrInfo(AddrVO vo) {
		return addrDAO.insertAddrInfo(vo);
	}

	@Override
	public int deleteAddrInfo(AddrVO vo) {
		return addrDAO.deleteAddrInfo(vo);
	}

	@Override
	public int updateAddrInfo(AddrVO vo) {
		return addrDAO.updateAddrInfo(vo);
	}

}

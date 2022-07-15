package egovframework.example.user.sevice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.user.sevice.UserService;
import egovframework.example.user.sevice.UserVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("userService")
public class UserServiceImpl extends EgovAbstractServiceImpl implements UserService {

	@Resource(name = "userDAO")
	private UserDAO userDAO;

	@Override
	public List<UserVO> userSelectList() {
		return userDAO.userSelectList();
	}

	@Override
	public UserVO userSelect(UserVO vo) {
		return userDAO.userSelect(vo);
	}

	@Override
	public int userInsert(UserVO vo) {
		return userDAO.userInsert(vo);
	}

	@Override
	public int userDelete(UserVO vo) {
		return userDAO.userDelete(vo);
	}

	@Override
	public int userUpdate(UserVO vo) {
		return userDAO.userUpdate(vo);
	}

	@Override
	public int userIdChk(UserVO vo) {
		return userDAO.userIdChk(vo);
	}

	@Override
	public UserVO userSelectLogin(UserVO vo) {
		return userDAO.userSelectLogin(vo);
	}
	
}

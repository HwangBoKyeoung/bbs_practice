package egovframework.example.user.sevice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egovframework.example.user.sevice.UserVO;

@Repository("userDAO")
public class UserDAO {
	
	@Resource(name="sqlSession")
	private SqlSession query;

	List<UserVO> userSelectList() {
		return query.selectList("userSelectList");
	}

	UserVO userSelect(UserVO vo) {
		return query.selectOne("userSelect", vo);
	}

	int userInsert(UserVO vo) {
		return query.insert("userInsert", vo);
	}

	int userDelete(UserVO vo) {
		return query.delete("userDelete", vo);
	}

	int userUpdate(UserVO vo) {
		return query.update("userUpdate", vo);
	}
	
//	아이디중복체크 : 0=> 아이디생성가능, 1=> 아이디중복, else=> 아이디입력
	int userIdChk(UserVO vo) {
		return query.selectOne("userIdChk", vo);
	}

//	아이디를 통해 비밀번호 찾기
	UserVO userSelectLogin(UserVO vo) {
		return query.selectOne("userSelectLogin", vo);
	}

}

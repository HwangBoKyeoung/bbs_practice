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
	
	private static final String namespace = "userMapper.";

	List<UserVO> userSelectList() {
		return query.selectList(namespace+"userSelectList");
	}

	UserVO userSelect(UserVO vo) {
		return query.selectOne(namespace+"userSelect", vo);
	}

	int userInsert(UserVO vo) {
		return query.insert(namespace+"userInsert", vo);
	}

	int userDelete(UserVO vo) {
		return query.delete(namespace+"userDelete", vo);
	}

	int userUpdate(UserVO vo) {
		return query.update(namespace+"userUpdate", vo);
	}
	
//	아이디중복체크 : 0=> 아이디생성가능, 1=> 아이디중복, else=> 아이디입력
	int userIdChk(UserVO vo) {
		return query.selectOne(namespace+"userIdChk", vo);
	}

//	security 로그인정보
	UserVO userSelectLogin(UserVO vo) {
		return query.selectOne(namespace+"userSelectLogin", vo);
	}

//	비밀번호찾기
	int findUserPassword(UserVO vo) {
		return query.update(namespace+"findUserPassword", vo);
	}
	
//	이메일로 아이디찾기 (임시비밀번호 변경을 위해 필요)
	String findUserIdByMail(String mail) {
		return query.selectOne(namespace+"findUserIdByMail", mail);
	}
	
//	카카오로그인
	int kakaoUserInsert(UserVO vo) {
		return query.insert(namespace+"kakaoUserInsert", vo);
	}

}

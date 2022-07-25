package egovframework.example.user.sevice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserVO implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String userName;
	private String userId;
	private String userPwd;
	private String userRole;
	private String userGender;
	private String userTel;
	private String userMail;

	private String role;
	private String userRePwd;
	private String ihidnum;
	private String ihIdNum2;
	private String ihIdNum3;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserRePwd() {
		return userRePwd;
	}

	public void setUserRePwd(String userRePwd) {
		this.userRePwd = userRePwd;
	}

	public String getIhidnum() {
		return ihidnum;
	}

	public void setIhidnum(String ihidnum) {
		this.ihidnum = ihidnum;
	}

	public String getIhIdNum2() {
		return ihIdNum2;
	}

	public void setIhIdNum2(String ihIdNum2) {
		this.ihIdNum2 = ihIdNum2;
	}

	public String getIhIdNum3() {
		return ihIdNum3;
	}

	public void setIhIdNum3(String ihIdNum3) {
		this.ihIdNum3 = ihIdNum3;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserVO [userName=" + userName + ", userId=" + userId + ", userPwd=" + userPwd + ", userRole=" + userRole
				+ ", userGender=" + userGender + ", userTel=" + userTel + ", userMail=" + userMail + ", role=" + role
				+ ", userRePwd=" + userRePwd + ", ihidnum=" + ihidnum + ", ihidnum2=" + ihIdNum2 + ", ihidnum3="
				+ ihIdNum3 + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(role));
		return auth;
	}

	@Override
	public String getPassword() {
		return userPwd;
	}

	@Override
	public String getUsername() {
		return userId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	// 유효성 검사 (regex이용)
	// 이메일
	public boolean isEmail(String str) {
		return Pattern.matches("^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$", str);
	}

	// 전화번호
	public boolean isTel(String str) {
		return Pattern.matches("^\\d{2,3}\\d{3,4}\\d{4}$", str);
	}

	// 주민등록번호
	public boolean isPersonalId(String str) {
		return Pattern.matches("^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$", str);
	}

	// 영어 검사
	public boolean isAlpha(String str) {
		return Pattern.matches("^[a-zA-Z]*$", str);
	}
	
	// 영어+숫자 검사 (6자리~12자리)
	public boolean isAlphaNumber(String str) {
		return Pattern.matches("^[a-zA-Z0-9]{6,12}$", str);
	}

	// 비밀번호 검사
	// 영문, 특수문자, 숫자 포함 8자 이상
	// 반복X, 아이디포함X, 연속문자X
	public boolean isPwdChk(String str, String id) {
		// '숫자', '문자', '특수문자' 무조건 1개 이상, 비밀번호 '최소 8자에서 최대 16자'까지 허용
		// (특수문자는 정의된 특수문자만 사용 가능)
		boolean p1 = Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$",
				str);
		if (!p1) {
			return false;
		}

		// 아이디 포함 여부(아이디와 동일문자 4자리 체크)
		for (int i = 0; i < str.length() - 3; i++) {
			if (id.contains(str.substring(i, i + 3))) {
				return false;
			}
		}

		return true;
	}

}

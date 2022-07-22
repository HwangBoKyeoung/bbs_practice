package egovframework.example.user.sevice;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Email;

public class UserVO implements UserDetails {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(max=10)
	private String userName;
	private String userId;
	@Pattern(regexp="/^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\\\(\\\\)\\-_=+]).{8,16}$/")
	private String userPwd;
	private String userRole;
	private String userGender;
	@Pattern(regexp="/^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$/")
	private String userTel;
	@Email
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

	public String setIhidnum() {
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

}

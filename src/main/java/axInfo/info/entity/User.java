package axInfo.info.entity;

import java.util.List;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import axInfo.info.base.entity.BaseLongEntity;



@Table(name="user")
public class User extends BaseLongEntity{
	
	@Column(name="userName",type=MySqlTypeConstant.VARCHAR,length=20)
	private String userName;
	
	@Column(name="userPassWord",type=MySqlTypeConstant.VARCHAR,length=64)
	private String userPassWord;
	
	@Column(name="userEmail",type=MySqlTypeConstant.VARCHAR,length=20,isUnique=true)
	private String userEmail;
	
	@Column(name="userPhone",type=MySqlTypeConstant.VARCHAR,length=20,isUnique=true)
	private String userPhone;
	
	@Column(name="userState",type=MySqlTypeConstant.INT,length=20)
	private int userState;
	
	@Column(name="userJurisdiction",type=MySqlTypeConstant.INT,length=20)
	private int userJurisdiction;
	
	
	//一对多
	List<UserHistory> userHistory;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassWord() {
		return userPassWord;
	}

	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getUserState() {
		return userState;
	}

	public void setUserState(int userState) {
		this.userState = userState;
	}

	public int getUserJurisdiction() {
		return userJurisdiction;
	}

	public void setUserJurisdiction(int userJurisdiction) {
		this.userJurisdiction = userJurisdiction;
	}

	
	
	public List<UserHistory> getUserHistory() {
		return userHistory;
	}

	public void setUserHistory(List<UserHistory> userHistory) {
		this.userHistory = userHistory;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPassWord=" + userPassWord + ", userEmail=" + userEmail
				+ ", userPhone=" + userPhone + ", userState=" + userState + ", userJurisdiction=" + userJurisdiction
				+ "]";
	}
	
	
	
}

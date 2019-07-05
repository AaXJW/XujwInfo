package axInfo.info.entity;

import java.util.Date;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import axInfo.info.base.entity.BaseLongEntity;

@Table(name="UserHistory")
public class UserHistory extends BaseLongEntity{

	@Column(name="userID",type=MySqlTypeConstant.BIGINT)
	public User userID;
	
	
	@Column(name="signInTime",type=MySqlTypeConstant.DATETIME)
	public Date signInTime;

	//多对一关系
	public User user;


	public User getUserID() {
		return userID;
	}


	public void setUserID(User userID) {
		this.userID = userID;
	}


	public Date getSignInTime() {
		return signInTime;
	}


	public void setSignInTime(Date signInTime) {
		this.signInTime = signInTime;
	}

	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "UserHistory [userID=" + userID + ", signInTime=" + signInTime + "]";
	}
	
	
	
	
}

package axInfo.info.base.entity;

import java.util.Date;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

public class BaseLongEntity {
	
	
	@Column(name="id",type=MySqlTypeConstant.BIGINT,isKey=true,isAutoIncrement = true)
	public long id;
	
	
	@Column(name="addTime",type=MySqlTypeConstant.DATETIME)
	public Date addTime;
	
	
	@Column(name="modTime",type=MySqlTypeConstant.DATETIME)
	public Date modTime;


	public long getId() {
		return id;
	}

 
	public void setId(long id) {
		this.id = id;
	}


	public Date getAddTime() {
		return addTime;
	}


	public void setAddTime(Date addTime) {
		this.addTime = new Date();
	}


	public Date getModTime() {
		return modTime;
	}


	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}
	
	
	
	
	
}

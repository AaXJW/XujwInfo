package axInfo.info.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import axInfo.info.entity.UserHistory;

@Mapper
public interface UserHistosyMapper {
	//一对多关系
	@Select("select * from UserHistory where userID = #{userID}")
	public List<UserHistory> listByUser(String userID);
	
	
	//登录时，往历史表中插入数据
	@Insert("insert into UserHistory(userID,addTime,signInTime) values (#{userID},#{addTime},#{signInTime})")
	public int save(@Param("userID")long userID,@Param("addTime")Date addTime,@Param("signInTime")Date signInTime);

	
	//多对一的关系
	
	@Select("select * from UserHistory")
	@Results({
		@Result(property="user",column="userID",one=@One(select="axInfo.info.mapper.UserMapper.getUserById"))
		
	})
	public List<UserHistory> list();
}

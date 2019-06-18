package axInfo.info.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import axInfo.info.entity.User;

@Mapper
public interface UserMapper {

	@Insert("insert into user(userName,userPassWord,userEmail,userPhone,userState,userJurisdiction,addTime) values (#{userName},#{userPassWord},#{userEmail},#{userPhone},#{userState},#{userJurisdiction},#{addTime})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public int save(User user);

	
	
	@Select("select userEmail from user where userEmail = #{userEmail}")
	public String getEmail(String userEmail);
	
	
	@Select("select * from user where userEmail = #{userEmail} and userPassWord =#{userPassWord}")
	public User getLogin(HashMap map);
}

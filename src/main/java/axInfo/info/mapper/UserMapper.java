package axInfo.info.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import axInfo.info.entity.User;

@Mapper
public interface UserMapper {
	
	//注册方法
	@Insert("insert into user(userName,userPassWord,userEmail,userPhone,userState,userJurisdiction,addTime) values (#{userName},#{userPassWord},#{userEmail},#{userPhone},#{userState},#{userJurisdiction},#{addTime})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public int save(User user);

	
	//查询是否邮箱已经注册
	@Select("select userEmail from user where userEmail = #{userEmail}")
	public String getEmail(String userEmail);
	
	//登录
	@Select("select * from user where userEmail = #{userEmail} and userPassWord =#{userPassWord}")
	public User getLogin(HashMap map);
	
	//一对多关系
	@Select("select * from user")
	@Results({
		@Result(property="id",column="id"),
		@Result(property="userHistory",javaType=List.class,column="id",many=@Many(
				select="axInfo.info.mapper.UserHistosyMapper.listByUser"
				))})
	public List<User> list();
	
	
	//多对一关系
	@Select("select * from user where id = #{id}")
	public User getUserById(String id);
	
	
	
	
}

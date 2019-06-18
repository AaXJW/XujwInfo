package axInfo.info.service;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import axInfo.info.entity.User;

@Mapper
public interface IUserService {

	@Insert("insert into user(userName,userPassWord,userEmail,userPhone,userState,userJurisdiction,addTime) values (#{userName},#{userPassWord},#{userEmail},#{userPhone},#{userState},#{userJurisdiction},#{addTime})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public int save(User user);

}

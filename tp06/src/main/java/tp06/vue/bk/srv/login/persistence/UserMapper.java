package tp06.vue.bk.srv.login.persistence;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import tp06.vue.bk.srv.login.domain.UserDto;

@Mapper
public interface UserMapper {
	
	@Select("SELECT usr_no, usr_id, usr_time FROM users WHERE usr_id = #{usr_id} AND usr_pwd = #{usr_pwd}")
	public List<LinkedHashMap<String, Object>> selectUsers(UserDto userDto);
	
	@Select("INSERT INTO users (usr_id, usr_pwd) VALUES (#{usr_id}, #{usr_pwd})")
	public List<LinkedHashMap<String, Object>> insertUser(UserDto userDto);
	
}

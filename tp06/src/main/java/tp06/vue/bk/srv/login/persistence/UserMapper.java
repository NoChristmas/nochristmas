package tp06.vue.bk.srv.login.persistence;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import tp06.vue.bk.srv.login.domain.UserDto;

@Mapper
public interface UserMapper {
	
	@Select("SELECT * FROM users WHERE usr_id = #{usr_id} AND usr_pwd = #{usr_pwd}")
	public List<LinkedHashMap<String, Object>> getUsers(UserDto userDto);
	
}

package tp06.vue.bk.login.persistence;

import java.util.LinkedHashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import tp06.vue.bk.srv.login.domain.UserDto;

@Mapper
@Repository
public class UserMapper {
	
	@Select("SELECT * FROM users WHERE usr_id = ?")
	public LinkedHashMap<String, Object> getUsers(UserDto userDto) {
		LinkedHashMap<String, Object> res = new LinkedHashMap<>();
		System.out.println(res.toString());
		return res;
	}
}

package tp06.vue.bk.srv.login.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import tp06.vue.bk.srv.login.domain.UserDto;

public interface UserLoginService {
	List<LinkedHashMap<String, Object>> findUser(UserDto userDto);
	
	List<LinkedHashMap<String, Object>> registUser(UserDto userDto);
}

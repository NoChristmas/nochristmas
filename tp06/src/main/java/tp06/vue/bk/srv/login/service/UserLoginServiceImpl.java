package tp06.vue.bk.srv.login.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tp06.vue.bk.login.persistence.UserMapper;
import tp06.vue.bk.srv.login.domain.UserDto;

@Service
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserLoginService {
	
	private final UserMapper userMapper;
	
	@Override
	public boolean authenticateUser(UserDto userDto) {
		
		LinkedHashMap<String, Object> res = userMapper.getUsers(userDto);
		
		return true;
	}
}

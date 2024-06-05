package tp06.vue.bk.srv.login.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tp06.vue.bk.srv.login.domain.UserDto;
import tp06.vue.bk.srv.login.persistence.UserMapper;

@Service
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserLoginService {
	
	private final UserMapper userMapper;
	
	@Override
	public boolean authenticateUser(UserDto userDto) {
		
		return userMapper.getUsers(userDto).size() > 0;
	}
}

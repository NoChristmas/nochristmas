package tp06.vue.bk.srv.login.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import tp06.vue.bk.srv.login.domain.UserDto;
import tp06.vue.bk.srv.login.persistence.UserMapper;

@Service
@RequiredArgsConstructor
@Transactional
public class UserLoginServiceImpl implements UserLoginService {
	
	private final UserMapper userMapper;
	
	@Override
	public List<LinkedHashMap<String, Object>> findUser(UserDto userDto) {
		List<LinkedHashMap<String, Object>> res = userMapper.selectUsers(userDto);
		return res;
	}
	
	@Override
	public List<LinkedHashMap<String, Object>> registUser(UserDto userDto) {
		List<LinkedHashMap<String, Object>> temp = userMapper.insertUser(userDto);
		System.out.println("temp = "+temp.toString());
		List<LinkedHashMap<String, Object>> res = userMapper.selectUsers(userDto);
		return res;
	}
}

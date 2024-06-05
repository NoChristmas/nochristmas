package tp06.vue.bk.srv.login.service;

import java.util.List;
import java.util.Map;

import tp06.vue.bk.srv.login.domain.UserDto;

public interface UserLoginService {
	boolean authenticateUser(UserDto userDto);
}

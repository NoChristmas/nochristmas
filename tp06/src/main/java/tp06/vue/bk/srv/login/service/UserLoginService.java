package tp06.vue.bk.srv.login.service;

import tp06.vue.bk.srv.login.domain.UserDto;

public interface UserLoginService {
	boolean authenticateUser(UserDto userDto);
}

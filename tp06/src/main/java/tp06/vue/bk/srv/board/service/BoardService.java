package tp06.vue.bk.srv.board.service;

import java.util.LinkedHashMap;
import java.util.List;

import tp06.vue.bk.srv.login.domain.UserDto;

public interface BoardService {
	
	public List<LinkedHashMap<String, Object>> getBoards(UserDto userDto);
	
}

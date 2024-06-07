package tp06.vue.bk.srv.board.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tp06.vue.bk.srv.board.domain.BoardDto;
import tp06.vue.bk.srv.board.persistence.BoardMapper;
import tp06.vue.bk.srv.login.domain.UserDto;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardMapper boardMapper;
	
	@Override
	public List<LinkedHashMap<String, Object>> getBoards(UserDto userDto) {
		List<LinkedHashMap<String, Object>> res = boardMapper.selectBoards(userDto);
		return res;
	}
	 
}

package tp06.vue.bk.srv.board.persistence;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import tp06.vue.bk.srv.login.domain.UserDto;

@Mapper
public interface BoardMapper {
	
	@Select("SELECT * FROM boards")
	public List<LinkedHashMap<String, Object>> selectBoards(UserDto userDto);
}

package tp06.vue.bk.srv.board.web;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tp06.vue.bk.srv.board.domain.BoardDto;
import tp06.vue.bk.srv.board.service.BoardService;
import tp06.vue.bk.srv.common.ApiResponse;
import tp06.vue.bk.srv.login.domain.UserDto;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/board")
	public ResponseEntity<ApiResponse> getBoards(@RequestParam("usr_no") int usr_no, @RequestParam("usr_id") String usr_id,
			HttpServletRequest request, HttpServletResponse response) {
		UserDto userDto = new UserDto();
		userDto.setUsr_no(usr_no);
		userDto.setUsr_id(usr_id);
		List<LinkedHashMap<String, Object>> res = boardService.getBoards(userDto);
		ApiResponse apiResponse = new ApiResponse("success", 200, "로그인 성공", res);
		return ResponseEntity.ok(apiResponse);
	}
	
	
	/*
	@GetMapping("/board/${bd_no}")
	public ResponseEntity<ApiResponse> getBoard(HttpServletRequest request, HttpServletResponse response) {
		UserDto userDto = new UserDto();
		List<LinkedHashMap<String, Object>> resArr = boardService.getBoard(userDto);
		
		boolean isAuthenticated = resArr[0].size() > 0;
		
		if(isAuthenticated) {
			ApiResponse apiResponse = new ApiResponse("success", 200, "회원가입 성공", res);
			System.out.println("apiResponse = "+apiResponse);
			return ResponseEntity.ok(apiResponse);
		} else {
			ApiResponse apiResponse = new ApiResponse("failure", 400, "회원가입 실패", null);
			System.out.println("apiResponse = " + apiResponse);
			return ResponseEntity.ok(apiResponse);
		}
		
	}
	*/
	
}

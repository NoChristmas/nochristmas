package tp06.vue.bk.srv.login.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tp06.vue.bk.srv.common.ApiResponse;
import tp06.vue.bk.srv.login.domain.UserDto;
import tp06.vue.bk.srv.login.service.UserLoginService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class LoginController {
	
	private final UserLoginService userLoginService;
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponse> login(@RequestBody UserDto userDto, HttpServletRequest request, HttpServletResponse response) {
		boolean isAuthenticated = userLoginService.authenticateUser(userDto);
		if(isAuthenticated) {
			ApiResponse apiResponse = new ApiResponse("success", 200, "로그인 성공", null);
			return ResponseEntity.ok(apiResponse);
		} else {
			ApiResponse apiResponse = new ApiResponse("failure", 400, "로그인 실패", null);
			return ResponseEntity.badRequest().body(apiResponse);
		}
		
	}
}

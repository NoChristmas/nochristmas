package tp06.vue.bk.srv.login.web;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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
		System.out.println("login Controller");
		
		List<LinkedHashMap<String, Object>> res = userLoginService.findUser(userDto);
		
		boolean isAuthenticated = res.size() > 0;
		System.out.println("res isAuth = " + isAuthenticated);
		if(isAuthenticated) {
			ApiResponse apiResponse = new ApiResponse("success", 200, "로그인 성공", res);
			System.out.println("apiResponse = "+apiResponse);
			return ResponseEntity.ok(apiResponse);
		} else {
			ApiResponse apiResponse = new ApiResponse("failure", 400, "로그인 실패", null);
			System.out.println("apiResponse = " + apiResponse);
			return ResponseEntity.ok(apiResponse);
		}
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<ApiResponse> register(@RequestBody UserDto userDto, HttpServletRequest request, HttpServletResponse response) {
		List<LinkedHashMap<String, Object>> res = userLoginService.registUser(userDto);
		
		boolean isAuthenticated = res.size() > 0;
		
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
}

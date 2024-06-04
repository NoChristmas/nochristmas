package tp06.vue.bk.srv.login.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tp06.vue.bk.srv.login.domain.UserDto;
import tp06.vue.bk.srv.login.service.UserLoginService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class LoginController {
	
	private final UserLoginService userLoginService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserDto userDto) {
		boolean isAuthenticated = userLoginService.authenticateUser(userDto);
		if(isAuthenticated) {
			return ResponseEntity.ok("로그인 성공");
		} else {
			return ResponseEntity.badRequest().body("로그인실패");
		}
		
	}
}

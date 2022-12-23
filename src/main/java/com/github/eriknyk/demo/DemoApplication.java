package com.github.eriknyk.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	@GetMapping("/user")
	public LocalResponse getUser(HttpServletRequest request) {
		var response = new LocalResponse();
		// check AppInterceptor.preHandle() to see when "is_authorized" attribute is set
		response.setAuthorized((boolean) request.getAttribute("is_authorized"));

		if (response.isAuthorized()) {
			response.setUserId("1111");
		}

		return response;
	}

	@GetMapping("/profile")
	public LocalResponse getProfile(HttpServletRequest request) {
		var response = new LocalResponse();
		// check AppInterceptor.preHandle() to see when "is_authorized" attribute is set
		response.setAuthorized((boolean) request.getAttribute("is_authorized"));

		if (response.isAuthorized()) {
			response.setUserId("1111-22222");
		}

		return response;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

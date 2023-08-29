package com.marolix.Bricks99.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppInfo {
	@GetMapping(value = "/welcome")
	public String welocome() {
		return "Welcome to Bricks99";
	}
}

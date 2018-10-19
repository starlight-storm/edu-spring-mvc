package sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@GetMapping("/")
	public String home() {
		return "input_user";
	}

	@PostMapping("/input")
	public String inputNameByPost(@RequestParam String name) {
		System.out.println("***" + name);
		return "input_user";
	}

}

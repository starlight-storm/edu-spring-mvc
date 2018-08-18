package sample.springmvc.app;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = "/")
	public String home(Model model) {
		Date date = new Date();
		model.addAttribute("serverTime", date);
		return "home";
	}
}
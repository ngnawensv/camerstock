package cm.belrose.camerstock.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	@RequestMapping(value = "/")
	private String home() {
		
		return "home/home";
	}
	
	@RequestMapping(value = "/blank")
	public String blankHome() {
		
		return "blank/blank";
	}

}

package com.spring.udong;


import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



public class HomeController {
	
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "main";
	}
	
}

package com.spring.udong.club.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("ClubController")
public class ClubControllerImpl {
	
	@RequestMapping(value="/club/main", method=RequestMethod.GET)
		public String main(Locale locale, Model model) {
			return"clubMain";
		}
	
	

}

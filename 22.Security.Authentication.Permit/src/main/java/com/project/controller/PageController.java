package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String home() {
		return "/HomePage";
	}
	
	@RequestMapping(value = "/welcome",method = RequestMethod.GET)
	public String welcome() {
		return "/WelcomePage";
	}
}

package com.yhb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
	
   @RequestMapping(value="/index1") 
	public String index() {
		return "index";
	}
}

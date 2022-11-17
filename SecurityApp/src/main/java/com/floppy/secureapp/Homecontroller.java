package com.floppy.secureapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Homecontroller {
@RequestMapping("/")
public String Home()
{
	return "index.jsp";
}
}

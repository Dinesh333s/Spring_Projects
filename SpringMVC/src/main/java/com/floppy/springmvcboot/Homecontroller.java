package com.floppy.springmvcboot;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Homecontroller {
    
	@RequestMapping("/") // it's used map webrequest onto the handler method or handler class
	public String Home()
	{
//		System.out.println("Home page Requested");
		return "index";
	}
	
	@RequestMapping("add")
	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j,ModelMap m)//HttpSession session we removed that session here 
//	public String add(HttpServletRequest req)
	{
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));		
//		ModelAndView mv = new ModelAndView(); combine both model and view		
//		ModelAndView mv = new ModelAndView("result"); also we can pass view as a construtor parameter 	
//		mv.setViewName("result");
//		HttpSession session = req.getSession();
//		mv.addObject("num3",num3);
		
		int num3 = i + j;
		m.addAttribute("num3",num3);
//		session.setAttribute("num3", num3);
		return "result";     
	}
	
	
}

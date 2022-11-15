package com.floppy.springmvcboot;

import java.lang.reflect.Array;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.floppy.springmvcboot.model.Alien;

@Controller
public class Homecontroller implements ErrorController {

	@Autowired
	Alienrepo repo;

	@ModelAttribute
	public void Modeldata(Model m) {
		m.addAttribute("name", "Dinesh");
	}

	@RequestMapping("/") // it's used map webrequest onto the handler method or handler class
	public String Home() {
//		System.out.println("Home page Requested");
		return "index";
	}

	@RequestMapping("add")
	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, ModelMap m)// HttpSession session we
																							// removed that session here
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
		m.addAttribute("num3", num3);
//		session.setAttribute("num3", num3);
		return "result";
	}

	@GetMapping("showalien")
	public String showalien(Model m) {
		List<Alien> alien = Arrays.asList(new Alien(101, "Dinesh"), new Alien(102, "Human"));

//		m.addAttribute("alien", alien); //Model map
		m.addAttribute("result", repo.findAll());
		return "showalien";
	}

	@GetMapping("showaliens")
	public String showaliens(@RequestParam(value = "aid", required = false) Integer aid, Model m) {

//		m.addAttribute("alien", alien); //Model map
//		m.addAttribute("result", repo.getOne(aid));
		m.addAttribute("result", repo.findById(aid));
		return "showalien";
	}
	
	@GetMapping("findByName")
	public String findByName(@RequestParam String aname, Model m) {

//        m.addAttribute("result",((Alienrepo) repo).findByAname(aname));
//        m.addAttribute("result",repo.findByAnameOrderByAname(aname));
//        m.addAttribute("result",repo.findByAnameOrderByAidDesc(aname));
		  m.addAttribute("result", repo.find(aname));
		return "showalien";
	}
 
//	@RequestMapping(value = "addalien", method=RequestMethod.POST) 1 way
	@PostMapping("addalien") // 2nd way
//	public String addalien(@RequestParam("aid") int aid,@RequestParam("aname") String aname,Model m) {
	public String addalien(@ModelAttribute Alien a) // it'll bind the data with a pojo bean
//		public String addalien(Alien a) 
	{
//		Alien a = new Alien();
//		a.setAid(aid);
//		a.setAname(aname);
//	    m.addAttribute("Alien", a);	
		repo.save(a);
		return "result";
	}

}

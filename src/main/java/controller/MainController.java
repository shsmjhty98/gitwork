package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.PhonebookService;
import vo.PhonebookVO;

@Controller
public class MainController {
	
	ApplicationContext app=new ClassPathXmlApplicationContext("scheduled/setting.xml");
	
	@Autowired
	PhonebookService service;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("list", service.findAll());
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/insert")
	public ModelAndView insert(String name, String hp, String memo) {
		int result=service.insert(new PhonebookVO(name, hp, memo));
		ModelAndView mv=new ModelAndView();
		mv.addObject("list", service.findAll());
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/findAll")
	public ModelAndView findAll() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("list", service.findAll());
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/findOne")
	public ModelAndView findone(int idx) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("list", service.findAll());
		mv.addObject("pb", service.findOneById(idx));
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/searchfind")
	public ModelAndView searchfind(String search) {
		ModelAndView mv = new ModelAndView();
		if (search != null) {
			mv.addObject("search", service.searchFind(search));
		}else {
			mv.addObject("search", service.searchFind(""));
		}
		mv.setViewName("view");
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(int idx, PhonebookVO pb) {
		ModelAndView mv=new ModelAndView();
		int result=service.insert(new PhonebookVO());
		mv.addObject("list", service.findAll());
		mv.setViewName("index");
		return mv;
		
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public ModelAndView delete(int idx) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("list", service.findAll());
		mv.setViewName("index");
		return mv;
	}
}
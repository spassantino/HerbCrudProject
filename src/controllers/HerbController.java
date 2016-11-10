package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import herbs.HerbDAO;
import herbs.Herb;

@Controller
@SessionAttributes({ "currentHerb", "herb" })
public class HerbController {
	@Autowired
	private HerbDAO herbdao;

	@ModelAttribute("currentHerb")
	  public List<Herb> initSessionObject() {
	    List<Herb> list = herbdao.getHerbs();
	    return list;
	  }	
	@ModelAttribute("herb")
	public Herb initState() {
		return new Herb();
	}	
	@RequestMapping("previous.do")
	public ModelAndView previous(@ModelAttribute("currentHerb") List<Herb> herbList,
			@ModelAttribute("herb") Herb herb) {
		System.out.println(herbList.size());
		ModelAndView mv = new ModelAndView();
		int index = herbList.indexOf(herb);
		System.out.println(index);
		mv.setViewName("result.jsp");
		if(index == 0){
			System.out.println(herb);
			herb = herbList.get(herbList.size()-1);
			System.out.println(herb);
		}
		else {
			herb = herbList.get(index-1);
		}
		mv.addObject("herb", herb);
		System.out.println(herb.getCommonName());
		return mv;
	}
	@RequestMapping("next.do")
	public ModelAndView next(@ModelAttribute("currentHerb") List<Herb> herbList,
			@ModelAttribute("herb") Herb herb) {
		ModelAndView mv = new ModelAndView();
		int index = herbList.indexOf(herb);
		mv.setViewName("result.jsp");
		 if(index < herbList.size()-1){
			herb = herbList.get(index+1);
			System.out.println(herbList.size());		
		}
		else {
			herb = herbList.get(0);
		}
		mv.addObject("herb", herb);
		return mv;
	}
	@RequestMapping(path = "GetHerbData.do", params = "commonName", method = RequestMethod.GET)
	public ModelAndView getByCommonName(@RequestParam("commonName") String n, @ModelAttribute("herb") Herb herb) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("herb", herbdao.getHerbByCommonName(n));
		return mv;
	}
	@RequestMapping(path = "GetHerbData.do", params = "scientificName", method = RequestMethod.GET)
	public ModelAndView getByScientificName(@RequestParam("scientificName") String a,@ModelAttribute("state") Herb herb) {
		ModelAndView mv = new ModelAndView();
		herb = herbdao.getHerbByScientificName(a);
		mv.setViewName("result.jsp");
		mv.addObject("herb", herb);
		return mv;
	}
	@RequestMapping(path = "NewHerb.do", method = RequestMethod.POST)
	public ModelAndView newHerb(Herb herb) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("herb", herb);
		return mv;
	}
}


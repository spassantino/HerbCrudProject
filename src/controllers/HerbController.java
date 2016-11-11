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
	public Herb initHerb() {
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
		else if(index == -1){
			herb = herbList.get(0);
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
	@RequestMapping(path = "GetHerbData.do", params = "cn", method = RequestMethod.GET)
	public ModelAndView getByCommonName(@RequestParam("cn") String n,@ModelAttribute("herb") Herb herb) {
		ModelAndView mv = new ModelAndView();
		System.out.println("first: " + n);
		mv.setViewName("result.jsp");
		for(Herb h: herbdao.getHerbs()){
			System.out.println(h.getCommonName());
		}
//		System.out.println("second: " + herbdao.getHerbByCommonName(n).getCommonName());
		mv.addObject("herb", herbdao.getHerbByCommonName(n));
		return mv;
	}
	@RequestMapping(path = "GetHerbData.do", params = "scientificName", method = RequestMethod.GET)
	public ModelAndView getByScientificName(@RequestParam("scientificName") String a,@ModelAttribute("herb") Herb herb) {
		ModelAndView mv = new ModelAndView();
		herb = herbdao.getHerbByScientificName(a);
		mv.setViewName("result.jsp");
		mv.addObject("herb", herbdao.getHerbByScientificName(a));
		return mv;
	}
	@RequestMapping(path = "NewHerb.do", method = RequestMethod.POST)
	public ModelAndView newHerb(Herb herb) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("newResult.jsp");
		mv.addObject("herb", herb);
		herbdao.addHerb(herb);
		return mv;
	}
	@RequestMapping(path = "DeleteHerb.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteHerb(@RequestParam("commonName") String n, @ModelAttribute("herb") Herb herb) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("herb", herbdao.getHerbByCommonName(n));
		herbdao.deleteHerb(n);
		return mv;
	}
	@RequestMapping(path = "UpdateHerb.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateHerb(@RequestParam("commonName") String n, @ModelAttribute("herb") Herb herb) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		herbdao.updateHerb(n);
		mv.addObject("herb", herbdao.getHerbByCommonName(n));
		System.out.println(herb);
		return mv;
	}
}


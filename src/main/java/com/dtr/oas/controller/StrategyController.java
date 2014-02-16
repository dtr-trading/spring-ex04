package com.dtr.oas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dtr.oas.model.Strategy;
import com.dtr.oas.service.StrategyService;

@Controller
@RequestMapping(value="/strategy")
public class StrategyController {

	@Autowired
	private StrategyService strategyService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addStrategyPage() {
		ModelAndView modelAndView = new ModelAndView("strategy-add");
		modelAndView.addObject("strategy", new Strategy());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingStrategy(@ModelAttribute Strategy strategy) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		strategyService.addStrategy(strategy);
		
		String message = "Strategy was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfStrategies() {
		ModelAndView modelAndView = new ModelAndView("strategy-list");
		
		List<Strategy> strategies = strategyService.getStrategies();
		modelAndView.addObject("strategies", strategies);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editStrategyPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("strategy-edit");
		Strategy strategy = strategyService.getStrategy(id);
		modelAndView.addObject("strategy",strategy);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingStrategy(@ModelAttribute Strategy strategy, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		strategyService.updateStrategy(strategy);
		
		String message = "Strategy was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteStrategy(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		strategyService.deleteStrategy(id);
		String message = "Strategy was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}

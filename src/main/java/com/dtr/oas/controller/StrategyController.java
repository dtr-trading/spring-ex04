package com.dtr.oas.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dtr.oas.dto.StrategyDTO;
import com.dtr.oas.dto.StrategyMapper;
import com.dtr.oas.model.Strategy;
import com.dtr.oas.service.StrategyService;

@Controller
@RequestMapping(value="/strategy")
public class StrategyController {
	static Logger logger = LoggerFactory.getLogger(StrategyController.class);

	@Autowired
	private StrategyService strategyService;

	@RequestMapping(value="/list",  method=RequestMethod.GET)
	public ModelAndView listOfStrategies() {
		StrategyDTO strategyDTO = new StrategyDTO();
		ModelAndView modelAndView = new ModelAndView("strategy-list");
		List<Strategy> strategies = strategyService.getStrategies();
		modelAndView.addObject("strategies", strategies);
		modelAndView.addObject("strategyDTO", strategyDTO);
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingStrategy(@ModelAttribute StrategyDTO strategyDTO) {
		ModelAndView modelAndView = new ModelAndView("redirect:/strategy/list");
		Strategy strategy = StrategyMapper.getStrategy(strategyDTO);
		strategyService.addStrategy(strategy);
		String message = "Strategy " + strategy.getId() + " was successfully added";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView editStrategyPage(@RequestParam(value="id", required=true) Integer id) {
		ModelAndView modelAndView = new ModelAndView("strategy-edit");
		logger.info("Strategy/edit-GET:  ID to query = " + id);
		Strategy strategy = strategyService.getStrategy(id);
		logger.info("Strategy/edit-GET:  " + strategy.getString());
		StrategyDTO strategyDTO = new StrategyDTO();
		strategyDTO.setId(strategy.getId());
		strategyDTO.setName(strategy.getName());
		strategyDTO.setType(strategy.getType());
		logger.info("Strategy/edit-GET:  " + strategyDTO.getString());
		modelAndView.addObject("strategyDTO",strategyDTO);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public ModelAndView editingStrategy(@ModelAttribute StrategyDTO strategyDTO, 
			@RequestParam(value="action", required=true) String action) {

		ModelAndView modelAndView = new ModelAndView("redirect:/strategy/list");
		String message = null;
		
		if (action.equals("save")) {
			Strategy strategy = StrategyMapper.getStrategy(strategyDTO);
			logger.info("Strategy/edit-POST:  " + strategyDTO.getString());
			strategyService.updateStrategy(strategy);
			message = "Strategy " + strategy.getId() + " was successfully edited";
			modelAndView.addObject("message", message);			
		}
		
		if (action.equals("cancel")) {
			message = "Strategy " + strategyDTO.getId() + " edit cancelled";
		}
		
		return modelAndView;
		
	}

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView deleteStrategyPage(@RequestParam(value="id", required=true) Integer id, 
			@RequestParam(value="phase", required=true) String phase) {
		
		Strategy strategy = strategyService.getStrategy(id);
		logger.info("Strategy/delete-GET | id = " + id + " | phase = " + phase + " | " + strategy.getString());
		ModelAndView modelAndView = null;

		if (phase.equals("stage")) {
			modelAndView = new ModelAndView("strategy-delete");
			
			StrategyDTO strategyDTO = new StrategyDTO();
			strategyDTO.setId(strategy.getId());
			strategyDTO.setName(strategy.getName());
			strategyDTO.setType(strategy.getType());
			modelAndView.addObject("strategyDTO",strategyDTO);

			String message = "Strategy " + strategy.getId() + " queued for display.";
			modelAndView.addObject("message", message);
		}
		
		if (phase.equals("confirm")) {
			modelAndView = new ModelAndView("redirect:/strategy/list");
			strategyService.deleteStrategy(id);
			String message = "Strategy " + strategy.getId() + " was successfully deleted";
			modelAndView.addObject("message", message);
		}
		
		if (phase.equals("cancel")) {
			modelAndView = new ModelAndView("redirect:/strategy/list");
			String message = "Strategy delete was cancelled.";
			modelAndView.addObject("message", message);
		}
		
		return modelAndView;
	}
}

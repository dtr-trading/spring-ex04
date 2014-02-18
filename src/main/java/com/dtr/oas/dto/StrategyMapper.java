package com.dtr.oas.dto;

import com.dtr.oas.model.Strategy;

public class StrategyMapper {

	public static Strategy getStrategy(StrategyDTO dto) {
		Strategy strategy = new Strategy();
		strategy.setId(dto.getId());
		strategy.setName(dto.getName());
		strategy.setType(dto.getType());
		return strategy;
	}
	
	public static StrategyDTO getDTO(Strategy strategy) {
		StrategyDTO dto = new StrategyDTO();
		dto.setId(strategy.getId());
		dto.setName(strategy.getName());
		dto.setType(strategy.getType());
		return dto;
	}
}
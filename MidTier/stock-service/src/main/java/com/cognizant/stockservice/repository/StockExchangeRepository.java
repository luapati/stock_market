package com.cognizant.stockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.stockservice.bean.StockExchange;

public interface StockExchangeRepository extends JpaRepository<StockExchange, Integer> {

	 StockExchange findByStockExchange(String stockExchange);

}

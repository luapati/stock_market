package com.cognizant.stockservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.stockservice.bean.Company;
import com.cognizant.stockservice.bean.StockExchange;
import com.cognizant.stockservice.service.ManageService;

@RestController
@RequestMapping("/manage")
public class ManageController {
	@Autowired
	private ManageService manageService;

	@GetMapping("/companies")
	public List<Company> getCompanies() {
		return manageService.getCompanies();
	}
	
	@GetMapping("/exchanges")
	public List<StockExchange> getStockExchanges() {
		return manageService.getStockExchanges();
	}
	@PostMapping("/addcompany")
	public Company addCompanies(@RequestBody Company company) {
		return manageService.addCompany(company);
	}
	@PostMapping("/addExchange")
	public StockExchange addStockExchange(@RequestBody StockExchange stockExchange) {
		return manageService.addStockExchange(stockExchange);
	}
}

package com.cognizant.stockservice.service;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.stockservice.bean.Company;
import com.cognizant.stockservice.bean.StockExchange;
import com.cognizant.stockservice.repository.CompanyRepository;
import com.cognizant.stockservice.repository.StockExchangeRepository;

@Service
public class ManageService {
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	StockExchangeRepository stockExchangeRepository;

	public List<Company> getCompanies() {
		return companyRepository.findAll();
	}

	public List<StockExchange> getStockExchanges() {
		return stockExchangeRepository.findAll();
	}

	public Company addCompany(Company company) {
//		JSONParser parser = new JSONParser();
//		JSONObject json = null;
//		try {
//			json = (JSONObject) parser.parse(company);
//		} catch (org.json.simple.parser.ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		company.setId(company.getId());
		company.setActive(true);
		company.setBriefWriteup(company.getBriefWriteup());
		company.setCeo(company.getCeo());
		company.setName(company.getName());
		company.setStockCode(company.getStockCode());
		company.setTurnOver(company.getTurnOver());
		company.setBoardOfDirectors("Empty");
		return companyRepository.save(company);
	}
	public StockExchange addStockExchange (StockExchange stockExchange) {
		stockExchange.setId(stockExchange.getId());
		stockExchange.setStockExchange(stockExchange.getStockExchange());
		stockExchange.setBrief(stockExchange.getBrief());
		stockExchange.setContactAddress(stockExchange.getContactAddress());
		stockExchange.setRemarks(stockExchange.getRemarks());
		stockExchange.setActive(true); 
		return stockExchangeRepository.save(stockExchange);
	} 
}

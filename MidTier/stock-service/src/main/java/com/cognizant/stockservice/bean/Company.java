package com.cognizant.stockservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "company")
public class Company {

	@Id
	@Column(name = "co_id")
	@NotNull
	private long id;
	@NotNull
	@NotEmpty
	@Column(name="co_name")
	private String name;
	@NotNull
	@Column(name = "co_turnover")
	private long turnOver;
	@Column(name = "co_ceo")
	@NotNull
	private String ceo;
	@NotNull
	@Column(name="co_board_of_directors")
	private String boardOfDirectors;
	@NotNull
	@Column(name = "co_brief_writeup")
	private String briefWriteup;
	@Column(name="co_active")
	private boolean active;
	@NotNull
	@Column(name="co_stock_code")
	private long stockCode;
	
	
//	public Company(@NotNull long id, @NotNull @NotEmpty String name, @NotNull long turnOver, @NotNull String ceo,
//			@NotNull String boardOfDirectors, @NotNull String briefWriteup, boolean active, @NotNull long stockCode) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.turnOver = turnOver;
//		this.ceo = ceo;
//		this.boardOfDirectors = boardOfDirectors;
//		this.briefWriteup = briefWriteup;
//		this.active = active;
//		this.stockCode = stockCode;
//	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTurnOver() {
		return turnOver;
	}
	public void setTurnOver(long turnOver) {
		this.turnOver = turnOver;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}
	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}
	public String getBriefWriteup() {
		return briefWriteup;
	}
	public void setBriefWriteup(String briefWriteup) {
		this.briefWriteup = briefWriteup;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public long getStockCode() {
		return stockCode;
	}
	public void setStockCode(long stockCode) {
		this.stockCode = stockCode;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", turnOver=" + turnOver + ", ceo=" + ceo
				+ ", boardOfDirectors=" + boardOfDirectors + ", briefWriteup=" + briefWriteup + ", active=" + active
				+ ", stockCode=" + stockCode + "]";
	}

}

package com.ctg.ctginventory;

public class Ticket {
	private String solution;
	private String ticketNum;
	private String title;
	private Asset asset;
	private User impactedPerson;
	private User responsible;
	private String description;
	private String state;
	
	
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public String getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	public User getImpactedPerson() {
		return impactedPerson;
	}
	public void setImpactedPerson(User impactedPerson) {
		this.impactedPerson = impactedPerson;
	}
	public User getResponsible() {
		return responsible;
	}
	public void setResponsible(User responsible) {
		this.responsible = responsible;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}

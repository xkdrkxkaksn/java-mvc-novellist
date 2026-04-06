package com.kh.novel.model.dto;

public class NovelListDto {
	private String title;
	private String author;
	private String country;
	private int publication;
	
	public NovelListDto() {
	}

	public NovelListDto(String title, String author, String country, int publication) {
		this.title = title;
		this.author = author;
		this.country = country;
		this.publication = publication;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPublication() {
		return publication;
	}

	public void setPublication(int publication) {
		this.publication = publication;
	}

	
	
	
	

}

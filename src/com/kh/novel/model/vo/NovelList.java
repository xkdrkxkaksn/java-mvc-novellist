package com.kh.novel.model.vo;

import java.util.Objects;

public class NovelList {
	private int id;
	private String Title;
	private String Author;
	private String Country;
	private int Publication;
	public NovelList(int id, String title, String author, String country, int publication) {
		super();
		this.id = id;
		Title = title;
		Author = author;
		Country = country;
		Publication = publication;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public int getPublication() {
		return Publication;
	}
	public void setPublication(int publication) {
		Publication = publication;
	}
	
	@Override
	public String toString() {
		return "NovelList [id=" + id + ", Title=" + Title + ", Author=" + Author + ", Country=" + Country + ", Date="
				+ Publication + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Author, Country, Publication, Title, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NovelList other = (NovelList) obj;
		return Objects.equals(Author, other.Author) && Objects.equals(Country, other.Country) && Publication == other.Publication
				&& Objects.equals(Title, other.Title) && id == other.id;
	}

	
}
	
	
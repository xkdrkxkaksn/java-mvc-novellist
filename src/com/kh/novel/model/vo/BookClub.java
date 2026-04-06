package com.kh.novel.model.vo;

public class BookClub {
	private int bookClubNo;
	private String bookClubTitle;
	private String bookClubContent;
	private String bookClubWriter;
	private String date;
	
	public BookClub() {}

	public BookClub(int bookClubNo, String bookClubTitle, String bookClubContent, String bookClubWriter, String date) {
		this.bookClubNo = bookClubNo;
		this.bookClubTitle = bookClubTitle;
		this.bookClubContent = bookClubContent;
		this.bookClubWriter = bookClubWriter;
		this.date = date;
	}

	public int getBookClubNo() {
		return bookClubNo;
	}

	public void setBookClubNo(int bookClubNo) {
		this.bookClubNo = bookClubNo;
	}

	public String getBookClubTitle() {
		return bookClubTitle;
	}

	public void setBookClubTitle(String bookClubTitle) {
		this.bookClubTitle = bookClubTitle;
	}

	public String getBookClubContent() {
		return bookClubContent;
	}

	public void setBookClubContent(String bookClubContent) {
		this.bookClubContent = bookClubContent;
	}

	public String getBookClubWriter() {
		return bookClubWriter;
	}

	public void setBookClubWriter(String bookClubWriter) {
		this.bookClubWriter = bookClubWriter;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}

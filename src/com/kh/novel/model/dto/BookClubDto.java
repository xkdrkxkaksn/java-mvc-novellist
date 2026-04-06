package com.kh.novel.model.dto;

public class BookClubDto {
	private int bookClubNo;
	private String bookClubTitle;
	private String bookClubContent;
	private String bookClubWriter;
	private String date;
	
	public BookClubDto() {}

	public BookClubDto(int bookClubNo, String bookClubTitle, String bookClubContent, String bookClubWriter,
			String date) {
		super();
		this.bookClubNo = bookClubNo;
		this.bookClubTitle = bookClubTitle;
		this.bookClubContent = bookClubContent;
		this.bookClubWriter = bookClubWriter;
		this.date = date;
	}

	public BookClubDto(String bookClubTitle, String bookClubContent, String bookClubWriter) {
		this.bookClubTitle = bookClubTitle;
		this.bookClubContent = bookClubContent;
		this.bookClubWriter = bookClubWriter;
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

	public String getBookClubWriter() {
		return bookClubWriter;
	}

	public void setBookClubWriter(String bookClubWriter) {
		this.bookClubWriter = bookClubWriter;
	}
}

	
package com.kh.novel.controller;

import java.util.List;

import com.kh.novel.model.service.BookClubService;
import com.kh.novel.model.vo.BookClub;

public class BookClubController {
	private BookClubService bcs = new BookClubService();
	
	public List<BookClub> selectAll() {
		List<BookClub> club = bcs.selectAll();
		return club;
	}
	
}
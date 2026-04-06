package com.kh.novel.model.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kh.novel.model.vo.BookClub;
import com.kh.novel.model.vo.NovelList;

public class BookClubService {
	
	private List<BookClub> club = new ArrayList();
	private int id;
	
	{
		club.add(new BookClub(++id, "첫 번째 게시글입니다", "시작이반!", "관리자",
				new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
		club.add(new BookClub(++id, "두 번째 게시글입니다", "2등이닷!", "관리자",
				new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
	}
	
	public List<BookClub> selectAll() {
		return club;
	}
	
	
	
}

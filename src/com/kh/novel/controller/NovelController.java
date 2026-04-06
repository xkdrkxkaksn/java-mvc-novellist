package com.kh.novel.controller;

import java.util.List;

import com.kh.novel.model.dto.NovelListDto;
import com.kh.novel.model.service.NovelService;
import com.kh.novel.model.vo.NovelList;

public class NovelController {
	private NovelService ns = new NovelService();
	
	public List<NovelList> selectAll() {
		List<NovelList> list = ns.selectAll();
		return list;
	}
	
	public NovelList addNovelList(NovelListDto nld) {
		return ns.addNovelList(nld);
	}
	
	public boolean findById(int id) {
		return ns.findById(id);
	}
	
	public void updateNovelList(int id, NovelListDto nld) {
		ns.updateNovelList(id, nld);
	}
	
	public String deleteNovelList(int id) {
		return ns.deleteNovelList(id);
	}
	
	public void outputNovelList() {
		ns.outputNovelList();
	}
	
	public List<NovelList> findByKeyword(String keyword) {
		return ns.findByKeyword(keyword);
	}
	
}

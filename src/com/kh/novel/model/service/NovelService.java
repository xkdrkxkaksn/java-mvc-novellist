package com.kh.novel.model.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.novel.model.dao.NovelListDao;
import com.kh.novel.model.dto.NovelListDto;
import com.kh.novel.model.vo.NovelList;

public class NovelService {
	private List<NovelList> list = new ArrayList();	
	private int id;
	
	{
		list.add(new NovelList(++id, "율리시스", "제임스 조이스", "아일랜드", 1922));
		list.add(new NovelList(++id, "소송", "프란츠 카프카", "오스트리아-헝가리 제국", 1925));
		list.add(new NovelList(++id, "댈러웨이 부인", "버지니아 울프", "영국", 1925));
		list.add(new NovelList(++id, "소리와 분노", "윌리엄 포크너", "미국", 1929));

	}
	
	public List<NovelList> selectAll() {
		return list;
	}
	
	private boolean validateNovelList(NovelListDto nld) {
		if(nld != null && nld.getTitle().length() >= 1) {			
			if(nld.getAuthor().length() >= 2) {
				if(nld.getCountry().length() > 1) {
					if(nld.getPublication() > 0);						
					return true;
				}
			}	
		}
		return false;
	}
	
	public NovelList addNovelList(NovelListDto nld) {
		if(validateNovelList(nld)) {
			list.add(new NovelList(++id, nld.getTitle(), nld.getAuthor(), nld.getCountry(), nld.getPublication()));
			
			return list.get(list.size() -1);
		}
		return null;
	}
	
	public boolean findById(int id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(0).getId() == id) {
			return true;
			}
		}
		return false;
	}
	
	private int indexOf(int id) {
		int index = -1;
		for(int i = 0; i < list.size(); i++) {	
			if(list.get(i).getId() == id) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public void updateNovelList(int id, NovelListDto nld) {
		int index = indexOf(id);
		
		boolean result = validateNovelList(nld);
		
		if(result) {
			list.set(index, new NovelList(id, nld.getTitle(), nld.getAuthor(), nld.getCountry(), nld.getPublication()));
		}
	}	
	
	public String deleteNovelList(int id) {
		int index = indexOf(id);
		if(index != -1) {
			return list.remove(index).getTitle();
		}
		return null;
	}
	
	public void outputNovelList() {
		new NovelListDao().outputNovelList(list);
	}
	
	public List<NovelList> findByKeyword(String keyword) {
	    List<NovelList> searched = new ArrayList<>();

	    for (NovelList nld : list) {

	        boolean result = true;
	        int num = 0;

	        try {
	            num = Integer.parseInt(keyword);
	        } catch (NumberFormatException e) {
	            result = false;
	        }

	        if (nld.getTitle().contains(keyword)
	                || nld.getAuthor().contains(keyword)
	                || nld.getCountry().contains(keyword)
	                || (result && nld.getPublication() == num)) {

	            searched.add(nld);
	        }
	    }
	    return searched;
	}
	
	
	
}

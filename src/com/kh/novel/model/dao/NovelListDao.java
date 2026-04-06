package com.kh.novel.model.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.kh.novel.model.vo.NovelList;

public class NovelListDao {

	public void outputNovelList(List<NovelList> list) {
		
		try(BufferedWriter wr = new BufferedWriter(new FileWriter("nld.txt"))) {
			wr.write("	[ 소설 목록 보기 ]	");
			wr.newLine();
			wr.newLine();
			wr.newLine();
			wr.newLine();
			wr.newLine();
			for(NovelList nld : list) {
				wr.write(nld.getId() + "번 : \t" + nld.getTitle()+ "\t" + nld.getAuthor()+ "\t" + nld.getCountry() + "\t" + nld.getPublication() + "년");
				wr.newLine();
			}
		} catch(IOException e) {
	}
}
	
	
	
	
}
		
		
		
	


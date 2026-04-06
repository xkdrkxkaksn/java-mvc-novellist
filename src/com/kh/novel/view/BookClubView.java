package com.kh.novel.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.novel.controller.BookClubController;
import com.kh.novel.model.vo.BookClub;

public class BookClubView {
	private BookClubController bcc = new BookClubController();
	Scanner sc = new Scanner(System.in);
	
	public void BookClubMenu() {
		while(true) {
		System.out.println();
		System.out.println("[ 북클럽에 오신 걸 환영합니다 ]");
		selectAll();
		System.out.println();
		System.out.println("1. 이야기 둘러보기");
		System.out.println("2. 이야기 작성하기");
		System.out.println("3. 이야기 수정하기");
		System.out.println("4. 이야기 삭제하기");
		System.out.println("5. 소설 목록 메뉴로 돌아가기");
		System.out.println("0. 프로그램 종료하기");
		System.out.println();
		System.out.println("원하시는 메뉴를 선택해주세요 > ");
		
		int menu = 0;
		try {
			menu = sc.nextInt();
			sc.nextLine();
		} catch(InputMismatchException e) {
			System.out.println("숫자만 입력해주세요 > ");
			sc.nextLine();
			continue;
		}
		
		switch(menu) {
		case 1 : selectAll(); break;
		case 2 : break;
		case 3 : break;
		case 4 : updateBookClubStroy(); break;
		case 5 : break;
		case 0 : System.out.println("프로그램을 종료합니다. 또 찾아주세요 :)"); sc.close(); return;
		default : System.out.println("없는 메뉴입니다. 다시 선택해주세요 > ");
		}
	}
}
	private void selectAll() {
		List<BookClub> club = bcc.selectAll();
		
		if(!club.isEmpty()) {
			System.out.println("⏬ 작가들의 이야기를 확인하세요 ⏬️");
			System.out.println();
			for(BookClub bc : club) {				
				System.out.println("[ 이야기 정보 ]");
				System.out.println("--------------------------");
				System.out.println("No : " + bc.getBookClubNo());
				System.out.println("--------------------------");
				System.out.println("제목 : " + bc.getBookClubTitle());
				System.out.println("--------------------------");
				System.out.println("내용 : " + bc.getBookClubContent());
				System.out.println("--------------------------");
				System.out.println("작가 : " + bc.getBookClubWriter());
				System.out.println("--------------------------");
				System.out.println("날짜 : " + bc.getDate());
				System.out.println("--------------------------");
				System.out.println();
			}
		} else {
			System.out.println("========================================================");
			System.out.println("아직 이야기가 존재하지 않습니다. 새로운 이야기를 등록해 작가가 되어보세요!");
			System.out.println("========================================================");
		}
	}
	
	private void updateBookClubStroy() {
		selectAll();
		
		System.out.println("📝 이야기 수정 시작합니다 📝️");
		System.out.println("어떤 이야기를 수정하시겠습니까?");
		System.out.println("수정하실 이야기 번호를 입력해주세요 > ");
		int clubNo = 0;
		try {
			clubNo = sc.nextInt();
			sc.nextLine();
		} catch(InputMismatchException e) {
			System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요 > ");
			sc.nextLine();
			return;
		}
	}
	
	
	
	
}

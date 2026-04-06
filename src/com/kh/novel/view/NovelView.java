package com.kh.novel.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.novel.controller.NovelController;
import com.kh.novel.model.dto.NovelListDto;
import com.kh.novel.model.vo.NovelList;

public class NovelView {
	private Scanner sc = new Scanner(System.in);
	private NovelController nc = new NovelController();
	private BookClubView bcv = new BookClubView();
	
	public void mainMenu() {
		while(true) {
			System.out.println();
			System.out.println("[ 소설 목록 관리 프로그램 ]");
			System.out.println();
			System.out.println("1. 소설 목록 전체 조회하기");
			System.out.println("2. 소설 목록 추가하기");
			System.out.println("3. 소설 정보 수정하기");
			System.out.println("4. 소설 목록 삭제하기");
			System.out.println("5. 소설 목록 파일로 출력하기");
			System.out.println("6. 소설 검색하기");
			System.out.println("7. 소사모 : 소설을 사랑하는 사람들 모임");
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
			case 2 : addNovelList(); break;
			case 3 : updateNovleList(); break;
			case 4 : deleteNovelList(); break;
			case 5 : nc.outputNovelList(); break;
			case 6 : findNovelList(); break;
			case 7 : bcv.BookClubMenu(); break;
			case 0 : System.out.println("프로그램을 종료합니다. 또 찾아주세요 :)"); sc.close(); return;
			default : System.out.println("없는 메뉴입니다. 다시 선택해주세요 > ");
			}
		}
	}
	
	private void selectAll() {
		List<NovelList> list = nc.selectAll();
		
		if(!list.isEmpty()) {
			System.out.println();
			System.out.println("⏬ 소설 정보를 확인하세요 ⏬️");
			System.out.println();
			for(NovelList nl : list) {				
				System.out.println("[ 소설 정보 ]");
				System.out.println("-----------------");
				System.out.println("ID : " + nl.getId());
				System.out.println("-----------------");
				System.out.println("제목 : " + nl.getTitle());
				System.out.println("-----------------");
				System.out.println("저자 : " + nl.getAuthor());
				System.out.println("-----------------");
				System.out.println("국적 : " + nl.getCountry());
				System.out.println("-----------------");
				System.out.println("발행년 : " + nl.getPublication());
				System.out.println("-----------------");
				System.out.println();
			}
		} else {
			System.out.println("================================================");
			System.out.println("아직 소설 목록이 존재하지 않습니다. 새로운 소설을 등록해보세요!");
			System.out.println("================================================");
		}
	}
	
	private void addNovelList() {
		System.out.println();
		System.out.println("️📚 소설 목록을 추가합니다 📚️");
		System.out.println();
		System.out.println("소설의 이름을 입력해주세요 > ");
		String title = sc.nextLine();
		System.out.println("소설의 저자를 입력해주세요 > ");
		String author = sc.nextLine();
		System.out.println("저자의 국적을 입력해주세요 > ");
		String country = sc.nextLine();
		System.out.println("소설의 발행 연도를 입력해주세요 > ");
		
		int publication = 0;
		try {
			publication = sc.nextInt();
			sc.nextLine();
		} catch(InputMismatchException e) {
			System.out.println("발행 연도는 숫자만 입력 가능합니다. 다시 입력해주세요 > ");
			sc.nextLine();
			return;
		}
		NovelList nl = nc.addNovelList(new NovelListDto(title, author, country, publication));
		
		if(nl != null) {
			selectAll();
			return;
		} else {
			System.out.println("소설 목록 등록에 실패했습니다 :(");
			System.out.println("관리자에게 문의해주세요!");
		}
		return;
	}
	
	private void updateNovleList() {
		selectAll();
		System.out.println();
		System.out.println("📚️ 소설 정보를 수정합니다 📚️");
		System.out.println("어떤 소설 정보를 수정하시겠습니까?");
		System.out.println("소설의 ID를 입력해주세요 > ");
		
		try {
			int id = Integer.parseInt(sc.nextLine());
			
			boolean result = nc.findById(id);
			
			if(!result) {
				System.out.println("존재하지 않은 ID입니다 :(");
				return;
			}
			
			System.out.println("변경하실 소설의 제목을 입력해주세요 > ");
			String title = sc.nextLine();
			System.out.println("변경하실 소설의 저자를 입력해주세요 > ");
			String author = sc.nextLine();
			System.out.println("변경하실 저자의 국적을 입력해주세요 > ");
			String country = sc.nextLine();
			System.out.println("변경하실 소설의 발행 년도를 입력해주세요 > ");
			int publication = Integer.parseInt(sc.nextLine());
			
			nc.updateNovelList(id, new NovelListDto(title, author, country, publication));
			
		} catch(NumberFormatException e) {
			System.out.println("입력하신 ID가 없습니다. 올바른 값을 입력해주세요 > ");
			sc.nextLine();
			return;
		}
	}
		
	private void deleteNovelList() {
		System.out.println();
		System.out.println("📚️️ 소설 목록을 삭제합니다 📚");
		System.out.println("어떤 소설 목록을 삭제하시겠습니까?");
		System.out.println("소설의 ID를 입력해주세요 > ");
		
		int id = 0;
		try {
			id = sc.nextInt();
			sc.nextLine();
		} catch(InputMismatchException e) {
			System.out.println("ID 숫자만 입력 가능합니다. 다시 입력해주세요 > ");
			sc.nextLine();
			return;
		}
		String result = nc.deleteNovelList(id);
		
		if(result != null) {
			System.out.println(result + "입력하신 ID의 소설 목록이 삭제됐습니다!");
		} else {
			System.out.println("입력하신 ID를 찾을 수 없습니다 :(");
		}
	}
	
	private void findNovelList() {
		System.out.println();
		System.out.println("📚️ 소설을 검색합니다 📚️");
		System.out.println("어떤 소설을 검색하시겠습니까?");
		System.out.println("찾고 싶은 소설의 키워드를 입력해주세요 > ");
		String keyword = sc.nextLine();
		List<NovelList> nlds = nc.findByKeyword(keyword);
		
		if(nlds.isEmpty()) {
			System.out.println("=========================");
			System.out.println("검색 결과가 존재하지 않습니다 :(");
			System.out.println("=========================");
		} else { 
			System.out.println();
			System.out.println("⏬ " + keyword + " 검색 결과 입니다 ⏬ ");
			for(NovelList nld : nlds) {
				System.out.println("제목 : " + nld.getTitle() + ", 저자 : " + nld.getAuthor() + ", 국적 : " + nld.getCountry() + ", 발행년 : " + nld.getPublication());
			}
			System.out.println();
		}
	}

}

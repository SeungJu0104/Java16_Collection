package com.collection.silsub2.view;

import com.collection.silsub2.controller.BookManager;
import com.collection.silsub2.model.vo.Book;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;

public class BookMenu {
	//필드 선언
	private Scanner sc = new Scanner (System.in);
	private BookManager bm = new BookManager();
	private Book b = new Book();
	
	//생성자
	public BookMenu () {}
	
	public void mainMenu () {
		
		while(true) {
			System.out.println("** 도서관리 프로그램 **");
			
			System.out.println("1. 새 도서 추가\n"
					+ "2. 도서정보 정렬 후 출력\n"
					+ "3. 도서 삭제\n"
					+ "4. 도서 검색 출력\n"
					+ "5. 전체 출력\n"
					+ "6. 끝내기\n");
			System.out.print("메뉴 번호 선택 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
			case 1:
				bm.addBook(inputBook());
				break;
				
			case 2:
				bm.printBook(bm.sortedBookList());
				break;
				
			case 3:
				b = bm.deleteBook(inputBookNo());
				if(b != null) {
					System.out.println("성공적으로 삭제");
				} else {
					System.out.println("삭제할 도서가 없습니다.");
				}
				break;
				
			case 4:
				String key = bm.searchBook(inputBookTitle());
				if(key.equals(null)) System.out.println("조회하신 도서는 존재하지 않습니다.");
				else System.out.println(bm.selectBook(key));
				break;
				
			case 5:
				if(bm.selectAll().size() == 0) System.out.println("보유 도서가 0권입니다.");
				else {
					Set k = bm.selectAll().keySet();
					Iterator it = k.iterator();
					
					while(it.hasNext()) {
						String ke = (String)it.next();
						b = bm.selectBook(ke);
						System.out.println(b);
					}
				}
				break;
			}
			if(num == 6) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
	
	public Book inputBook() {
		System.out.print("도서 제목 입력 : ");
		String title = sc.next();
		
		System.out.print("도서 장르 입력 (1. 인문 / 2. 자연과학 / 3. 의료 / 4.기타) : ");
		int category = sc.nextInt();
		
		System.out.print("도서 저자 입력 : ");
		String author = sc.next();
		
		sc.nextLine();
		
		return new Book(category, title, author);
	}
	
	public String inputBookNo () {
		System.out.print("조회할 도서 번호 입력 : ");
		String bNo = sc.nextLine();
		
		return bNo;
	}
	
	public String inputBookTitle() {
		System.out.print("조회할 도서명 입력 : ");
		String title = sc.nextLine();
		
		return title;
	}

}

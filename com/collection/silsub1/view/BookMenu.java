package com.collection.silsub1.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import com.collection.silsub1.controller.BookManager;
import com.collection.silsub1.model.vo.Book;

public class BookMenu {
	//필드 선언
	private BookManager bm = new BookManager();
	private Scanner scn = new Scanner(System.in);
	
	/*
	public static void main (String[] args) {
		BookMenu().mainMenu();
	}
	*/
	
	//생성자
	public BookMenu () {}
	
	public void mainMenu () {
		
		while(true) {
			System.out.println("** 도서 관리 프로그램 **");
			System.out.println("1. 새 도서 추가\n"
					+ "2. 도서정보 정렬 후 출력\n"
					+ "3. 도서 삭제\n"
					+ "4. 도서 검색 출력\n"
					+ "5. 전체 출력\n"
					+ "6. 끝내기\n");
			System.out.print("메뉴 번호 입력 : ");
			int num = scn.nextInt();
			scn.nextLine();
			
			switch(num) {
			case 1: 
				bm.addBook(inputBook());
				//inputBook 메소드로 도서관련 정보를 입력 받아 Book 객체로 저장한뒤,
				//BookManager 클래스의 addBook 메소드를 실행.
				break;
			case 2: 
				bm.printBookList(bm.sortedBookList());
				break;
			case 3: 
				int result = bm.deleteBook(inputBookNo());
				//inputBookNo 메소드를 실행해 BookManager 클래스의 deleteBook 메소드를 실행
				if(result == 0) {
					System.out.println("삭제할 도서가 존재하지 않습니다.");
				}
				else if(result == 1) {
					System.out.println("성공적으로 삭제");
				}
				break;
			case 4: 
				int index = bm.searchBook(inputBookTitle());
				//index가 -1이면 해당 제목의 책이 없다는 의미
				if(index == -1) {
					System.out.println("조회한 책이 없습니다.");
				}
				else {
					System.out.println(bm.selectBook(index));
				}
				break;
			case 5: 
				ArrayList <Book> list = bm.selectAll();
				//BookManager 클래스의 selectAll 메소드 실행해 리턴 받은 모든 객체들을 저장할 ArrayList를 하나 생성.
				//예외 발생을 if문으로 해결
				if(list.isEmpty()) {
					System.out.println("도서가 없습니다.");
				}
				else {
					//iterator 대신 for문 써도 상관없다.
					Iterator <Book> it = list.iterator();
					
					while(it.hasNext()) {
						System.out.print(it.next());
					}
				}
				break;
				
			case 6:
				System.out.println("프로그램을 종료합니다.");
				return;//void 리턴
			}
			
			//if(num == 6) break;
			
			System.out.println();
		}
		
	}
	
	//제목, 장르, 작가 입력받아서 Book 객체에 저장 후 리턴
	public Book inputBook() {
		
		System.out.print("도서 제목 : ");
		String title = scn.next();
		System.out.print("도서 장르 (1: 인문 / 2: 자연과학 / 3: 의료 / 4: 기타) : ");
		int category = scn.nextInt();
		System.out.print("도서 저자 : ");
		String author = scn.next();
		
		return new Book(category, title, author);
		//매개변수 생성자 이용해 Book 객체를 하나 생성하고 리턴준다.
		
	}
	
	//도서번호 받아 리턴
	public int inputBookNo() {
		System.out.print("삭제할 도서 번호 : ");
		int bookNo = scn.nextInt();
		scn.nextLine();
		return bookNo;
	}
	
	//도서제목 받아 리턴
	public String inputBookTitle() {
		System.out.print("조회할 도서 제목 : ");
		String bookTitle = scn.nextLine();
		
		return bookTitle;
	}

}

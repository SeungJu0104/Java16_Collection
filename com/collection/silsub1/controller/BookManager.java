package com.collection.silsub1.controller;

import java.util.ArrayList;
import java.util.Scanner;
import com.collection.silsub1.model.dao.BookDao;
import com.collection.silsub1.model.vo.Book;

public class BookManager {
	//필드 선언
	private BookDao bd = new BookDao();
	private Scanner scn = new Scanner(System.in);
	
	public BookManager () {}
	
	public void addBook(Book book) {
		//첫 입력할 때는 존재하는 인덱스가 없기 때문에 인덱스 범위 에러 발생한다.
		//if문으로 처리하는게 정석이지만(if문으로 하려면 BookDao 클래스에서 처리),
		//이번에는 try - catch 문으로 한번 해결해본다.
		//try - catch 문으로 예외 처리
		try {
			book.setBNo(bd.getLastBookNo()+1);			
		} catch (IndexOutOfBoundsException e) {
			book.setBNo(1);
			//인덱스를 하나 만들어줌으로써 인덱스 범위 에러 문제를 해결.
		}
		bd.addBook(book);
	}
	
	public int deleteBook(int no) {
		return bd.deleteBook(no);
		//BookDao 클래스의 deleteBook 메소드 실행한 결과 값을 받아 리턴 준다.
	}
	
	public int searchBook(String title) {
		return bd.searchBook(title);
	}
	
	public Book selectBook(int index) {
		return bd.selectBook(index);
	}
	public ArrayList <Book> selectAll () {
		return bd.selectAll();
		//BookDao 클래스의 selectAll 메소드 실행
	}
	
	public Book [] sortedBookList(){
		ArrayList <Book> list = bd.sortedBookList();
		//BookDao 클래스의 정렬한 ArrayList를 list에 저장한다.
		Book [] bk = new Book[list.size()];
		
		for(int i = 0; i < bk.length; i++) {
			bk[i] = list.get(i);
			//list의 i번째 인덱스 값을 꺼내 bk의 i번째 인덱스의 공간에 담는다.
		}
		
		return bk;
		//배열을 리턴해야하므로 Book 배열 bk를 리턴
	}
	
	public void printBookList(Book [] br) {
		for(Book tmp : br) {
			System.out.println(tmp);
		}
	}
	

}

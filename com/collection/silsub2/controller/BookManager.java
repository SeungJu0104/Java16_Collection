package com.collection.silsub2.controller;

import com.collection.silsub2.model.dao.BookDao;
import com.collection.silsub2.model.vo.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

public class BookManager {
	//필드 선언
	private BookDao bd = new BookDao();
	private Scanner sc = new Scanner(System.in);
	private Book book = new Book();
	
	//생성자
	public BookManager () {}
	
	//메소드
	public void addBook(Book book) {
		bd.addBook(book);
	}
	
	public Book deleteBook(String key) {
		return bd.deleteBook(key);
	}
	
	public String searchBook(String title) {
		return bd.searchBook(title);
	}
	
	public Book selectBook (String key) {
		return bd.selectBook(key);
	}
	
	public HashMap <String, Book> selectAll(){
		return bd.selectAll();
	}
	
	public Book [] sortedBookList() {
		ArrayList <Book> al = bd.sortedBookList();
		Book [] b = new Book [al.size()];
		
		for(int i = 0; i < b.length; i++) {
			b [i] = al.get(i);
		}
		return b;
	}
	
	public void printBook(Book [] br) {
		for(Book tmp : br) {
			System.out.println(tmp);
		}
	}
	
	

}

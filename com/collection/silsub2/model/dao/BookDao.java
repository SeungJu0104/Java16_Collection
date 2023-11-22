package com.collection.silsub2.model.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;


import com.collection.silsub2.model.vo.Book;

public class BookDao {
	//필드 선언
	private HashMap <String, Book> bookMap;
	
	//생성자
	public BookDao () {
		bookMap = new HashMap <String, Book> ();
	}
	
	public BookDao (HashMap <String, Book> map) {
		super();
		bookMap = map;
	}
	
	//메소드
	public int getLastBookNo() {
		int val = 0;
		//String key = null;
		Set<String> k = bookMap.keySet();
		Iterator<String> it = k.iterator();
		String tmp = null;
		
		//key값들을 배열에 담는다.
		String [] arr = new String [k.size()];
		for (int i = 0; it.hasNext(); i++) {
			arr[i] = it.next();
		}
		//String을 int로 바꿔 큰 순서대로 정렬한다.
		for(int i = 0; i < arr.length; i++) {
			val = 0;
			if(Integer.parseInt(arr[i]) > val) {
				val = Integer.parseInt(arr[i]);
			}
		}
		//제일 큰 수를 리턴한다.
		return val;
		
//		if(k.size() != 0) {
//			while(it.hasNext()) {
//				tmp = it.next().toString();
//			}
//			val = Integer.parseInt(tmp);
//			return val;
//		}else {
//			return val;
//		}
		
	}
	
	public void addBook(Book book) {
		int tmp = getLastBookNo();
		String t = String.valueOf(tmp + 1);
		book.setbNo(t);
		bookMap.put(t, book);
	}
	
	public Book deleteBook(String key) {
		
		Book book = null;
		book = bookMap.remove(key);
		return book;
		
	}
	
	public String searchBook(String title) {
		Object val = null;
		String key = null;
		Object tmp = null;
		
		Set es = bookMap.entrySet();
		Iterator it = es.iterator();
		
//		while(it.hasNext()) {
//			Map.Entry entry = (Map.Entry)it.next();
//			tmp = entry.getValue();
//			((Book)tmp).getTitle().contains(title);
//			if(temp.contains(title) == true) {
//				val = entry.getKey();
//				break;
//			}
//		}
		
		while(it.hasNext()) {
			Map.Entry<String, Book> entry = (Map.Entry)it.next();
			Book book = entry.getValue();
			if(book.getTitle().contains(title) == true) {
				 key = entry.getKey();
				 break;
			}
		}
		return key;
	}
	
	public Book selectBook(String key) {
		return bookMap.get(key);
	}
	
	public HashMap <String, Book> selectAll() {
		return bookMap;
	}
	
	public ArrayList <Book> sortedBookList() {
		Set<Map.Entry<String, Book>> es = bookMap.entrySet();
		Iterator<Map.Entry<String, Book>> it = es.iterator();
		ArrayList <Book> al = new ArrayList <Book> ();
		
		while(it.hasNext()) {
			Book en = it.next().getValue();
			al.add(en);
		}
		//list에 entry의 value가 담겨있다치고
		Collections.sort(al);
		return al;
	}
	

}

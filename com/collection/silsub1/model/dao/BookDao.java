package com.collection.silsub1.model.dao;

import java.util.ArrayList;
import com.collection.silsub1.model.vo.Book;
import com.collection.silsub1.model.comparator.AscCategory;

public class BookDao {
	
	private ArrayList <Book> bookList;
	
	public BookDao () {
		super();
		bookList = new ArrayList <Book> ();//bookList의 객체 생성
	}
	
	public BookDao(ArrayList <Book> bookList) {
		this.bookList = bookList;//전달받은 매개변수 bookList를 담아 bookList를 초기화
	}
	
	Book book = new Book();
	
	//마지막 도서 번호 리턴
	public int getLastBookNo() {
		return bookList.get(bookList.size()-1).getBNo();
		//get함수로 인덱스 위치 구한 후 그 인덱스의 도서번호를 갖고 오는 getter 함수 사용
		//첫 입력할 때는 존재하는 인덱스가 없기 때문에 인덱스 범위 에러 발생한다.
		//if문 쓰려면 여기서 사용해 에러가 발생하지 않도록 한다.
		/*
		 * if(bookList.size() == 0){
		 * 		return 0;
		 * }
		 * else {
		 * 		return bookList.get(bookList.size()-1).getBNo();
		 * }
		 */
	}
	
	//새로운 도서 추가
	public void addBook(Book book) {
		bookList.add(book);
	}
	
	//도서 삭제
	public int deleteBook(int no) {
		int result = 0;
		
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getBNo() == no) {
				bookList.remove(i);
				result = 1;
				//각 객체의 도서 번호 값을 하나씩 꺼내서 비교하되, 그 값이 매개변수 no와 동일하면 해당 인덱스의 도서 객체를 제거한다.
				//그리고 result 값을 1로 바꾼다.
			}
		}
		
		return result;
		//삭제 성공하면 1을 리턴. 실패하면 0을 리턴.
	}
	
	//해당 인덱스 값을 이용한 Book객체 리턴
	public Book selectBook(int index) {
		return bookList.get(index);
	}
	
	//도서 검색
	public int searchBook(String title) {
		int index = -1;
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getTitle().contains(title)) {
				//해당 인덱스의 제목을 가져와 매개변수의 title을 포함하고 있는지 확인
				//완전 일치하는 제목은 equals 메소드를 사용한다.
				index = i;
				//포함하고 있으면 그 인덱스 값을 index에 저장해 리턴 준다.
				//없으면 초기값 -1 그대로 리턴 준다.
				break;
			}
		}
		return index;
		//인덱스 리턴
		//return bookList.indexOf(bookList.contains(title));
	}
	
	//전체 출력
	public ArrayList <Book> selectAll(){
		return bookList;
	}
	
	//정렬 처리후 list 리턴
	public ArrayList <Book> sortedBookList(){
		bookList.sort(new AscCategory());
		return bookList;
	}

}

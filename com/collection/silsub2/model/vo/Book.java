package com.collection.silsub2.model.vo;

public class Book implements Comparable<Book> {
	//필드 선언
	private String bNo;
	private int category;
	private String title;
	private String author;
	
	//생성자
	public Book () {}
	
	public Book (int category, String title, String author) {
		super();
		this.category = category;
		this.title = title;
		this.author = author;
	}
	
	//getter 메소드
	public String getbNo () {
		return bNo;
	}
	
	public int getCategory () {
		return category;
	}
	
	public String getTitle () {
		return title;
	}
	
	public String author () {
		return author;
	}
	
	//setter 메소드
	public void setbNo (String bNo) {
		this.bNo = bNo;
	}
	
	public void setCategory (int category) {
		this.category = category;
	}
	
	public void setTitle (String title) {
		this.title = title;
	}
	
	public void setAuthor (String author) {
		this.author = author;
	}

	@Override
	public int compareTo(Book o) {
		String title = o.getTitle();
		return this.title.compareTo(title);
	}

	@Override
	public String toString() {
		String category = null;
		switch (this.category) {
		case 1:
			category = "인문";
			break;
		case 2:
			category = "자연과학";
			break;
		case 3:
			category = "의료";
			break;
		case 4:
			category = "기타";
			break;
		default:
			category = "미상";
			break;
		}
		return "bNo=" + bNo + ", category=" + category + ", title=" + title + ", author=" + author;
	}
	
	
	
	

}

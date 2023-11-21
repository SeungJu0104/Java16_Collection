package com.collection.silsub1.model.vo;

public class Book {
	//필드 선언
		private int bNo;
		private int category;
		private String title;
		private String author;
		
		//생성자
		public Book() {
			super();//매개변수 생성자를 쓰기위해서는 사전에 기본생성자 생성 필수!
		}
		public Book(int category, String title, String author) {
			super();//매개변수 생성자를 쓰기위해서는 사전에 기본생성자 생성 필수!
			this.category = category;
			this.title = title;
			this.author = author;
		}
		
		//getter 메소드
		public int getBNo () {
			return bNo;
		}
		
		public int getCategory () {
			return category;
		}
		
		public String getTitle () {
			return title;
		}
		
		public String getAuthor () {
			return author;
		}
		
		//setter 메소드
		public void setBNo (int bNo) {
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
		public String toString() {
			String scate = null;
			
			switch (category) {
			case 1: 
				scate = "인문";
				break;
				
			case 2:
				scate = "자연과학";
				break;
				
			case 3:
				scate = "의료";
				break;
				
			case 4:
				scate = "기타";
				break;
			}
			
			return "bNo= " + bNo + ", category = " + scate + ", title = " + title + ", author = " + author + "\n";
		}

}

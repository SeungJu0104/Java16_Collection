package com.collection.part04_genetics;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;


public class GenericsTest {
	/* Generics : 컬렉션에 저장되는 객체의 자료형에 제한을 거는 기능
	 * 한가지 종류의 객체만 저장할 수 있기 때문에 컬렉션에서 꺼내 사용할 때 형변환 작업을 생략할 수 있다.
	 */
	
	public static void main(String[] args) {
		GenericsTest gt = new GenericsTest();
		gt.test1();
	}
	
	
	public void test1() {
		List list = new ArrayList();
		
		//Collection은 모든 타입의 객체를 저장할 수 있다.
		//add는 Object타입을 이용해 모든 타입을 받는다.(다형성)
		list.add(new String("Object"));
		list.add(new Book());
		list.add(new Student());
		list.add(new Car());
		
		//저장된 객체를 꺼내 사용할 때
		//하나하나 instanceof 로 타입 비교하고 사용.
		for(int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			
			if(obj instanceof Book) {
				((Book)obj).printBook();
			}
			if(obj instanceof Student) {
				((Student)obj).score();
			}
		}
		
	}
	
	public void test2() {
		//Book 객체만 저장할 수 있는 ArrayList 생성
		ArrayList <Book> list = new ArrayList <Book> ();
		
		ArrayList list2 = new ArrayList();
		
		list.add(new Book());
		list.add(new Book());
		
		list2.add(new Book());
		list2.add(new Book());
		
		//list.add("asdf");
		//Book 타입 객체만 받기 때문에 String 객체는 넣을 수 없다.
		
		for(Book b : list) {//for(객체 선언 : 처음부터 끝까지 돌릴 객체) { 수행할 내용; }
			b.printBook();
		}
		for(Object o : list2) {
		//여러 타입의 객체가 Object 타입으로 들어있기 때문에 북 타입으로는 담을 수 없다.
			((Book)o).printBook();
			//printBook은 오버라이딩한 메소드가 아니어서 동적 바인딩 적용이 안되고,
			//결국 오브젝트 타입을 Book으로 변환해야한다.
		}
		
		Map<String, Book> map = new HashMap<String, Book>();
		//키는 String 객체만, 값은 Book 객체만 받는다.
		
	}
	
	public List <Book> test3(){
		List<Book> list = new ArrayList<Book>();
		return list;
	}
	

}

//한 클래스 파일 안에 여러 개의 클래스 정의 가능
//단, 접근제한자는 단 1개의 클래스에만 붙일 수 있다.
class Book{
	   private String title;

	   public Book(){}

	   public Book(String title){
	      this.title = title;
	   }

	   public void printBook(){
	      System.out.println("printBook() call...");
	   }
	   @Override
	   public String toString(){
	      return "Book";
	   }

	}

	class Student{
	   public Student(){}

	   public void score(){
	      System.out.println("score() call...");

	   }
	   @Override
	   public String toString(){
	      return "Student";
	   }

	}


	class Car{
	   public Car(){}

	   public void printCar(){
	      System.out.println("printCar() call...");
	   }
	   @Override
	   public String toString(){
	      return "Car";
	   }

	}

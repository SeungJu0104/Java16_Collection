package com.collection.part01_list.arrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class ArrayListTest {
	
	public void testArrayList() {
		//[ArrayList]
		/* 저장 순서가 유지.(인덱스 적용)
		 * 중복 값 입력 가능.(인덱스가 있기 때문에 구별 가능)
		 * 객체를 생성해서 사용한다.
		 * 그리고 객체만 저장 가능하다.(기본 자료형들 모두 객체로 자동 형변환되어 저장된다.)(Wrapper Class)
		 * 배열과 다르게 Collection에 toString이 오버라이딩 되어있기 때문에 그냥 출력 가능.
		 * 각 인덱스 번호에 맞춰 데이터가 들어가 있다.
		 * 인덱스가 지정되어 있기 때문에 for문으로도 접근 가능하다.(배열에서 사용한 것과 유사)
		 * List에서 크기는 size()를 사용한다. 배열에서는 length를 사용했다.(length 메소드는 아니고 그냥 length)
		 * List에서 인덱스 접근은 get 메소드를 사용한다.
		 * 즉, 배열과 다르게 add로 값을 넣고 size로 크기를 확인하고, 인덱스 값 접근은 get을 사용한다.
		 */
		ArrayList alist = new ArrayList();//ArrayList 객체 생성
		
		//다형성을 적용해 ArrayList 생성
		List list = new ArrayList();//업캐스팅
		Collection clist = new ArrayList();//업캐스팅
		
		alist.add("apple");//ArrayList에 String 객체 "apple"을 추가.
		alist.add(123);//ArrayList에 Integer 객체 추가.
		alist.add(45.67);//ArrayList에 Double 객체 추가.
		alist.add(new Date());//ArrayList에 Date 객체.
		alist.add('B');//ArrayList에 Character 객체 추가.
		
		System.out.println("alist : " + alist);
		//배열과 다르게 Collection에 toString이 오버라이딩 되어있기 때문에 그냥 출력 가능.
		//각 인덱스 번호에 맞춰 데이터가 들어가 있다.
		
		//인덱스가 지정되어 있기 때문에 for문으로도 접근 가능하다.(배열에서 사용한 것과 유사)
		//List에서 크기는 size()를 사용한다. 배열에서는 lenth를 사용했다.(length 메소드는 아니고 그냥 length)
		//List에서 인덱스 접근은 get 메소드를 사용한다.
		//배열과 다르게 add로 값을 넣고 size로 크기를 확인하고, 인덱스 값 접근은 get을 사용한다.
		for(int i = 0; i < alist.size(); i++) {
			System.out.println(i + " : " + alist.get(i));
		}
		
		alist.add("apple");//인덱스로 구분 가능하기때문에 중복 값을 허용한다.
		System.out.println("alist : " + alist);
		
		//add() 로 객체를 중간에 추가하는 경우
		//해당 인덱스에 덮어쓰는게 아니라
		//기존 데이터(객체)를 하나씩 뒤로 미뤄서 저장한다.
		//기존 인덱스 +1 위치에 각각 저장한다.
		alist.add(1, "banana");
		System.out.println("alist : " + alist);
		
		//remove() 로 리스트 중간에 객체를 삭제하는 경우
		//삭제한 후 나머지 객체들을 하나씩 앞으로 당겨 채운다.
		alist.remove(3);
		System.out.println("alist : " + alist);
		
		//set()을 이용하면 해당 인덱스의 객체만 덮어쓰기한다.
		alist.set(1, false);
		System.out.println("alist : " + alist);
		
		System.out.println("-----------------------------------------------------------");
		
		list.add("apple");
		list.add("grape");
		list.add("banana");
		list.add("mango");
		list.add("orange");
		
		System.out.println("list : " + list);
		
		//ArrayList는 오름차순 정렬 가능한 sort 메소드 사용 가능
		//Collections.sort(오름차순 정렬할 객체); 
		//Comparable을 상속받아 compareTo 메소드 오버라이딩을 통해 정렬 구현.
		//시스템의 기본 값인 오름차순으로만 정렬한다.
		Collections.sort(list);
		
		//list.sort(null);
		
		//Collections.sort(오름차순 정렬할 객체, 정렬할 기준 객체);
		//Comparator 클래스를 이용해 정렬을 구현한다.
		//사용자가 정렬할 기준 값을 정할 수 있다.
		
		System.out.println("list : " + list);
	}

}

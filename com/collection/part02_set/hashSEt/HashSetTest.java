package com.collection.part02_set.hashSEt;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Date;
import java.util.Collection;

public class HashSetTest {
	/* Set
	 * 인덱스가 없기 때문에 순서가 없다.
	 * 그래서 실행할 때마다 데이터의 순서가 바뀐다.
	 * 인덱스가 없기 때문에 중복 데이터를 받지 않는다.(구별 불가능)
	 * 저장된 객체를 하나씩 꺼내는 기능이 없다.(get 메소드 사용 불가) -> toArray(), Iterator 사용
	 */
	
	public void testHashSet() {
		//HashSet
		HashSet hset = new HashSet();//객체를 생성.
		Set hset2 = new HashSet();//다형성 적용해 객체를 생성.
		Collection hset3 = new HashSet();//다형성 적용해 객체를 생성.
		
		hset.add("java");
		hset.add(123);
		hset.add(45.67);
		hset.add(new Date());
		System.out.println("hset : " + hset);
		//실행할 때 마다 출력 순서가 바뀐다.
		//Set는 인덱스가 없기 때문에 따로 순서가 없다.
		
		hset.add(123);
		hset.add("java");
		System.out.println("hset : " + hset);
		//중복 데이터를 허용하지 않는다.
		
		//저장된 객체를 하나씩 꺼내는 기능이 없다.
		//즉, get 메소드 사용이 불가하다.
		//해결방안 1. toArray()를 이용해 배열로 만든다.
		Object [] arr = hset.toArray();
		
		for(Object obj : arr) {//파이썬에서 반복문 방식과 유사?
			System.out.println(obj);
		}
		
		//해결방안 2. Iterator()로 목록 만들어 연속 처리
		//줄 세워서 하나씩 처리
		Iterator iter = hset.iterator();
		
		//StringTokenizer와 유사한 방식을 사용한다.
		while(iter.hasNext()) {//while문은 조건식의 결과 값이 false면 반복 종료.
			System.out.println(iter.next());
		}
		
		//Set 삭제
		hset.clear();
		System.out.println("is Empty  : " + hset.isEmpty());
		
	}
	
}

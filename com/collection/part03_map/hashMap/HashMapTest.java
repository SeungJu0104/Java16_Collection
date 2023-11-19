package com.collection.part03_map.hashMap;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
	/* Map
	 * Collection의 하위클래스가 아닌 별개이다.
	 * 키와 값의 쌍으로 구성 -> 묶어서 Entry
	 * 키와 값은 반드시 객체여야한다.
	 * 키는 중복을 허용하지 않고, 값은 중복을 허용한다.(중복되는 값은 여러개여도 상관없다.)
	 * 키가 중복될 경우, 그 키에 해당하는 값을 새 값으로 덮어씌운다.
	 * 객체를 넣을 때 put 메소드를 사용한다.(List의 add 같은 개념)
	 * 데이터는 { } 안에 키 = 값 형태로 나온다.
	 * 딱히 순서가 정해진 것이 없으므로 매번 순서가 바뀌어 데이터가 나온다.
	 * get(키 값) 메소드 이용해 키에 대응되는 값(객체)를 갖고 온다.
	 * remove(키 값) 메소드를 이용해 키에 대응되는 값(객체)를 삭제할 수 있다.
	 */
	
	public void testHashMap() {
		HashMap hmap = new HashMap();
		
		//키와 값의 쌍으로 구성 -> 묶어서 Entry
		//키와 값 모두 반드시 객체여야 한다.
		//객체를 넣을 때 add가 아닌 put을 사용한다.
		hmap.put("one", new Date());
		hmap.put(12, "red apple");
		hmap.put(33, 123);
		
		System.out.println("hmap : " + hmap);
		
		//키가 중복되는 경우, 그 키에 해당하는 값을 새 값으로 덮어씌운다.
		//즉, 키 값은 중복되지 않는다.
		hmap.put(12, "school");
		System.out.println("hmap : " + hmap);
		
		//키 값만 중복되지 않는다면, 값은 중복을 허용한다.
		//중복되는 값은 여러개여도 상관없다.
		hmap.put(11, "school");
		hmap.put(9, "school");
		System.out.println("hmap : " + hmap);
		
		//키 값을 갖고 있다면, 대응하는 값(객체)를 갖고 올 수 있다.
		//.get(키 값);
		System.out.println("키 9에 해당하는 객체 : " + hmap.get(9));
		
		//키 값을 갖고 있다면, 삭제 처리도 가능하다.
		hmap.remove(9);
		System.out.println("hmap : " + hmap);
		
		hmap.clear();//내용 전체 삭제
		
		System.out.println("----------------------------------------------------------");
		//Map에 저장된 객체를 연속으로 처리
		//1. keySet() 으로 키만 set형태로 받아 iterator()로 목록 만들어 연속 처리
		
		hmap.put("one", "java 11");//키에 정수, 실수 적으면 형변환에서 문제 생겨 ClassCast 예외 출력한다.
		hmap.put("two", "my sql");
		hmap.put("three", "JDBC");
		hmap.put("four", "HTML5");
		hmap.put("five", "CSS3");
		
		Set keys = hmap.keySet();
		
		Iterator keyIter = keys.iterator();
		
		//StringTokenizer와 유사한 방식
		while(keyIter.hasNext()) {
			String key = (String)keyIter.next();
			String val = (String)hmap.get(key);
			System.out.println(key + " = " + val);
		}
		
		//2. entrySet()
		//Map 내부 클래스인 Entry 를 활용
		Set eSet = hmap.entrySet();
		Iterator entryIter = eSet.iterator();
		
		while(entryIter.hasNext()) {
			Map.Entry entry = (Map.Entry)entryIter.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}

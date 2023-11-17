package com.collection.part01_list.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreManager {

	public static void main(String[] args) {
		//다형성 적용해 객체 생성
		List <Score> list = new <Score> ArrayList();
		//List의 객체를 생성할 때 옆에 <클래스 타입>하면 해당 클래스 타입만 받는다.
		//Collection은 여러 타입의 데이터를 저장할 수 있다.
		//다만 이게 단점이 될 수도 있다.(복잡해진다.)
		
		list.add(new Score("이창진",99));
		list.add(new Score("남승주",75));
		list.add(new Score("이예담",88));
		list.add(new Score("안해림",32));
		list.add(new Score("김나현",72));
		list.add(new Score("박소정",61));
		
		System.out.println("list : " + list);
		//toString 이용해 출력된다.
		
		//정렬
		//Comparable - 기본적으로 적용되는 정렬 기준을 바탕으로 대상 객체의 정렬을 구현한다.
		//Collections.sort(list);
		list.sort(null);
		//list.sort(null); 의 ()안은 정렬할 별도의 기준. 없으면 Comparable의 기본 정렬 기준을 사용한다.(오버라이딩한 compareTo())
		//따로 오버라이딩 안하면 오름차순을 정렬 기준으로 한다.
		System.out.println("list : " + list);
		
		list.sort(new ScoreDesc());
		System.out.println("list : " + list);
		
		Collections.sort(list, new ScoreDesc());
		System.out.println("list : " + list);
		

	}

}

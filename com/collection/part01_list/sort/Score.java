package com.collection.part01_list.sort;

import java.util.Objects;

public class Score implements Comparable <Score>{//인터페이스 Comparable을 상속받는다. <>안에는 클래스 타입.
	//필드 선언
	private String name;
	private int score;
	
	//생성자
	public Score () {}
	public Score (String name, int score){
			this.name = name;
			this.score = score;
		}
	
	//getter 메소드
	public String getName () {
		return name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, score);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		return Objects.equals(name, other.name) && score == other.score;
	}
	
	@Override
	public String toString() {
		return "[name=" + name + ", score=" + score + "]";
	}
	
	@Override
	public int compareTo(Score o) {
		//기본 정렬 기준으로 name 오름차순 줄 것이다.
		String otherName = o.getName();
		return this.name.compareTo(otherName);
		//this.name이 기준이고, ()안의 otherName이 비교할 대상.
		//compareTo() 의 리턴 값 (this.name - other.Name) -> 음수 : 자리를 바꾸지 않는다. 양수 : 자리를 바꾼다.
		//기준대상 객체 앞에 - 를 붙이면 역순으로 정렬한다.
		//예를 들어, return -this.name.compareTo(otherName); -> 오름차순이 아니라 내림차순으로 정렬한다.
	}
	
	
	
	
	
	
	
}

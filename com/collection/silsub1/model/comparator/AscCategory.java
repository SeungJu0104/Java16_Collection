package com.collection.silsub1.model.comparator;

import java.util.Comparator;

import com.collection.silsub1.model.vo.Book;

public class AscCategory implements Comparator <Book>{
	
	@Override
	public int compare(Book o1, Book o2) {
		return o1.getCategory() - o2.getCategory();
		//음수 나오면 o1이 o2보다 앞에 위치
		//양수 나오면 o1이 o2보다 뒤에 위치
	}
}

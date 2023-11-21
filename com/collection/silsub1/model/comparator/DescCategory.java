package com.collection.silsub1.model.comparator;

import java.util.Comparator;

import com.collection.silsub1.model.vo.Book;

public class DescCategory implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		return o2.getCategory() - o1.getCategory();
	}
}

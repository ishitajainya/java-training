package com.lab_assignment_4.q2;

import java.util.Objects;

public class Book {
	private String title;
	private String author;
	public Book(String title, String author) {
	    this.title = title;
	    this.author = author;
	}
	@Override
	public String toString() {
		return "Book Title : " + title + " , Book Author : " + author;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Book other = (Book) obj;
        return Objects.equals(title, other.title) &&
               Objects.equals(author, other.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

	public String getTitle() {
		return title;
	}

    public String getAuthor() {
        return author;
    }

}

package org.drea.shared.model;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	private String key;

	private String title;

	private String author;

	private String description;

	private String isbn;

	// private Image image;

	public String getKey() {
		return key;
	}

	public void setkey(String key) {
		if (key != null && !key.trim().equals("")) {
			this.key = key;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

}

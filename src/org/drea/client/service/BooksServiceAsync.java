package org.drea.client.service;

import java.util.ArrayList;

import org.drea.shared.model.Book;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BooksServiceAsync {

	void getBook(String bookKey, AsyncCallback<Book> callback);

	void addBook(Book book,
			AsyncCallback<String> callback);

	void updateBook(Book book, String Key, AsyncCallback<String> callback);

	void searchBooks(String title, String author, String isbn,
			AsyncCallback<ArrayList<Book>> callback);

}

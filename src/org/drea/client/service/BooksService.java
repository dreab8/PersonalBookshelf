package org.drea.client.service;

import java.util.ArrayList;

import org.drea.shared.model.Book;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("bookservice")
public interface BooksService extends RemoteService {

	Book getBook(String bookKey);
	
	String addBook(Book book);
	
	String updateBook(Book book, String Key);
	
	ArrayList<Book> searchBooks(String title, String author, String isbn);

}

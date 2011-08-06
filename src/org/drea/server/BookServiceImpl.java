package org.drea.server;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.drea.client.service.BooksService;
import org.drea.shared.model.Book;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class BookServiceImpl extends RemoteServiceServlet implements
		BooksService {

	private static final String BOOK_ISBN_PROPERTY = "isbn";

	private static final String BOOK_AUTHOR_PROPERTY = "author";

	private static final String BOOK_TITLE_PROPERTY = "title";

	private static final String BOOK_ENTITY_KIND = "Book";

	Logger logger = Logger.getLogger(BookServiceImpl.class);

	private DatastoreService datastore = DatastoreServiceFactory
			.getDatastoreService();

	@Override
	public Book getBook(String bookKey) {
		Key key = KeyFactory.stringToKey(bookKey);
		Entity bookEntity;
		try {
			bookEntity = datastore.get(key);
		} catch (EntityNotFoundException e) {
			return null;
		}
		
		return createBookFromEntity(bookEntity);
	}

	@Override
	public String addBook(Book book) {
		Entity bookEntity = null;

		bookEntity = new Entity(BOOK_ENTITY_KIND);

		populateBookEntityFromBook(bookEntity, book);

		Key bookKey = datastore.put(bookEntity);

		return KeyFactory.keyToString(bookKey);
	}

	@Override
	public String updateBook(Book book, String bookKey) {
		Entity bookEntity = null;

		Key key = KeyFactory.stringToKey(bookKey);

		bookEntity = new Entity(BOOK_ENTITY_KIND, key);

		populateBookEntityFromBook(bookEntity, book);

		key = datastore.put(bookEntity);

		return KeyFactory.keyToString(key);
	}

	@Override
	public ArrayList<Book> searchBooks(String title, String author, String isbn) {
		ArrayList<Book> results = new ArrayList<Book>();
		Query query = new Query(BOOK_ENTITY_KIND);
	    query.addFilter(BOOK_TITLE_PROPERTY, Query.FilterOperator.EQUAL, title);
	    query.addFilter(BOOK_AUTHOR_PROPERTY, Query.FilterOperator.EQUAL, author);
	    query.addFilter(BOOK_ISBN_PROPERTY, Query.FilterOperator.EQUAL, isbn);
	    
	    PreparedQuery preparedQuery = datastore.prepare(query);
	    for(Entity result : preparedQuery.asIterable()){
	    	Book book = createBookFromEntity(result);
	    	results.add(book);
	    }
		return results;
	}

	private void populateBookEntityFromBook(Entity bookEntity, Book book) {
		bookEntity.setProperty(BOOK_TITLE_PROPERTY, book.getTitle());
		bookEntity.setProperty(BOOK_AUTHOR_PROPERTY, book.getAuthor());
		bookEntity.setProperty(BOOK_ISBN_PROPERTY, book.getIsbn());
	}
	
	private Book createBookFromEntity(Entity entity){
		Book book = new Book();
		String bookKey = KeyFactory.keyToString(entity.getKey());
		book.setkey(bookKey);
		book.setTitle((String) entity.getProperty(BOOK_TITLE_PROPERTY));
		book.setAuthor((String) entity.getProperty(BOOK_AUTHOR_PROPERTY));
		book.setIsbn((String) entity.getProperty(BOOK_ISBN_PROPERTY));
		return book;
	}
}

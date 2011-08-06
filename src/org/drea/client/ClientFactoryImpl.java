package org.drea.client;

import org.drea.client.service.BooksService;
import org.drea.client.service.BooksServiceAsync;
import org.drea.client.view.AddBookView;
import org.drea.client.view.AddBookViewImpl;
import org.drea.client.view.BookDetailsView;
import org.drea.client.view.BookDetailsViewImpl;
import org.drea.client.view.SearchBooksView;
import org.drea.client.view.SearchBooksViewImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactoryImpl implements ClientFactory {

	private static BookDetailsView bookDetailsView = new BookDetailsViewImpl();
	private static AddBookView addBookView = new AddBookViewImpl();
	private static SearchBooksView searchBooksView = new SearchBooksViewImpl();
	
	private static final EventBus eventBus = new SimpleEventBus();
	private static final BooksServiceAsync booksService = (BooksServiceAsync) GWT.create(BooksService.class);
	private static final PlaceController placeController = new PlaceController(eventBus);
	
	@Override
	public BookDetailsView getBookDetailsView() {
		return bookDetailsView;
	}

	@Override
	public EventBus getEventBus() {
		return eventBus ;
	}

	@Override
	public BooksServiceAsync getBooksService() {
		return booksService;
	}

	@Override
	public AddBookView getAddBookView() {		
		return addBookView;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public SearchBooksView getSearchView() {
		return searchBooksView;
	}

}

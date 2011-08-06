package org.drea.client;

import org.drea.client.service.BooksServiceAsync;
import org.drea.client.view.AddBookView;
import org.drea.client.view.BookDetailsView;
import org.drea.client.view.SearchBooksView;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface ClientFactory {
	EventBus getEventBus();	
	BooksServiceAsync getBooksService();
	PlaceController getPlaceController();
	
	BookDetailsView getBookDetailsView();
	AddBookView getAddBookView();
	SearchBooksView getSearchView();

}

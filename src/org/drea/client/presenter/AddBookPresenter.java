package org.drea.client.presenter;

import org.drea.client.ClientFactory;
import org.drea.client.place.BookDetailsPlace;
import org.drea.client.place.EditBookPlace;
import org.drea.client.view.AddBookView;
import org.drea.shared.model.Book;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class AddBookPresenter extends AbstractActivity implements
		AddBookView.Presenter {

	ClientFactory clientFactory;
	AddBookView view;
	String bookKey;

	public AddBookPresenter(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
		view = clientFactory.getAddBookView();
		view.clear();
	}

	public AddBookPresenter(ClientFactory clientFactory, EditBookPlace place) {
		super();
		this.clientFactory = clientFactory;
		view = clientFactory.getAddBookView();
		view.clear();
		bookKey = place.getBookKey();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		AddBookView view = clientFactory.getAddBookView();
		if(bookKey != null){
			clientFactory.getBooksService().getBook(bookKey, new PopulateView());
		}
		view.setPresenter(this);
		panel.setWidget(view);
	}

	@Override
	public void onSaveButtonClicked() {
		Book book = new Book();
		book.setIsbn(view.getIsbn().getValue());
		book.setTitle(view.getBookTitle().getValue());
		book.setAuthor(view.getAuthor().getValue());

		if (bookKey != null) {
			clientFactory.getBooksService().updateBook(book, bookKey,
					new AsyncCallResult());
		} else {

			clientFactory.getBooksService()
					.addBook(book, new AsyncCallResult());
		}

	}
	
	private void populateView(Book book){
		view.getAuthor().setValue(book.getAuthor());
		view.getBookTitle().setValue(book.getTitle());
		view.getIsbn().setValue(book.getIsbn());
	}

	private final class AsyncCallResult implements AsyncCallback<String> {
		@Override
		public void onSuccess(String result) {
			GWT.log("result " + result);
			clientFactory.getPlaceController().goTo(
					new BookDetailsPlace(result));
		}

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Error comunicating with the server");
		}
	}
	
	private final class PopulateView implements AsyncCallback<Book> {
		@Override
		public void onSuccess(Book result) {
			populateView(result);
		}

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Error comunicating with the server");
		}
	}
}

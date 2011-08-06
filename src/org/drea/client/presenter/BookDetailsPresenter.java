package org.drea.client.presenter;

import org.drea.client.ClientFactory;
import org.drea.client.place.AddBookPlace;
import org.drea.client.place.BookDetailsPlace;
import org.drea.client.place.EditBookPlace;
import org.drea.client.view.BookDetailsView;
import org.drea.shared.model.Book;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class BookDetailsPresenter extends AbstractActivity implements BookDetailsView.Presenter {

	private BookDetailsView view;
	private ClientFactory clientFactory;
	private String bookKey;

	public BookDetailsPresenter(ClientFactory clientFactory, BookDetailsPlace place) {
		this.clientFactory = clientFactory;
		this.bookKey = place.getBoolKey();
	}

	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getBookDetailsView();
		view.setPresenter(this);
		GWT.log("show book details with key = " + bookKey);
		clientFactory.getBooksService().getBook(bookKey,
				new AsyncCallback<Book>() {

					@Override
					public void onSuccess(Book result) {
						if (result != null) {
							GWT.log("details key " + result.getKey());
							view.setBookTitle(result.getTitle());
							view.setBookAUthor(result.getAuthor());
							view.setBookIsbn(result.getIsbn());
							panel.setWidget(view.asWidget());
						}
					}

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("error error error " + caught);
					}
				});
	}

	@Override
	public void onClickAddBook() {
		clientFactory.getPlaceController().goTo(new AddBookPlace());
	}

	@Override
	public void onClieckEditBook() {
		clientFactory.getPlaceController().goTo(new EditBookPlace(bookKey));
		
	}

}

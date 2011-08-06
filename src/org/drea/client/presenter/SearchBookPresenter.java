package org.drea.client.presenter;

import java.util.ArrayList;

import org.drea.client.ClientFactory;
import org.drea.client.view.SearchBooksView;
import org.drea.shared.model.Book;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class SearchBookPresenter extends AbstractActivity implements SearchBooksView.Presenter {

	private SearchBooksView view;
	
	private ClientFactory clientFactory;
	
	public SearchBookPresenter(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getSearchView();
		view.setPresenter(this);
	}

	@Override
	public void onClickSearch() {
		String title = view.getBookTitle().getValue();
		String author = view.getAuthor().getValue();
		String isbn = view.getIsbn().getValue();
		
		clientFactory.getBooksService().searchBooks(title,author,isbn, new AsyncCallback<ArrayList<Book>>() {
			
			@Override
			public void onSuccess(ArrayList<Book> result) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("error error error " + caught);
				
			}
		});
	}

}

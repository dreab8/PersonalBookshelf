package org.drea.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class SearchBooksViewImpl extends Composite implements SearchBooksView {

	private static SearchBooksViewImplUiBinder uiBinder = GWT
			.create(SearchBooksViewImplUiBinder.class);

	interface SearchBooksViewImplUiBinder extends UiBinder<Widget, SearchBooksViewImpl> {
	}
	
	private Presenter presenter;

	@UiField
	TextBox bookTitle;
	
	@UiField
	TextBox bookAuthor;
	
	@UiField
	TextBox isbn;
	
	@UiField
	Button searchButton;

	public SearchBooksViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("searchButton")
	void onSaveButtonClick(ClickEvent e) {
		this.presenter.onClickSearch();
	}

	@Override
	public HasValue<String> getIsbn() {
		return isbn;
	}

	@Override
	public HasValue<String> getAuthor() {
		return bookAuthor;
	}
	
	@Override
	public HasValue<String> getBookTitle(){
		return bookTitle;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}

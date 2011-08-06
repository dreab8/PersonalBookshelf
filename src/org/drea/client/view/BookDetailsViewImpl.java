package org.drea.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class BookDetailsViewImpl  extends Composite implements BookDetailsView {
	
	private static BookDetailsViewImplUiBinder uiBinder = GWT.create(BookDetailsViewImplUiBinder.class);

	interface BookDetailsViewImplUiBinder extends UiBinder<Widget, BookDetailsViewImpl> {
	}

	@UiField
	Label title;
	
	@UiField
	Label isbn;
	
	@UiField
	Label author;
	
	@UiField
	Anchor newBookAnchor;
	
	@UiField
	Anchor editBookAnchor;
	
	private Presenter presenter;

	public BookDetailsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setBookTitle(String title) {
		this.title.setText(title);
	}

	@Override
	public void setBookAUthor(String author) {
		this.author.setText(author);
		
	}

	@Override
	public void setBookIsbn(String isbn) {
		this.isbn.setText(isbn);
	}
	
	@UiHandler("newBookAnchor")
	public void onClickNewBook(ClickEvent event){
		presenter.onClickAddBook();
	}
	
	@UiHandler("editBookAnchor")
	public void onClickEditBook(ClickEvent event){
		presenter.onClieckEditBook();
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}

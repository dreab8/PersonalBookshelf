package org.drea.client.view;

import org.drea.client.presenter.AddBookPresenter;

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

public class AddBookViewImpl extends Composite implements AddBookView {

	private static AddBookViewImplUiBinder uiBinder = GWT
			.create(AddBookViewImplUiBinder.class);

	interface AddBookViewImplUiBinder extends UiBinder<Widget, AddBookViewImpl> {
	}

	private Presenter presenter;

	@UiField
	TextBox title;

	@UiField
	TextBox isbn;

	@UiField
	TextBox author;

	@UiField
	Button saveButton;

	public AddBookViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(AddBookPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public HasValue<String> getIsbn() {
		return isbn;
	}

	@Override
	public HasValue<String> getAuthor() {
		return author;
	}

	@Override
	public HasValue<String> getBookTitle() {
		return title;
	}

	@UiHandler("saveButton")
	public void saveButtonEventHandler(ClickEvent event) {
		this.presenter.onSaveButtonClicked();
	}

	@Override
	public void clear() {
		title.setText("");
		author.setText("");
		isbn.setText("");
	}
	
}

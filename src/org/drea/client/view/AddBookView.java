package org.drea.client.view;

import org.drea.client.presenter.AddBookPresenter;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;

public interface AddBookView extends IsWidget {
	
	HasValue<String> getBookTitle();
	HasValue<String> getIsbn();
	HasValue<String> getAuthor();
	
	void setPresenter(AddBookPresenter presenter);
	
	public interface Presenter {
		void onSaveButtonClicked();
	}

	void clear();
}

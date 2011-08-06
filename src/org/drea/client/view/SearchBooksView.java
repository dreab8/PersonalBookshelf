package org.drea.client.view;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;

public interface SearchBooksView extends IsWidget {
	
	HasValue<String> getIsbn();
	
	HasValue<String> getAuthor();
	
	HasValue<String> getBookTitle();
	
	void setPresenter(Presenter presenter);
	
	interface Presenter {
		void onClickSearch();
	}

}

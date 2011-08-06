package org.drea.client.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface BookDetailsView extends IsWidget{
	
	void setPresenter(Presenter presenter);
	
	void setBookTitle(String title);
	
	void setBookIsbn(String isbn);
	
	void setBookAUthor(String author);
	
	public interface Presenter {
		void onClickAddBook();

		void onClieckEditBook();
		
	}

}

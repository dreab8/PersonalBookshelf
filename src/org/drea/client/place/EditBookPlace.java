package org.drea.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class EditBookPlace extends Place {
	
	private String bookKey; 
	
	public EditBookPlace(String bookKey){
		super();
		this.bookKey = bookKey;
	}
	
	public String getBookKey() {
		return bookKey;
	}
	
	public class Tokenizer implements PlaceTokenizer<EditBookPlace> {

		@Override
		public EditBookPlace getPlace(String token) {
			return new EditBookPlace(token);
		}

		@Override
		public String getToken(EditBookPlace place) {
			return place.getBookKey();
		}

	}

}

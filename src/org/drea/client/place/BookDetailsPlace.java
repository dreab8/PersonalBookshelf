package org.drea.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class BookDetailsPlace extends Place {
	
	private String boolKey; 

	public BookDetailsPlace(String token) {
		super();
		this.boolKey = token;
	}

	public String getBoolKey() {
		return boolKey;
	}
	
	public static class Tokenizer implements PlaceTokenizer<BookDetailsPlace>{

		@Override
		public BookDetailsPlace getPlace(String token) {
			return new BookDetailsPlace(token);
		}

		@Override
		public String getToken(BookDetailsPlace place) {
			return place.getBoolKey();
		}
	}

}

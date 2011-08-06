package org.drea.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class AddBookPlace extends Place {
	
	public AddBookPlace() {
		super();
	}

	public static class Tokenizer implements PlaceTokenizer<AddBookPlace>{

		@Override
		public AddBookPlace getPlace(String token) {
			return new AddBookPlace();
		}

		@Override
		public String getToken(AddBookPlace place) {
			return null;
		}
		
	}

}

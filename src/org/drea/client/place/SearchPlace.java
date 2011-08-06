package org.drea.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class SearchPlace extends Place {
	
	public class Tokenizer implements PlaceTokenizer<SearchPlace>{

		@Override
		public SearchPlace getPlace(String token) {
			return new SearchPlace();
		}

		@Override
		public String getToken(SearchPlace place) {
			return null;
		}
		
	}

}

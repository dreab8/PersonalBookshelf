package org.drea.client.place.mapper;

import org.drea.client.place.AddBookPlace;
import org.drea.client.place.BookDetailsPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({BookDetailsPlace.Tokenizer.class,AddBookPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}

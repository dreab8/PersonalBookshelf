package org.drea.client.place.mapper;

import org.drea.client.ClientFactory;
import org.drea.client.place.AddBookPlace;
import org.drea.client.place.BookDetailsPlace;
import org.drea.client.place.EditBookPlace;
import org.drea.client.place.SearchPlace;
import org.drea.client.presenter.AddBookPresenter;
import org.drea.client.presenter.BookDetailsPresenter;
import org.drea.client.presenter.SearchBookPresenter;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

	ClientFactory clientFactory;
	
	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if(place instanceof BookDetailsPlace){
			return new BookDetailsPresenter(clientFactory, (BookDetailsPlace)place);
		}else if (place instanceof AddBookPlace){
			return new AddBookPresenter(clientFactory);
		}else if(place instanceof EditBookPlace){
			return new AddBookPresenter(clientFactory,(EditBookPlace)place);
		}else if (place instanceof SearchPlace) {
			return new SearchBookPresenter(clientFactory);
		}
		return null;
	}

}

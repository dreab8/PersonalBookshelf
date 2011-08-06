package org.drea.client;

import org.drea.client.place.AddBookPlace;
import org.drea.client.place.mapper.AppActivityMapper;
import org.drea.client.place.mapper.AppPlaceHistoryMapper;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Bookshelf implements EntryPoint {
	
	private final ClientFactory clientFactory = GWT.create(ClientFactory.class);
	private SimplePanel appWidget = new SimplePanel();
	private Place defaultPlace = new AddBookPlace();
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		EventBus eventBus = clientFactory.getEventBus();
		
		
		ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		
		activityManager.setDisplay(appWidget);
		
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		PlaceController placeController = clientFactory.getPlaceController();
		
		historyHandler.register(placeController, eventBus, defaultPlace);
		
		RootPanel.get().add(appWidget);
		
		historyHandler.handleCurrentHistory();
		

	}
}

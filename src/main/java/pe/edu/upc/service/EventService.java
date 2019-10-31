package pe.edu.upc.service;

import java.util.Collection;

import pe.edu.upc.model.Event;

public interface EventService {

	public abstract int createEvent(Event event);
	public abstract int updateEvent(Long id, Event event);
	public abstract int deleteEvent(Long id);
	public abstract Collection<Event>getEvents();
}

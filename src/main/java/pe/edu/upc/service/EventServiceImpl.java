package pe.edu.upc.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Event;
import pe.edu.upc.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	@Transactional
	public int createEvent(Event event) {
		// TODO Auto-generated method stub
		int result = eventRepository.countByName(event.getName());
		if(result==0) {
			eventRepository.save(event);
		}
		return result;
	}

	@Override
	public int updateEvent(Long id, Event event) {
		// TODO Auto-generated method stub
		int result = 0;
		Optional<Event> originalEvent = eventRepository.findById(id);
		result = originalEvent.isPresent() ? 0 : -1;
		Event updatedEvent = originalEvent.get();
		updatedEvent.setName(event.getName());
		updatedEvent.setDescription(event.getDescription());
	    updatedEvent.setSalary(event.getSalary());
	    eventRepository.save(updatedEvent);
	    return result;
	}

	@Override
	public int deleteEvent(Long id) {
		// TODO Auto-generated method stub
		int result = 0;
		Optional<Event> event = eventRepository.findById(id);
		event.ifPresent(e -> eventRepository.delete(e));
		result = event.isPresent() ? 0 : -1;
		return result;
	}

	@Override
	public Collection<Event> getEvents() {
		// TODO Auto-generated method stub
		return eventRepository.findAllByOrderByNameDesc();
	}

}

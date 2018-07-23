package war.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import war.account.AccountRepository;
import war.error.ToBigGroupSizeException;

import java.util.Optional;
import java.util.Set;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AccountRepository userRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@RequestBody Event newEvent) {
        if (newEvent.getMaxGroupSize() > 50) {
            throw new ToBigGroupSizeException
                    (String.format("Group size should not be bigger than 50. Given group size: %s", newEvent.getMaxGroupSize()));
        }

        return eventRepository.save(newEvent);
    }

//    public void addUserToEvent(Long eventId, Long userId) {
//        Optional<Event> event = eventRepository.findById(eventId);
//        Optional<User> user = userRepository.findById(userId);
//
//        if (event.isPresent() && user.isPresent()) {
//            event.get().getUsers().add(user.get());
//            user.get().getEvents().add(event.get());
//        }
//        eventRepository.save(event.get());
//        userRepository.save(user.get());
//    }
//
//    public Set<User> showUsersOfEvent(Long eventId) {
//        Optional<Event> byId = eventRepository.findById(eventId);
//
//        if (byId.isPresent()) {
//            Set<User> users = byId.get().getUsers();
//            return users;
//        }
//        return null;
    }



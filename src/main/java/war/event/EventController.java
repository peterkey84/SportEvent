package war.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import war.account.Account;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
//@RequestMapping("/event")
public class EventController {

//    @Autowired
//    private EventService eventService;
//
//    @Autowired
//    EventRepository eventRepository;
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Event createEvent(@RequestBody Event newEvent) {
//        return eventService.createEvent(newEvent);
//    }
//
//    @GetMapping("/findall")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Event> showEvents() {
//        return eventRepository.findAll();
//    }
    @GetMapping("/event")
    public String getCalendar(){
        System.out.println("blabla");
        return "calendar/calendar";
    }

    @ModelAttribute("module")
    String module() {
        return "about";
    }



//    @GetMapping("/signUp")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public Optional<Event> addUserToEvent(
//            @RequestParam Long eventId,
//            @RequestParam Long userId){
//        eventService.addUserToEvent(eventId,userId);
//        return null;
//    }

//    @GetMapping("/eventUsers")
//    @ResponseStatus(HttpStatus.OK)
//    public Set<Account> showUsersOfEvent(
//            @RequestParam Long eventId){
//        return eventService.showUsersOfEvent(eventId);
//    }
}

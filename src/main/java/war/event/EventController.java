package war.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import war.account.Account;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    EventRepository eventRepository;


//    @PostMapping("/admin")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Event createEvent(@RequestBody Event newEvent) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName();
//        return eventService.createEvent(newEvent);
//    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Event> showEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/event")
    public String getCalendar(Model model) {
        model.addAttribute("module", "calendar");
        return "calendar/calendar";
    }

    @GetMapping("/addEvent")
    public String getEvent(Model model) {
        model.addAttribute("module", "event");
        model.addAttribute("event", new Event());
        return "event/event";
    }

    @PostMapping("/addEvent")
    public String saveEvent(@ModelAttribute Event event) {
        eventService.createEvent(event);
        return "event/event";
    }

    @ModelAttribute("module")
    String module() {
        return "about";
    }

}

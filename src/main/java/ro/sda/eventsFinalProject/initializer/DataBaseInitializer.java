package ro.sda.eventsFinalProject.initializer;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ro.sda.eventsFinalProject.model.Event;
import ro.sda.eventsFinalProject.service.EventService;

import java.time.LocalDateTime;

@Component
public class DataBaseInitializer {
    private final EventService eventService;

    public DataBaseInitializer(EventService eventService) {
        this.eventService = eventService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initDataBase() {


        Event e1 = new Event(
                null,
                "",
                LocalDateTime.of(2023, 8, 11, 20 ,0,0),
                LocalDateTime.of(2023,8, 14, 23, 59, 00),
                null,
                null,
                null);

        eventService.saveEvent(e1);


    }
}

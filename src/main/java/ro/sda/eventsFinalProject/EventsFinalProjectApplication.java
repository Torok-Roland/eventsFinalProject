package ro.sda.eventsFinalProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //activează funcționalitatea scheduling-ului -> o metoda sa ruleze la un momentdat.
public class EventsFinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsFinalProjectApplication.class, args);
	}

}

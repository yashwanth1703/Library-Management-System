
package libraryManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;
import libraryManagement.Model.TwilioConfig;



/* It is the main class of whole project
 * In this class there is a main method which runs whole program
 * This class gets connected with other classes like model,service,repository,service implementation, controller etc.
 * This class imports spring application and spring boot application
 * It states that no configurations are needed like creating beans and properties as traditional spring
 * spring boot application is annotated at main class
 */


@SpringBootApplication
public class LibraryManagement {
	
    // main class for starting project
	
	@Autowired
	private TwilioConfig twilioConfig;

	@PostConstruct
	public void setup() {
		Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagement.class, args);

	}

}

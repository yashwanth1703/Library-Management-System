package libraryManagement.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import libraryManagement.ServiceImplementation.LibraryEmailService;

@Controller
public class LibraryEmailController {
	
	
		@Autowired
		private LibraryEmailService libraryemailService;
		@RequestMapping("/")
		public ResponseEntity<String> checkEmail()
		{
		libraryemailService.sendEmail("adityayashwanth1703@gmail.com", "Check your project", "Spring Boot Project Library Management Started");
		return new ResponseEntity<>("Message Send",HttpStatus.CREATED);
		}

	}



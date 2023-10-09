package libraryManagement.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import libraryManagement.Model.CardDetails;
import libraryManagement.ServiceImplementation.CardServiceImpl;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/library.com")
public class CardController {
	@Autowired
	private CardServiceImpl cardService;

	@GetMapping("/readCard/{cardId}")
	  public ResponseEntity<CardDetails> getCardById(@PathVariable("cardId")Integer cardId) throws Exception {
		  return new ResponseEntity<CardDetails>(cardService.viewCard(cardId),HttpStatus.OK);
	  }
	@GetMapping("/readAllCards")
   public ResponseEntity<List<CardDetails>> getAllCards()throws Exception{
		return new ResponseEntity<List<CardDetails>>(cardService.viewAllCards(),HttpStatus.OK);
	}
}

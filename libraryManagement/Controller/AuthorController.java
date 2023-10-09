package libraryManagement.Controller;
import java.util.ArrayList;
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

import libraryManagement.Model.*;
import libraryManagement.Service.LibraryService;
import libraryManagement.Service.TransactionService;
import libraryManagement.ServiceImplementation.*;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/library.com")
public class AuthorController {
	@Autowired
	private AuthorServiceImplementation authorService;
	@Autowired
	private LibraryService libraryService;
	@Autowired
	private TransactionService transactionService;
	@Autowired
	public AuthorController(AuthorServiceImplementation authorService) {
		this.authorService = authorService;
	}
	
	@PostMapping("/saveAuthor")
	public ResponseEntity<Author> createAuthor(@RequestBody Author author){
		try {
		return new ResponseEntity<Author>(authorService.saveAuthor(author),HttpStatus.CREATED);
	}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

}

	@PutMapping("/updateAuthor/{authorId}")
	public ResponseEntity<Author> updateAuthor(@PathVariable("authorId") Integer authorId ,@RequestBody Author author) {
		try {
			return new ResponseEntity<Author>(authorService.updateAuthorDetails(author, authorId),HttpStatus.OK);
		}
		catch(Exception exc){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/readAuthor/{authorId}")
	public ResponseEntity<Author>readAuthorById(@PathVariable("authorId")Integer authorId) {
		try {
			return new ResponseEntity<Author>(authorService.getAuthorById(authorId),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/deleteAuthor/{authorId}")
	public void deleteAuthorById(@PathVariable("authorId") Integer authorId){
		try {
			Author authorObj = authorService.getAuthorById(authorId);
		   List<Book> bookObj =  authorObj.getBooks();
		   for(int books=0;books<bookObj.size();books++) {
//		     bookObj.getFeedbackList().clear();
//		     bookObj.getTransaction().clear();
			authorObj.getBooks().clear();
		   }
			authorService.deleteAuthorById(authorId);
		}
	   catch(Exception exc) {
		   System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	}
	@DeleteMapping("/deleteAllAuthors")
	public void deleteAllAuthors(){
		try {
			authorService.deleteAllAuthors();
		}
		catch(Exception exc) {
			System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/readAllAuthors")
	public ResponseEntity<List<Author>>fetchAllAuthors(){
		try {
			return new ResponseEntity<List<Author>>(authorService.getAllAuthors(),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/readAllAuthorsByName")
	public ResponseEntity<List<Author>> readAuthorsByName(@RequestParam(required=false)String authorName){
		try {
		List<Author>author = new ArrayList<Author>();
		authorService.fetchAuthorByIgnoringCase(authorName).forEach(author::add);
		if(author.isEmpty())
			return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Author>>(author,HttpStatus.ACCEPTED);
			
		}
		catch(Exception exc) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
}
}
	

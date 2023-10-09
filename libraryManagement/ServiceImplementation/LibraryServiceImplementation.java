package libraryManagement.ServiceImplementation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import libraryManagement.Model.*;
import libraryManagement.Repository.*;
import libraryManagement.Service.*;
import org.springframework.data.domain.Sort;

/* This is the implementation class for service interface.
 * In this class all the methods present in the service interface are overriden.
 * All the methods in this are defined in our way.
 * This class has @Service annotation
 */


@Service
public class LibraryServiceImplementation implements LibraryService{
	@Autowired
  private  LibraryRepository libraryRepository;
 // private  LibraryService libServ;
	public LibraryServiceImplementation(LibraryRepository libraryRepository) {
		this.libraryRepository = libraryRepository;
	}
	
	public Book saveBook(Book book) {
		book.setAuthor(book.getAuthorsBook().getAuthorName());
		book.setCategoryDetails(book.getCategoryDetails());
		return libraryRepository.save(book);
	}

	@Override
	public List<Book> getBooksFromDb(String bookName) {
		
		if(bookName == null)
		return libraryRepository.findAll();
		else
			return (List<Book>) libraryRepository.findByBookNameContainingIgnoreCase(bookName);
	}

	@Override
	public Book getBookByISBN(Integer book_isbn) {
		// TODO Auto-generated method stub
		Optional<Book> book = libraryRepository.findById(book_isbn);  //null , or it can 5tg person rec
		if(book.isPresent()) {
			return book.get();
		}
		else {
			return null;
		}
		
		
	}

	@Override
	public Book updateBookDetails(Book newVal, Integer book_isbn ) {
		// TODO Auto-generated method stub
		Optional<Book> book = libraryRepository.findById(book_isbn);
		if(book.isPresent()) {
			Book existingbook = book.get();  //'2', 'mny@123', 'abc', 'xyz'

			existingbook.setbookName(newVal.getBookName());
			existingbook.setBookCost(newVal.getBookCost());
			existingbook.setNoOfBooks(newVal.getNoOfBooks());
			existingbook.setIsPublished(newVal.getIsPublished());
			existingbook.setAuthor(newVal.getAuthor());
			existingbook.setIsPublished(newVal.getIsPublished());
			existingbook.setRatingOfBook(newVal.getRatingOfBook());
			existingbook.setCategoryDetails(newVal.getCategoryDetails());
			existingbook.setCard(newVal.getCard());
			libraryRepository.save(existingbook);
			return existingbook;
		}
		else {
			return null;
		}
	
	}

	@Override
	public void deleteBookByISBN(Integer book_isbn) {
	
		Optional<Book> book = libraryRepository.findById(book_isbn);
		if(book.isPresent()) {
			libraryRepository.deleteById(book_isbn);
		}	
		
	}

		public List<Book> checkIfBookIsPublished(Boolean booleanObj){
			List<Book> book = libraryRepository.findByIsPublished(true);
			return book;
		}
		public List<Book> checkIfBookIsNotPublished(Boolean booleanObj){
			List<Book> book = libraryRepository.findByIsPublished(false);
			return book;
		}

		@Override
		public void deleteAllBooks() {
			
			libraryRepository.deleteAll();
			System.out.println("All Books are deleted");
			
			
		}
		public Iterable<Book>fetchBookByNameIgnoringCase(String book_name){
			Iterable<Book> book = libraryRepository.findByBookNameContainingIgnoreCase(book_name);
			return book;
		}
		
		public List<Book>fetchBookByAuthorIgnoringCase(String book_author){
			List<Book> book = new ArrayList<Book>();
			libraryRepository.findByAuthorContainingIgnoreCase(book_author).forEach(book::add);
			
			return book;

	}
		
		private Sort.Direction getSortDirection(String direction) {
		    if (direction.equalsIgnoreCase("asc")) {
		      return Sort.Direction.ASC;
		    } else if (direction.equalsIgnoreCase("desc")) {
		      return Sort.Direction.DESC;
		    }

		    return Sort.Direction.ASC;
		  }
		
		
		public  List<Book> sortByPrice(String direction, String fieldName) {
			
			List<Book> book = new ArrayList<Book>();
			book = libraryRepository.findAll(Sort.by(getSortDirection(direction), fieldName));
			return book;
		}
       public  List<Book> sortByRating(String direction, String fieldName) {
			
			List<Book> book = new ArrayList<Book>();
			book = libraryRepository.findAll(Sort.by(getSortDirection(direction), fieldName));
			return book;
		}
       
       public  List<Book> sortByAuthor(String direction, String fieldName) {
			
			List<Book> book = new ArrayList<Book>();
			book = libraryRepository.findAll(Sort.by(getSortDirection(direction), fieldName));
			return book;
		}
       public  List<Book> sortByBookName(String direction, String fieldName) {
			
			List<Book> book = new ArrayList<Book>();
			book = libraryRepository.findAll(Sort.by(getSortDirection(direction), fieldName));
			return book;
		}
     
}


package libraryManagement.Service;

import java.util.List;

import libraryManagement.Model.*;


/* This is an Interface.
 * It is a service interface for this project.
 * In this interface there are some abstract methods which are overrriden in the implementation class.
 * This interface consists of buisness tools for this project which are controlled by controller class.
 */


// This is the Interface named as LibraryService
public interface LibraryService {
	
    // This method is used to create a book record by taking book type objects
	Book saveBook(Book book);
	
	
	
	//This method is used to get a book record from database using "bisbn" as reference or search element.
	Book getBookByISBN(Integer book_isbn);
	
	
	//This method is used to update a record in database using "bisbn" s search element and updates all book type objects specified.
	Book updateBookDetails(Book newVal, Integer book_isbn );
	
	//This method is used to delete a record in the database using "bisbn" as search element.
	void deleteBookByISBN(Integer book_isbn);
	
	//This is a method which deletes all books.
	void deleteAllBooks();
	
	
	
	//This method returns the books based on search and filter operations.
	List<Book> getBooksFromDb(String bookName);
	
}

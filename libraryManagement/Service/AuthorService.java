package libraryManagement.Service;
import java.util.List;

import libraryManagement.Model.*;

public interface AuthorService {
	
	Author saveAuthor(Author author);
	Author getAuthorById(Integer authorId);
	Author updateAuthorDetails(Author newAuthor,Integer authorId);
	void deleteAuthorById(Integer authorId);
	void deleteAllAuthors();
	List<Author>getAllAuthors();
}

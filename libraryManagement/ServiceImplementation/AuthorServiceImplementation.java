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

@Service
public class AuthorServiceImplementation implements AuthorService {
    @Autowired
	private AuthorRepository authorRepository;
    
    public   AuthorServiceImplementation(AuthorRepository authorRepository ){
    	this.authorRepository=authorRepository;
    }
	@Override
	public Author saveAuthor(Author author) {
		
		return authorRepository.save(author);
	}

	@Override
	public Author getAuthorById(Integer authorId) {
		Optional<Author> author = authorRepository.findById(authorId);
		if(author.isPresent())
			return author.get();
		else
			return null;
		
	}

	@Override
	public Author updateAuthorDetails(Author newAuthor, Integer authorId) {
		Optional<Author> author = authorRepository.findById(authorId);
		if(author.isPresent()) {
			Author existingAuthor = author.get();
		    existingAuthor.setQualifications(newAuthor.getQualifications());
		    existingAuthor.setAuthorEmail(newAuthor.getAuthorEmail());
		    authorRepository.save(existingAuthor);
		    return existingAuthor;
		
	}
		else {
			return null;
		}
	}
	@Override
	public void deleteAuthorById(Integer authorId) {
		Optional<Author> author = authorRepository.findById(authorId);
		if(author.isPresent())
			 authorRepository.deleteById(authorId);
		
	}

	@Override
	public void deleteAllAuthors() {
		authorRepository.deleteAll();
		System.out.println("All Authors are deleted");
		
	}
	@Override
	public List<Author> getAllAuthors() {
		List<Author> authors = new ArrayList<Author>();
		authors = authorRepository.findAll();
		return authors;
	}

	public List<Author> fetchAuthorByIgnoringCase(String authorName){
		List <Author> author = new ArrayList<Author>();
		 authorRepository.findByAuthorNameContainingIgnoreCase(authorName).forEach(author::add);
		return author;
	}
	

}

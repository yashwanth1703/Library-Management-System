package libraryManagement.Repository;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import libraryManagement.Model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer>{
	List<Author> findByAuthorNameContainingIgnoreCase(String authorName);
	

}

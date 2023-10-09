package libraryManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import libraryManagement.Model.Book;


/* This is the Repository interface for the project.
 * This interface extends the Jpa Repository interface.
 */

@Repository
@Transactional
public interface LibraryRepository extends JpaRepository<Book,Integer> {

	List<Book> findByIsPublished(boolean booleanObj);

	Iterable<Book> findByBookNameContainingIgnoreCase(String book_name);


	List<Book>findByAuthorContainingIgnoreCase(String book_author);
	
//	@Modifying
//    @Query("update table b set b.card=:#{#book?.card},b.available=:#{#book?.available} where b.id=:#{#book?.id}")
//    int updateBook(@RequestParam("book") Book book);

}

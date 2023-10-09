package libraryManagement.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import libraryManagement.Model.LibraryUser;

@Repository
public interface LibraryUserRepository extends JpaRepository<LibraryUser,Integer>{
	@Query(value = "SELECT * FROM LIBRARY_USER lu WHERE lu.user_email = ?1",nativeQuery = true  )
	public Optional<LibraryUser> findByuserEmail(String email);
	@Query(value = "SELECT * FROM LIBRARY_USER lu WHERE lu.user_email = ?1 AND u.user_password = ?2 ",nativeQuery = true  )
	public Optional<LibraryUser> findByuserEmailAndPassword(String email, String password);
	
//	@Modifying
//	@Transactional
//    @Query(value="update library_user s set s.user_email= :user.user_email" +
//                       " where s.user_id=?1",nativeQuery=true)
 //  public int updateStudentDetails(@Param(value="userId")Integer userId ,@Param("student")LibraryUser user);
	
}

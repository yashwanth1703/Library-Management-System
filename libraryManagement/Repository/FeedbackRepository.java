package libraryManagement.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import libraryManagement.Model.Feedback;
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Integer>{

}

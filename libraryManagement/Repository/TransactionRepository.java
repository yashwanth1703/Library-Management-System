package libraryManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import libraryManagement.Model.TransactionDetails;
@Repository
public interface TransactionRepository extends JpaRepository<TransactionDetails,Integer> {

}

package libraryManagement.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import libraryManagement.Model.*;
import libraryManagement.Repository.CardRepository;
import libraryManagement.Repository.LibraryRepository;
import libraryManagement.Repository.LibraryUserRepository;
import libraryManagement.Repository.TransactionRepository;
import libraryManagement.Service.TransactionService;
@Service
public class TransactionServiceImplementation implements TransactionService {
	@Autowired
  private LibraryRepository libraryRepository;
	@Autowired
	private CardRepository cardRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private LibraryServiceImplementation libraryService;
	@Autowired
	private LibraryUserRepository libraryUserRepository;
	@Autowired
	private LibraryEmailService emailService;
    
	@Autowired 
	private TwilioConfig twilioConfig;
	
	//@Autowired
	//emailservice
	@Value("${books.max_allowed}")
    int max_allowed_books;
    @Value("${books.max_allowed_days}")
    int max_days_allowed;
    @Value("${books.fine.per_day}")
    int fine_per_day;
    
	@Override
	public void returnBook() {
		
		
	}

	@Override
	public void issueBook(Integer userId, Integer bookId)throws Exception {
		
		
	    Book book = libraryRepository.findById(bookId).get();
	  //  CardDetails card = cardRepository.findById(cardId).get();
	    Optional<LibraryUser> user = libraryUserRepository.findById(userId);
	  
	    if(book==null||book.isAvailable()==false) {
	    	throw new Exception ("Wrong Book Details ");
	    }
	    else if(user.get().getCard().cardStatus().DEACTIVATED==null) {
	    	throw new Exception("Inavlid Card");
	    }
	    else if(max_allowed_books>3) {
	    	throw new Exception("Reached Maximum Limit");
	    }
       book.setIsAvailable(false);
       book.setNoOfBooks(book.getNoOfBooks()-1);
       CardDetails cardOfRespectiveUser = user.get().getCard();
       book.setCard(cardOfRespectiveUser);
    List<Book> books = cardOfRespectiveUser.getBooks(); 
    books.add(book);
    cardOfRespectiveUser.setBooks(books);
	   libraryService.updateBookDetails(book, bookId);
	   TransactionDetails transaction = new TransactionDetails();
	   transaction.setCard(cardOfRespectiveUser);
	   transaction.setBook(book);
	   transaction.setTransactionStatus(transaction.transactionStatus().SUCCESSFUL);
	   transactionRepository.save(transaction);
	   emailService.sendEmail(cardOfRespectiveUser.getStudent().getUserEmail(), "Book Issued!!!", "details of the book");
	   
}
	@Override
	public void deleteBook(Integer BookId) {
		Optional<Book>book = libraryRepository.findById(BookId);
		if(book.isPresent())
		     libraryRepository.deleteById(BookId);
	}
	
	public void deleteAllTransactions() {
		libraryRepository.deleteAll();
	}

	@Override
	public String otpGenerator(Integer userId) {
		LibraryUser user = libraryUserRepository.findById(userId).get();
		String str = OTPGenerator.generateOtp();
		emailService.sendEmail(user.getUserEmail(), "Otp for validation", str);
		return str;
	}
	
	public String otpGeneration(Integer userId) {
		LibraryUser user = libraryUserRepository.findById(userId).get();
		String str = OTPGenerator.generateOtp();
		PhoneNumber to = new PhoneNumber("+919944789644");
		PhoneNumber from = new PhoneNumber("+14707983677");
		String otpMessage = "Dear Customer , Your OTP is  " + str + " for sending sms through Spring boot application. Thank You.";
		Message message = Message.creator(to, from,otpMessage).create();
		return str;
	}
	
	 
}

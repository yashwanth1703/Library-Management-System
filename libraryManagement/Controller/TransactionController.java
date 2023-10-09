package libraryManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import libraryManagement.Model.Book;
import libraryManagement.Model.TransactionDetails;
import libraryManagement.ServiceImplementation.TransactionServiceImplementation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Transaction.com")
public class TransactionController {
	
 @Autowired
 private TransactionServiceImplementation transactionService;
 
 public TransactionController(TransactionServiceImplementation transactionService) {
	 this.transactionService=transactionService;
	 
 }
 //http://localhost:8080/Transaction.com/purchaseBook/3/1
 @GetMapping("/purchaseBook/{userId}/{bookId}")
 public void purchaseBook(@PathVariable("userId")Integer userId,@PathVariable("bookId")Integer bookId )throws Exception{
	 transactionService.issueBook(userId, bookId);
	 
	 
 }
 public ResponseEntity<TransactionDetails>returnBook(){
	 return null;
 }
 @GetMapping("/getOtp/{userId}")
 public String getOTP(@PathVariable("userId")Integer userId)throws Exception {
	 return transactionService.otpGenerator(userId);
 }
 @GetMapping("/getOtpMobile/{userId}")
 public String getOTPMobile(@PathVariable("userId")Integer userId)throws Exception {
	 return transactionService.otpGeneration(userId);
 }
}

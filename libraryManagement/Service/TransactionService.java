package libraryManagement.Service;

import libraryManagement.Model.Book;

public interface TransactionService {
 
	public void issueBook(Integer userId,Integer bookId)throws Exception;
	
	public void returnBook();
	
	public void deleteBook(Integer bookId);
	
	public String otpGenerator(Integer userId);
}

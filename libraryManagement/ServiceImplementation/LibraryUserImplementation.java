package libraryManagement.ServiceImplementation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import libraryManagement.Model.Book;
import libraryManagement.Model.CardDetails;
import libraryManagement.Model.LibraryUser;
import libraryManagement.Repository.CardRepository;
import libraryManagement.Repository.LibraryRepository;
import libraryManagement.Repository.LibraryUserRepository;

@Service
public class LibraryUserImplementation {
	
@Autowired
private LibraryUserRepository libraryUserRepository;

@Autowired 
private CardRepository cardRepo;

@Autowired
private CardServiceImpl cardService;

@Autowired
private LibraryRepository libraryRepository;


 public void addUser(LibraryUser libUser)throws Exception {
	 CardDetails card = cardService.createCard(libUser);
	 this.libraryUserRepository.save(libUser);
 }
 public Optional<LibraryUser> getUserByEmail(String email)throws Exception{
	 return this.libraryUserRepository.findByuserEmail(email);
	
 }
 public LibraryUser updateUserById(Integer userId,LibraryUser libuser)throws Exception {
	Optional<LibraryUser> user = libraryUserRepository.findById(userId);
	if(user.isPresent()) {
		LibraryUser existingUser = user.get();
		existingUser.setUserEmail(libuser.getUserEmail());
		libraryUserRepository.save(existingUser);
		return existingUser;
	}
	else
		return null;
 }
 
 public void deleteUserById(Integer userId)throws Exception {
	 Optional<LibraryUser> user = this.libraryUserRepository.findById(userId);
	 if(user.isPresent())
		 cardRepo.delete(user.get().getCard());
		 libraryUserRepository.deleteById(userId);
	 
 }
 
 public List<LibraryUser> getAllUsers() {
	 List<LibraryUser> users = new ArrayList<LibraryUser>();
	 users=libraryUserRepository.findAll();
	 return users;
 }
 public LibraryUser getUserById(Integer userId) {
	 Optional<LibraryUser> user = libraryUserRepository.findById(userId);
	 
	 if(user.isPresent())
		 return user.get();
	 else
		 return null;
 }
 public void deleteAllUsers() {
	 libraryUserRepository.deleteAll();
	 System.out.println("All users are deleted");
 }
 
 public List<Book> getBooksById(Integer userId){
	 List<Book> booklist = new ArrayList<Book>();
	 Optional<LibraryUser> user = libraryUserRepository.findById(userId);
	 CardDetails card = user.get().getCard();
	 Optional<CardDetails> cardDetails=cardRepo.findById(card.getId());
	CardDetails userCard = cardDetails.get();
	for(int ctr = 0; ctr < userCard.getBooks().size(); ctr++)
		booklist.add(userCard.getBooks().get(ctr));
	System.out.println(booklist.size());
	return booklist;
	
 }
}

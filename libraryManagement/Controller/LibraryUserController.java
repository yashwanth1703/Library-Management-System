package libraryManagement.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import libraryManagement.ServiceImplementation.CardServiceImpl;
import libraryManagement.ServiceImplementation.LibraryUserImplementation;
import libraryManagement.Model.CardDetails;
import libraryManagement.Model.LibraryUser;
import libraryManagement.Repository.CardRepository;
@RestController
@CrossOrigin
@RequestMapping("/library.com")
public class LibraryUserController {
	@Autowired
	private LibraryUserImplementation libUserService;
//	@Autowired
//	private CardServiceImpl cardService;
	@GetMapping("/login")
	public ResponseEntity<Map<String,String>> login(@RequestParam("email") String email,@RequestParam("password") String password)throws Exception
	{
		Optional<LibraryUser> existingUser=this.libUserService.getUserByEmail(email);
		Map<String,String> response=new HashMap<String,String>();
		if(existingUser.isPresent())
		{
			if(existingUser.get().getUserPassword().equals(password))
			{
				response.put("status", "success");
				response.put("message", "User authenticated");
				response.put("userId",String.valueOf( existingUser.get().getUserId()) );
				response.put("userRole", existingUser.get().getRole());
				response.put("userName", existingUser.get().getUserName());
				return new ResponseEntity<Map<String,String>>(response,HttpStatus.OK);
			}
			else
			{
				response.put("status", "Failed");
				response.put("message", "User password inncorrect");
				return new ResponseEntity<Map<String,String>>(response,HttpStatus.NOT_FOUND);
			}
		}		
		else
		{
			response.put("status", "Failed");
			response.put("message", "User email does not exist");
			return new ResponseEntity<Map<String,String>>(response,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/signup")
	public ResponseEntity<Map<String,String>> signup(@RequestBody LibraryUser user)throws Exception
	{
		this.libUserService.addUser(user);
		Map<String,String> response=new HashMap<String,String>();
		response.put("status", "success");
		response.put("message", "User registered!!");

		return new ResponseEntity<Map<String,String>>(response,HttpStatus.CREATED);
	}
  @PutMapping("/updateUser/{userId}")
  public ResponseEntity<LibraryUser> udpdateUser(@PathVariable("userId") Integer userId,@RequestBody LibraryUser user)throws Exception{
   
	 return new ResponseEntity<LibraryUser>(libUserService.updateUserById(userId, user),HttpStatus.OK);
   }
  @DeleteMapping("/deleteUser/{userId}")
   public void deleteUser(@PathVariable("userId") Integer userId)throws Exception{
	   libUserService.deleteUserById(userId);
   }
  @GetMapping("/viewAllUsers")
  public ResponseEntity<List<LibraryUser>> viewUsers() throws Exception{
	  return new ResponseEntity<List<LibraryUser>>(libUserService.getAllUsers(),HttpStatus.OK);
	  
  }
  @GetMapping("/viewUser/{userId}")
  public ResponseEntity<LibraryUser>viewUser(@PathVariable("userId")Integer userId)throws Exception{
	  return new ResponseEntity<LibraryUser>(libUserService.getUserById(userId),HttpStatus.OK);
  }
  
  @DeleteMapping("/removeAllUsers")
  public void removeAllUsers() throws Exception{
	  libUserService.deleteAllUsers();
  }
  
}	





package libraryManagement.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import libraryManagement.Model.CardDetails;
import libraryManagement.Model.LibraryUser;
import libraryManagement.Repository.CardRepository;
import libraryManagement.Model.*;

@Service
public class CardServiceImpl {
@Autowired
 private CardRepository cardRepo;

public CardDetails createCard(LibraryUser user) {
	CardDetails card = new CardDetails();
	user.setCard(card);
	card.setStudent(user);
	cardRepo.save(card);
	return card;
}
//public void deactivate(int userId){
//    cardRepo.deactivateCard(userId, CardStaus.DEACTIVATED.toString());
//
//}

public CardDetails viewCard(Integer cardId) {
	Optional<CardDetails> card = cardRepo.findById(cardId);
	if(card.isPresent()) {
		return card.get();
		
	}
	else
		return null;
}
 
public List<CardDetails> viewAllCards(){
	List<CardDetails> cards = cardRepo.findAll();
	return cards;
}

}
package libraryManagement.Model;

import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@DynamicUpdate
public class CardDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Integer id;


    @OneToOne(mappedBy = "card",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private LibraryUser user;
    
    @Enumerated(value=EnumType.STRING)
    private CardStaus cardStatus;
    
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Book> books;
    
    public CardDetails() {
    	this.cardStatus= cardStatus.ACTIVATED;
    }
    
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer cardId) {
		this.id = cardId;
	}

	public LibraryUser getStudent() {
		return user;
	}

	public void setStudent(LibraryUser user) {
		this.user = user;
	}
    public CardStaus cardStatus() {
    	return cardStatus;
    }
	public CardStaus getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(CardStaus cardStatus) {
		this.cardStatus = cardStatus;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
    
    
}

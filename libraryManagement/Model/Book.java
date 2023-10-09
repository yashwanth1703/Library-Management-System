package libraryManagement.Model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import libraryManagement.Model.*;

/* This is the Book class for the project.
 * In this class all the attributes for the library are present. 
 * All are encapsulated so we derived getters and setters for each attribute.
 * Here the @Entity is used on the class to create a table in the database with same name of class or different name as specified.
 * Here @Dynamic update is used to check specified records for faster operations.
 * Even toString method is also used for displaying the ouput objects.
 */
@Entity(name = "library_details")
@DynamicUpdate
public class Book {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_ISBN")
	private Integer bookISBN;
	@Column(name = "book_name",length = 10,nullable = false)
	private String bookName;
	@Column(name = "book_author",length = 20,nullable = false)
	private String author;
	@Column(name = "NoOfBooks")
	private Integer noOfBooks;
	@Column(name = "book_Cost")
	private Double bookCost;
	@Column
	private Boolean isPublished;
	@Column
	@Min(value=1)
	@Max(value=10)
	private Double ratingOfBook;
	
	private Boolean isAvailable;
	
	@Column(name="genere")
	private String categoryDetails;

	
	
	@ManyToOne
    @JoinColumn(name="card")
    @JsonIgnore
    public CardDetails card;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="author_Id")
	
	private Author authorsBook;
	
	@OneToMany(mappedBy = "book",cascade=CascadeType.ALL,orphanRemoval = true)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	private List<Feedback> feedbackList = new ArrayList<Feedback>();
	
	@OneToMany(mappedBy = "book",cascade=CascadeType.ALL,orphanRemoval = true)
	
	@JsonIgnore
	private List<TransactionDetails> transaction = new ArrayList<TransactionDetails>();
	
	
	public List<Feedback> getFeedbackList() {
		return feedbackList;
	}
	public void setFeedbackList(List<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}

	public Integer getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(Integer bookISBN) {
		this.bookISBN = bookISBN;
	}
	public String getCategoryDetails() {
		return categoryDetails;
	}
	public void setCategoryDetails(String categoryDetails) {
		this.categoryDetails = categoryDetails;
	}
	
	

	
	public List<TransactionDetails> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<TransactionDetails> transaction) {
		this.transaction = transaction;
	}
	public CardDetails getCard() {
		return card;
	}
	public void setCard(CardDetails card) {
		this.card = card;
	}
	
	
	
	public Author getAuthorsBook() {
		return authorsBook;
	}
	public void setAuthorsBook(Author authorsBook) {
		this.authorsBook = authorsBook;
	}
	
	
	
	public Boolean getIsPublished() {
		return isPublished;
	}
	public void setIsPublished(Boolean isPublished) {
		this.isPublished = isPublished;
	}
	
	
	public String getBookName(){
		return bookName;
	}
	public void setbookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	
	public Integer getNoOfBooks() {
		return noOfBooks;
	}
	public void setNoOfBooks(Integer noOfBooks) {
		this.noOfBooks = noOfBooks;
	}
	public Double getBookCost() {
		return bookCost;
	}
	public void setBookCost(Double bookCost) {
		this.bookCost = bookCost;
	}
	public Double getRatingOfBook() {
		return ratingOfBook;
	}
	public void setRatingOfBook(Double ratingOfBook) {
		this.ratingOfBook = ratingOfBook;
	}
	public Boolean isAvailable() {
		return isAvailable;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "Book [bookISBN=" + bookISBN + ", bookName=" + bookName + ", author=" + author + ", noOfBooks="
				+ noOfBooks + ", bookCost=" + bookCost + ", isPublished=" + isPublished + ", ratingOfBook="
				+ ratingOfBook + ", isAvailable=" + isAvailable + ", categoryDetails=" + categoryDetails + ", card="
				+ card + ", authorsBook=" + authorsBook + ", feedbackList=" + feedbackList + ", transaction="
				+ transaction + "]";
	}
	
}



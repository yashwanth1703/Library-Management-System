package libraryManagement.Model;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedBackId;   //45334
	
	@Min(value=1, message="Rating must be in range of 1-5")
	@Max(value=5, message="Rating must be in range of 1-5")
	private Integer bookRating;  //434344
	
	@Min(value=1, message="Rating must be in range of 1-5")
	@Max(value=5, message="Rating must be in range of 1-5")
	private Integer overallRating; //34344
	
	private String comments; //rtrttrtr

	
	@ManyToOne
	@JsonIgnore
	private LibraryUser user;  //all the attr of lib user entity class
	
	@ManyToOne
	@JsonIgnore
	@OnDelete(action=OnDeleteAction.CASCADE)

	private Book book;
	
	@Override
	public String toString() {
		return "Feedback [feedBackId=" + feedBackId + ", bookRating=" + bookRating + ", overallRating=" + overallRating
				+ ", comments=" + comments + ", user=" + user + ", book=" + book + "]";
	}

	public Integer getFeedBackId() {
		return feedBackId;
	}

	public void setFeedBackId(Integer feedBackId) {
		this.feedBackId = feedBackId;
	}

	public Integer getBookRating() {
		return bookRating;
	}

	public void setBookRating(Integer bookRating) {
		this.bookRating = bookRating;
	}

	public Integer getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(Integer overallRating) {
		this.overallRating = overallRating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LibraryUser getUser() {
		return user;
	}

	public void setUser(LibraryUser user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	
}

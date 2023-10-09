package libraryManagement.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@DynamicUpdate
public class LibraryUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@Column(length = 100, nullable = false)
	private String userName;

	@Column(length = 20, updatable = true)
	@Size(min = 8, max =20,message = "password must be between 8 to 20 characters long.")
	private String userPassword;


	@Column(length = 50, updatable = true, unique = true)
	@Email(message = "Email id format is incorrect.")
	private String userEmail;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@Column
	private LocalDate dob;

	@Column(length = 150, updatable = true)
	private String about;

	@Column(length = 20, nullable = false, updatable = true)
	private String role;
	
	@OneToOne
	@JsonIgnore
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn
	private CardDetails card;
	
	
	@OneToMany(mappedBy = "user")
	@OnDelete(action = OnDeleteAction.CASCADE)
    private List<Feedback> feedbackList = new ArrayList<>();
	
	private String phoneNumber;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Feedback> getFeedbackList() {
		return feedbackList;
	}

	public void setFeedbackList(List<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}

	public CardDetails getCard() {
		return card;
	}

	public void setCard(CardDetails card) {
		this.card = card;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LibraryUser [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userEmail=" + userEmail + ", dob=" + dob + ", about=" + about + ", role=" + role + "]";
	}
	

}

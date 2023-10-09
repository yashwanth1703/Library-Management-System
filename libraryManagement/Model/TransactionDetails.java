package libraryManagement.Model;
import java.time.LocalDate;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
@DynamicUpdate
public class TransactionDetails {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer transactionId;
	private Integer fineAmount;
	@Enumerated(value=EnumType.STRING)
	private TransactionStatus transactionStatus;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private LocalDate issueDate;
	@ManyToOne
	private CardDetails card;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Book book;
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public Integer getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(Integer fineAmount) {
		this.fineAmount = fineAmount;
	}
	public TransactionStatus transactionStatus() {
		return transactionStatus;
	}
	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public CardDetails getCard() {
		return card;
	}
	public void setCard(CardDetails card) {
		this.card = card;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "TransactionDetails [transactionId=" + transactionId + ", fineAmount=" + fineAmount
				+ ", transactionStatus=" + transactionStatus + ", issueDate=" + issueDate + ", card=" + card + ", book="
				+ book + "]";
	}
	

}

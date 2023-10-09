package libraryManagement.Service;

import java.util.List;

import libraryManagement.Model.Feedback;
public interface FeedbackService {

public Feedback addFeedBack(Feedback feedBack,Integer bookId, Integer userId) throws Exception;
	

	public void deleteFeedBack(Integer feedbackId) throws Exception;

	public Feedback viewFeedback(Integer bookId) throws Exception;

	public List<Feedback> viewFeedbackAll() throws Exception ;
	
	public void deleteFeedbacks();
	
	
}

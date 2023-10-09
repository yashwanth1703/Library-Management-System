import { Component,OnInit } from '@angular/core';
import { FeedbackService } from '../feedback.service';
import { feedback } from '../Feedback';
import { Router } from '@angular/router';
import { Book } from '../Book';
import { Author } from '../Author';
import { User } from '../User';
import { LibraryServiceService } from '../library-service.service';
import { UserService } from '../user.service';


@Component({
  selector: 'app-feed-back-list',
  templateUrl: './feed-back-list.component.html',
  styleUrls: ['./feed-back-list.component.css']
})
export class FeedBackListComponent implements OnInit{
  feedbacks: feedback[] = [];
 
  count : number = 4;
  p : number = 1;

  constructor(private feedbackService: FeedbackService,
    private router: Router) { }

  ngOnInit(): void {
    this.getAllFeedbacks();
  }

  getAllFeedbacks(): any {
    this.feedbackService.viewAllFeedbacks().subscribe(data => {
      this.feedbacks = data,
      console.log(this.feedbacks)
    })
  }

  deleteFeedback(id : number){
    var status = confirm("Are you sure to delete this record?");
    if (status == true) {
    this.feedbackService.deleteFeedback(id).subscribe( data => {
      this.getAllFeedbacks();
    })
  }
    else{
      this.getAllFeedbacks();
    }
  
  }

  viewFeedback(id : number){
    
    this.router.navigate(['view-feedback', id]);
  }
   removeAllFeedbacks(){
    var status = confirm("Are you sure you want to delete all records?")
    if(status==true){
      this.feedbackService.deleteAllFeedbacks().subscribe(data=>{
        this.feedbacks=data;
        console.log(data);
      })
    }
    else{
      this.getAllFeedbacks();
    }
   }
}

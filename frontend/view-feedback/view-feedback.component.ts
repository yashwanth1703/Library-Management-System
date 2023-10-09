import { Component, OnInit } from '@angular/core';
import { FeedbackService } from '../feedback.service';
import { ActivatedRoute, Router } from '@angular/router';
import { feedback } from '../Feedback';

@Component({
  selector: 'app-view-feedback',
  templateUrl: './view-feedback.component.html',
  styleUrls: ['./view-feedback.component.css']
})
export class ViewFeedbackComponent implements OnInit {
  constructor(private feedbackService:FeedbackService,private route:ActivatedRoute,private router:Router){}
  id:number;
  particularFeedback:feedback=new feedback();
  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    console.log(this.id);
    this.feedbackService.viewfeedback(this.id).subscribe(data=>{
      this.particularFeedback=data;
      console.log(this.particularFeedback);
    })
  }
  getAllFeedbacks(){
    this.router.navigate(['feed-back-list']);
  }
  
}

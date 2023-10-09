import { Component,OnInit } from '@angular/core';
import { feedback } from '../Feedback';
import { FeedbackService } from '../feedback.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../Book';
import { User } from '../User';
import { LibraryServiceService } from '../library-service.service';
import { UserService } from '../user.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-feedback',
  templateUrl: './add-feedback.component.html',
  styleUrls: ['./add-feedback.component.css']
})
export class AddFeedbackComponent implements OnInit {
 id:number;
 user:number;
 books:Book[]=[];
 selectedBookIds:number[]=[];
 i:number;
 users:User[]=[];
 usersId:any;
 

  constructor(private feedbackService:FeedbackService,private router:Router,private libraryService:LibraryServiceService,private userService:UserService,private route:ActivatedRoute){}

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.libraryService.getBooksList().subscribe(data=>{
      this.books=data;
      console.log(this.books);
    })
    this.userService.viewAllUsers().subscribe(data=>{
      this.users=data;
      console.log(this.users);
      // var uid = this.users.userId;
    }
      )
    
     }
     
     addFeedback = new FormGroup({
      comments:new FormControl('',[Validators.required])
     })
     
     get comments(){
      return this.addFeedback.get('comments');
     }
     
  feedback:feedback = new feedback();

  
  getFeedbackList(){
    this.router.navigate([`feed-back-list`]);
  }
  OnSubmit(bookId:number){
    
    this.feedbackService.addFeedback(this.feedback,bookId,this.id).subscribe(data=>{
     console.log(data);
    this.router.navigate(['feed-back-list']);

    }
      )

  }

}
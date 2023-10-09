import { Component,OnInit } from '@angular/core';
import { LibraryServiceService } from '../library-service.service';
import { ActivatedRoute,Router } from '@angular/router';
import { Book } from '../Book';
import { feedback } from '../Feedback';
import { FeedbackService } from '../feedback.service';
import { AuthorService } from '../author.service';
import { Author } from '../Author';
import { TransactionService } from '../transaction.service';
import { Transaction } from '../Transaction';
import { TransactionComponent } from '../transaction/transaction.component';



@Component({
  selector: 'app-veiw-book',
  templateUrl: './veiw-book.component.html',
  styleUrls: ['./veiw-book.component.css']
})
export class VeiwBookComponent implements OnInit {
  ids:any;
  id:number=0;
  userId:any;
  particularBook : Book = new Book();
  particularFeedback:feedback;
  particularAuthor:any;
  transaction:Transaction=new Transaction("Successfull");
  otp:any;
  user:any;
  books:any;
  mobileOtp:any;
  constructor(private route: ActivatedRoute, private libraryService: LibraryServiceService,private router : Router,private feedbackService:FeedbackService,private authorService:AuthorService,private transactionService:TransactionService) { }
  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    

    this.libraryService.getBookById(this.id).subscribe(data =>{
      this.particularBook = data;
      this.particularAuthor=data.authorsBook;
      console.log(this.particularAuthor);
      console.log(this.particularBook)
     
      
    })
    
  }
  viewAuthor(id:number){
    this.authorService.viewAuthor(id).subscribe(data=>{
      this.particularAuthor=data;
      console.log(this.particularAuthor);
    })
     

    }
    getBooksList(){
      this.router.navigate(['library']);
    }

    buyNow(){
      this.user=sessionStorage.getItem('userId');
    this.transactionService.getOtp(this.user).subscribe(data=>{
      this.otp=data;
      console.log(this.otp);
    })
    this.transactionService.getOtpMobile(this.user).subscribe(data=>{
      this.mobileOtp=data;
      console.log(this.otp);
    })
    }
  
   purchaseBook(otp:any){
    if( otp == this.otp||otp==this.mobileOtp){
      alert('OTP verified successfully.');
      this.ids = sessionStorage.getItem('userId');
      this.transactionService.issueBook(this.ids,this.id).subscribe( 
      data =>{
      this.books = data;
      console.log(data);
      
      this.router.navigate(['library']);
      });
    }
    else{
      alert('Invalid OTP...');
      console.log("Varified failed...");
      this.router.navigate(['library']);
    }
  
   }
}


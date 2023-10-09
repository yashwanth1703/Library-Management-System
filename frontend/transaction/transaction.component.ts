import { Component,OnInit } from '@angular/core';
import { Transaction } from '../Transaction';
import { Router,ActivatedRoute} from '@angular/router';
import { TransactionService } from '../transaction.service';
import { LibraryServiceService } from '../library-service.service';
import { Book } from '../Book';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {
  cardId:number;
  bookId:any;
  book:Book[]=[];
  constructor(private router:Router,private transactionService:TransactionService,private libraryService:LibraryServiceService){}
  ngOnInit(): void {
    this.libraryService.getBooksList();
  }
  purchaseBook():any{
    this.libraryService.getBookById(this.bookId).subscribe(data=>{
      this.bookId=data;
      console.log(this.book);
     
    })
  }
}

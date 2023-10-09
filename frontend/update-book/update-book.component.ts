import { Component,OnInit } from '@angular/core';
import { LibraryServiceService } from '../library-service.service';
import { Book } from '../Book';
import { ActivatedRoute,Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {

  id:number=0;
  book:Book=new Book();
  constructor(private libraryService:LibraryServiceService,private route:ActivatedRoute,private router:Router){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    
    this.libraryService.getBookById(this.id).subscribe(data => {
      this.book = data;

    },error => console.log(error));
    
    
  }

  updateBook=new FormGroup({
    bookCost:new FormControl('',[Validators.required,Validators.min(100)]),
    ratingOfBook:new FormControl('',[Validators.required,Validators.min(1),Validators.max(10)])
  })
  
  get bookCost(){
    return this.updateBook.get('bookName');
  }
  get ratingOfBook(){
    return this.updateBook.get('ratingOfBook');
  }


  onSubmit(){
    this.libraryService.updateBook(this.id,this.book).subscribe(data=>{
      this.getAllBooks();
    } ,error => console.log(error));
  }
  getAllBooks(){
    this.router.navigate(['/library']);
  }

}

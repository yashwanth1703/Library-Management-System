import { Component,OnInit } from '@angular/core';
import { Book } from '../Book';
import { LibraryServiceService } from '../library-service.service';
import { Router } from '@angular/router';
import { AuthorService } from '../author.service';
import { Author } from '../Author';
import { FormBuilder,FormControl,FormGroup,Validators } from '@angular/forms';

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {
 
  constructor(private libraryService : LibraryServiceService,
    private router: Router,private authorService:AuthorService) { }
  
    
    authorName:any;
    authors:any;
    selectedAuthorsIds:number[]=[];
    i:number;
    books:any;
    ctr:any;
  ngOnInit(): void {
    this.authorService.viewAllAuthors().subscribe(data=>{
      this.authors=data;
      console.log(this.authors)
    })
  }


   createBook=new FormGroup({
    bookName:new FormControl('',[Validators.required,Validators.pattern('[a-zA-z]+$')]),
    bookCost:new FormControl('',[Validators.required,Validators.min(100)]),
    noOfBooks:new FormControl('',[Validators.required,Validators.min(1)]),
    ratingOfBook:new FormControl('',[Validators.required,Validators.min(1),Validators.max(10)]),
    categoryDetails:new FormControl('',[Validators.required,Validators.pattern('[A-Z]+$')]),

   })

   get bookName(){
    return this.createBook.get('bookName');
   }
   get bookCost(){
    return this.createBook.get('bookCost');
   }
   get noOfBooks(){
    return this.createBook.get('noOfBooks');
   }
   get ratingOfBook(){
    return this.createBook.get('ratingOfBook');
   }
   get categoryDetails(){
    return this.createBook.get('categoryDetails');
   }

    book : Book = new Book();

    saveBook(Id:any){
       console.log(this.book)
       console.log(this.authors.authorId);
       
       if(Id=="Willson"){
        this.ctr=1;
       }
       else if(Id=="Clark"){
        this.ctr=2;
       }
       else if(Id=="Harrison"){
        this.ctr=3;
       }
       else if(Id=="Mitchell"){
        this.ctr=4;
       }
       else if(Id=="Ford"){
        this.ctr=5;
       }
      this.libraryService.createBook(this.book,this.ctr).subscribe( data =>{
        this.books=data;
        console.log(data);
        this.getBooksList();
      },
      error => console.log(error));

      
    }
  getBooksList() {
    this.router.navigate(['/library']);
  }
  
 



}

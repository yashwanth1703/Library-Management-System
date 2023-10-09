import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LibraryServiceService } from '../library-service.service';
import { Book } from '../Book';

import { AuthorService } from '../author.service';
import { UserService } from '../user.service';



@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
books : Book[]=[]
bookName:string ="";
author:string="";

book:Book=new Book();
count : number = 4;
p : number = 1;
constructor(private LibraryService:LibraryServiceService,private router : Router,private authorService:AuthorService,private userService:UserService) {}



ngOnInit(): void {
  this.getAllBooks();
}

private getAllBooks() : any{
 this.LibraryService.getBooksList().subscribe(data => {
  this.books=data;
  // this.authorService.viewAllAuthors().subscribe(details=>{
  //   this.book = details.authorsBook.authorName;
  // })
  console.log(data);
 })

}


removeAllBooks(){
    var status = confirm("Are you sure to delete all the records?");
    if (status == true) {
      this.LibraryService.deleteAll().subscribe(details => {
        console.log(details);  //null
        this.getAllBooks();
      },
        error => {
          console.log(error);
        })
    }
    else{
    this.getAllBooks();
  }
  }
  viewBook(id:number){   

    this.router.navigate(['veiw-book-details', id]); 

  }
  updateBook(id:number){
    this.router.navigate(['update-book',id])
  }

  deleteBook(id : number){
    var status = confirm("Are you sure to delete this record?");
    if (status == true) {
    this.LibraryService.deleteBook(id).subscribe( data => {
      this.getAllBooks();
    })
  }
    else{
      this.getAllBooks();
    }


}
searchByBookName() : any{
  this.LibraryService.findByBookName(this.bookName).subscribe(details => {
    this.books= details;
    console.log(details);
  },
    error => {
      console.log(error);
    });
}
searchByBookAuthor():any{
  this.LibraryService.findByBookAuthor(this.author).subscribe(details=>{
    this.books=details;
    console.log(details);
  },error=>{
      console.log(error);
  }
  )
}

getPublishedBooks(){
  this.LibraryService.findByPublishedBooks().subscribe({
    next: (res) => {
    console.log(res);
    this.books = res;
  },
  error: (e) => console.error(e)
});
}

getNonPublishedBooks(){
  this.LibraryService.findByNonPublishedBooks().subscribe({
    next: (res) => {
    console.log(res);
    this.books = res;
  },
  error: (e) => console.error(e)
});
}
getBooksBySorting(option:string){
  
  switch(option){
    case "costlow":
      this.LibraryService.SortingCost("asc","bookCost").subscribe(data=>{
        this.books=data;
        console.log(data);
      },error=>{console.log(error)}
      )
      break;
      case "costHigh":
      this.LibraryService.SortingCost("desc","bookCost").subscribe(data=>{
        this.books=data;
        console.log(data)
      },error=>{console.log(error)}
      )
      break;
      case "ratinglow":
        this.LibraryService.SortRating("asc","ratingOfBook").subscribe(data=>{
          this.books=data;
          console.log(data)
        },error=>{console.log(error)}
        )
        break;
        case "ratingHigh":
          this.LibraryService.SortRating("desc","ratingOfBook").subscribe(data=>{
            this.books=data;
            console.log(data)
          },error=>{console.log(error)}
          )
          break;
        case "A to Z":
          this.LibraryService.SortByOrder("asc","bookName").subscribe(data=>{
            this.books=data;
            console.log(data);

          }),error=>{console.log(error)}
         break;
        case "Z to A":
          this.LibraryService.SortByOrder("desc","bookName").subscribe(data=>{
            this.books=data;
            console.log(data);
          }),error=>{console.log(error)}
          break;
        case "a to z":
          this.LibraryService.SortByAuthor("asc","author").subscribe(data=>{
            this.books=data;
            console.log(data);
          }),error=>{console.log(error)}
          break;
        case "z to a":
          this.LibraryService.SortByAuthor("desc","author").subscribe(data=>{
            this.books=data;
            console.log(data);
          }),error=>{console.log(error)}
         
  }

  
}
adminLogin(){
  return sessionStorage.getItem('userRole')==='ADMIN';
}

}
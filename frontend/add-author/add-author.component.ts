import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Author } from '../Author';
import { AuthorService } from '../author.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-author',
  templateUrl: './add-author.component.html',
  styleUrls: ['./add-author.component.css']
})
export class AddAuthorComponent implements OnInit {
 constructor(private authorService:AuthorService,private router:Router){}
  ngOnInit(): void {
  
  }

  addAuthor=new FormGroup({
    authorName:new FormControl('',[Validators.required,Validators.pattern('[a-zA-Z]+$')]),
    authorEmail:new FormControl('',[Validators.required,Validators.email]),
    dateOfBirth:new FormControl('',[Validators.required]),
    qualifications:new FormControl('',[Validators.required])
  })
  
  get authorName(){
    return this.addAuthor.get('authorName')
  }
  get authorEmail(){
    return this.addAuthor.get('authorEmail')
  }
  get dateOfBirth(){
    return this.addAuthor.get('dateOfBirth')
  }
  get qualifications(){
    return this.addAuthor.get('qualifications')
  }



 author:Author=new Author();
 createAuthor(){
  this.authorService.createAuthor(this.author).subscribe(data=>{
    this.author = data;
    console.log(data);
    
  },error=>{console.log(error)})
 }

 getAllAuthors(){
  this.router.navigate([`/authors`]);
 }
 OnSubmit(){
  console.log(this.author);
  this.createAuthor();
  this.router.navigate([`/authors`]);
 }

}

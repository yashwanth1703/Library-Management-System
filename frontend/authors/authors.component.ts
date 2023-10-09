import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthorService } from '../author.service';
import { Author } from '../Author';

@Component({
  selector: 'app-authors',
  templateUrl: './authors.component.html',
  styleUrls: ['./authors.component.css']
})
export class AuthorsComponent implements OnInit {
author:Author[]=[];
authorName:string="";
count:number=4;
p:number=1;

constructor(private authorService:AuthorService,private router:Router){}
ngOnInit():void{
  this.getAllAuthors();
}
 private getAllAuthors():any{
  this.authorService.viewAllAuthors().subscribe(data=>{
    this.author=data;
    console.log(data);
  })
 }

 removeAllAuthors(){
  var status = confirm("Are you sure you want to delete all authors");
  if(status==true){
    this.authorService.deleteAllAuthors().subscribe(data=>{
      console.log(data);
      this.getAllAuthors();
    },error=>{console.log(error)}
    )
  }
  else{
    this.getAllAuthors();
  }

 }
 updateAuthor(id:number){
  this.router.navigate([`update-author`,id]);
 }
 viewAuthor(id:number){
  this.router.navigate([`view-author`,id]);
 }
 deleteAuthor(id:number){
  var status=confirm("Are you sure you want o delete this author");
  if(status==true){
    this.authorService.deleteAuthor(id).subscribe(data=>{
      this.getAllAuthors();
    })
  }
  else{this.getAllAuthors()}
 }

 getAuthorByName(){
  this.authorService.findByAuthorName(this.authorName).subscribe(data=>{
    this.author=data;
    console.log(data);

  },error=>{console.log(error)})
 }
  
}
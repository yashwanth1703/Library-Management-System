import { Component,OnInit } from '@angular/core';
import { AuthorService } from '../author.service';
import { Author } from '../Author';
import { ActivatedRoute,Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-update-author',
  templateUrl: './update-author.component.html',
  styleUrls: ['./update-author.component.css']
})
export class UpdateAuthorComponent implements OnInit {
id:number=0;
author:Author=new Author();
constructor(private authorService:AuthorService,private route:ActivatedRoute,private router:Router){}
ngOnInit():void{
  this.id=this.route.snapshot.params['id'];
  this.authorService.viewAuthor(this.id).subscribe(details=>{
    this.author=details;
  },error=>{console.log(error)})
}





onSubmit(){
  this.authorService.updateAuthor(this.id,this.author).subscribe(data=>{
    this.author = data;
    console.log(data);
    this.getAllAuthors();
  },error=>{console.log(error)})
}
getAllAuthors(){
  this.router.navigate([`/authors`]);
}
}

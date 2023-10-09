import { Component,OnInit } from '@angular/core';
import { AuthorService } from '../author.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Author } from '../Author';

@Component({
  selector: 'app-view-author',
  templateUrl: './view-author.component.html',
  styleUrls: ['./view-author.component.css']
})
export class ViewAuthorComponent implements OnInit {
  id:number=0;
  particularAuthor:Author=new Author();
  constructor(private authorService:AuthorService,private route:ActivatedRoute,private router:Router){}

  ngOnInit(): void {
   this.id=this.route.snapshot.params[`id`];
   this.authorService.viewAuthor(this.id).subscribe(data=>{
    this.particularAuthor=data;
    console.log(this.particularAuthor);
   })
  }
  getAllAuthors(){
    this.router.navigate(['authors']);

  }

}

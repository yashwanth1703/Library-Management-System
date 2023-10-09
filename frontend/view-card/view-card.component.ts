import { Component,OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { card } from '../card';
import { UserService } from '../user.service';
import { User } from '../User';
import { Book } from '../Book';
@Component({
  selector: 'app-view-card',
  templateUrl: './view-card.component.html',
  styleUrls: ['./view-card.component.css']
})
export class ViewCardComponent implements OnInit {
id:number;
particularCard:card=new card();
particularUser:any;
bookList:any;

constructor(private userService:UserService,private route:ActivatedRoute,private router : Router){}
  ngOnInit(): void {
   this.id=this.route.snapshot.params['id'];
   this.userService.viewCard(this.id).subscribe(details=>{
  
    console.log(details);
   
    
    
   })
  }
  getAllCards(){
    this.router.navigate(['cards']);
  }
}

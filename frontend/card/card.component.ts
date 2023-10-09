import { Component,OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { card } from '../card';


@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  cards:card[]=[];
  
  constructor(private userService:UserService,private router:Router){}
  ngOnInit(): void {
    this.getAllCards();
  }
  
 private getAllCards(){
  this.userService.viewAllCards().subscribe(details=>{
    this.cards=details;
    console.log(details);
  })
 }

 viewCard(id:number){
  this.router.navigate(['view-card-details',id]);
    
 
 }
}

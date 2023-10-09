import { Component,OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../User';
import { LibraryServiceService } from '../library-service.service';
import { Book } from '../Book';

@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.css']
})
export class ViewUserComponent implements OnInit{
  id:number=0;
  cardId:any;
  userName:string="";
  userPassword:string="";
  userEmail:string="";
  about:string="";
  dob:any="";
  role:string="";
  particularUser:any;
  particularCard:any;
  particularBooks:Book = new Book();
  bookLists:Book[]=[];

  // particularUser:User=new User(this.id,this.userName,this.userEmail,this.userPassword,this.about,this.role,this.dob);
  constructor(private userService:UserService,private route:ActivatedRoute,private router:Router,private libraryService:LibraryServiceService ){

  }
    ngOnInit(): void {
     console.log(this.route.snapshot.params['id']);
     this.id=this.route.snapshot.params['id'];
     console.log(this.id);
     this.userService.viewUser(this.id).subscribe(data=>{
     this.particularUser = data;
    
     
     console.log(this.particularUser);
  
     })
    }
    cardDetails(){
     this.libraryService.getBooksOnCard(this.id).subscribe(data=>{
      
     this.bookLists=data;
  
      console.log(data);
     })
      
      
   

    }
    getAllUsers(){
      this.router.navigate(['users']);
    }
  }


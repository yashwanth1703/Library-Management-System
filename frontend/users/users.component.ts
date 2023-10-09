import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../User';
import { UserService } from '../user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  id:number=0;
  userName:string="";
  userPassword:string="";
  userEmail:string="";
  about:string="";
  dob:any="";
  role:string="";
  users:User[]=[];
  count:number=4;
  p:number=1;
 // user:User=new User(this.id,this.userName,this.userPassword,this.userEmail,this.dob,this.role,this.about);
 
  constructor(private router:Router,private userService:UserService){
   
  }

  ngOnInit(): void {
    this.getAllUsers();
  }
   getAllUsers():any{
  this.userService.viewAllUsers().subscribe(data=>{
    this.users=data;
    console.log(this.users);
  })
 }

 removeAllUsers(){
  var status = confirm("Are you sure you want to remove all users?")
  if(status==true){
    this.userService.deleteAllUsers().subscribe(data=>{
      console.log(data);
      this.getAllUsers();
    },error=>{console.log(error)})
    
  }
  else{
    this.getAllUsers();
  }
 }
updateUser(id:number){
  this.router.navigate(['/update-user',id]);
}
deleteUser(id:number){
 var status=confirm("Are you sure you want to delete this user?");
 if(status == true){
  this.userService.deleteUser(id).subscribe(data=>{
    console.log(data);
    this.getAllUsers();
  },error=>{console.log(error)})
 }
}
viewUser(id:number){
  console.log(id);
  this.router.navigate(['view-user',id]);
}
}

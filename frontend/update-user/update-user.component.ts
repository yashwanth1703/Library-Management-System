import { Component,Input,OnInit } from '@angular/core';
import { User } from '../User';
import { UserService } from '../user.service';
import { Router,ActivatedRoute } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit{
 id:number=0;
  userName:string=" ";
  password:string=" ";
  email:string=" ";
  dob:string=" ";
  about:any=" ";
  role:string=" "
user:User=new User(this.id,this.userName,this.password,this.email,this.dob,this.about,this.role);
constructor(private userService:UserService,private router:Router,private route:ActivatedRoute){}
ngOnInit(): void {
  this.id=this.route.snapshot.params['id'];
  this.userService.viewUser(this.id).subscribe(data=>{
    this.user[this.id,this.userName,this.password,this.email,this.dob,this.about,this.role]=data;
    console.log(this.user);
  },error=>{console.log(error)})
}



getAllUsers(){
  this.router.navigate(['/users']);
}

OnSubmit(){
  this.userService.updateUser(this.id,this.user).subscribe(data=>{
    this.user = data;
    console.log(data);
    this.getAllUsers();

  },error=>{console.log(error)})
}



}

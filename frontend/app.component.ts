import { Component,OnInit } from '@angular/core';
import { UserService } from './user.service';
import { User } from './User';
import { AuthGuardService } from './auth-guard.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'The Librarian';
  id:number=0;
  constructor(public userService:UserService,public authService:AuthGuardService,private router:Router){}
  logOut() {
   
    
   var status = confirm("Are you sure you want to log out?")
    if(status==true){
      sessionStorage.removeItem('loginStatus')
      sessionStorage.removeItem('email')
      sessionStorage.removeItem('password')
      sessionStorage.removeItem('role')
      sessionStorage.removeItem('userName');
      sessionStorage.removeItem('userId');
      this.router.navigate(['/add-feedback',this.id]);
    
  }
  else{
    this.router.navigate(['/library']);
  }
  
  }
  SignUp(){
    this.router.navigate(['/sign-up']);
  }

  SignIn(){
    this.router.navigate(['/sign-in']);
  }

  AboutUs(){
    this.router.navigate(['/About-us']);
  }
  Contact(){
    this.router.navigate(['/contact-us']);
  }
  saveFeedback(){
    this.router.navigate(['/add-feedback',sessionStorage.getItem('userId')]);
  }

  adminLogin(){
    return sessionStorage.getItem('userRole')==='ADMIN';

  }
  userLogin(){
    return sessionStorage.getItem('userRole')==='USER';
  }
  viewUser(){
    this.router.navigate(['view-user',sessionStorage.getItem('userId')]);
  }
}




import { card } from "./card";



export class User{
 
card():card{
   throw new Error("Method not implemented");
}

public userId:number=0;
public userName:string;
public userPassword:string;
public userEmail:string;
public dob:any;
public about:string;
public role:string;


constructor(userId:any,userName:any,userPassword:any,userEmail:any, dob:any, about:any, role:any)
{
  this.userId=userId;
  this.userName=userName;
  this.userEmail=userEmail;
  this.userPassword=userPassword;
  this.dob=dob;
  this.about=about;
  this.role=role;
 
}
}
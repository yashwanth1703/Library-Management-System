import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './User';
import { Router } from '@angular/router';
import { card } from './card';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseURL = "http://localhost:8080/library.com";

  constructor(private httpClient: HttpClient,private router:Router) {}

  signup(user:User):Observable<any>
  {
     const headers={'content-type':'application/json'};
     const body=JSON.stringify(user);
     return this.httpClient.post(`${this.baseURL}/signup`,body,{'headers':headers});
  }
  isUserLoggedIn() {
    let status = sessionStorage.getItem('loginStatus')
    console.log(status === null)
    return !(status === null)
  }
  viewAllUsers():Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseURL}/viewAllUsers`);
  }
  viewUser(id:number):Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseURL}/viewUser/${id}`);
  }
  deleteUser(id:number):Observable<Object>{
    return this.httpClient.delete<User>(`${this.baseURL}/deleteUser/${id}`);
  }
  updateUser(id:number,user:User):Observable<User>{
    return this.httpClient.put<User>(`${this.baseURL}/updateUser/${id}`,user);
  }
  deleteAllUsers():any{
    return this.httpClient.delete(`${this.baseURL}/removeAllUsers`);
  }
  viewCard(id:number):Observable<card[]>{
    return this.httpClient.get<card[]>(`${this.baseURL}/readCard/${id}`);
  }
  viewAllCards():Observable<card[]>{
    return this.httpClient.get<card[]>(`${this.baseURL}/readAllCards`)
  }
}

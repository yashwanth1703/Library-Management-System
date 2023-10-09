import { Injectable } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Author } from './Author';
@Injectable({
  providedIn: 'root'
})
export class AuthorService {
  private baseURL = "http://localhost:8080/library.com";
  constructor(private httpClient:HttpClient ) { }

  createAuthor(Obj:Author):Observable<any>{
    return this.httpClient.post(`${this.baseURL}/saveAuthor`,Obj);
  }
  updateAuthor(id:number,authorObj:Author):Observable<Author>{
    return this.httpClient.put<Author>(`${this.baseURL}/updateAuthor/${id}`,authorObj);
  }
  deleteAuthor(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/deleteAuthor/${id}`);
  }
  deleteAllAuthors():Observable<any>{
    return this.httpClient.delete(`${this.baseURL}/deleteAllAuthors`);
  }
  viewAuthor(id:number):Observable<Author>{
    return this.httpClient.get<Author>(`${this.baseURL}/readAuthor/${id}`);
  }
  viewAllAuthors():Observable<any>{
    return this.httpClient.get(`${this.baseURL}/readAllAuthors`);
  }
  findByAuthorName(authorName:string):Observable<Author[]>{
    return this.httpClient.get<Author[]>(`${this.baseURL}/readAllAuthorsByName?authorName=${authorName}`);
  }
}


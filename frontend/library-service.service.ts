import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Book } from './Book';


@Injectable({
  providedIn: 'root'
})
export class LibraryServiceService {
private baseURL = "http://localhost:8080/library.com";

  constructor(private httpClient : HttpClient) { }

  getBooksList() : Observable<Book[]>{
    return this.httpClient.get<Book[]>(`${this.baseURL}/readAllBooks`);
  }
  deleteAll() : Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deletAllBooksFromDataBase`);
  }
  createBook(obj : Book,authorId:number): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/saveBook/${authorId}`, obj);
  }

  getBookById(id:number) : Observable<Book> {
    return this.httpClient.get<Book>(`${this.baseURL}/readBook/${id}`);

}
  updateBook(id:number,bookObj:Book) : Observable<Book>{
    return this.httpClient.put<Book>(`${this.baseURL}/updateBook/${id}`,bookObj);
  }
  
  deleteBook(id:number) : Observable<Object>{
    return this.httpClient.delete<Book>(`${this.baseURL}/deleteBook/${id}`);

  }

  findByBookName(bookName:string):Observable<Book[]>{
    return this.httpClient.get<Book[]>(`${this.baseURL}/readAllBooks?bookName=${bookName}`);
  }
  findByBookAuthor(author:string):Observable<Book[]>{
    return this.httpClient.get<Book[]>(`${this.baseURL}/getAllBooksByAuthorName?author=${author}`);
  }

  findByPublishedBooks() : Observable<Book[]>{
    return this.httpClient.get<Book[]>(`${this.baseURL}/ispublished`);
  }

  findByNonPublishedBooks() : Observable<Book[]>{
    return this.httpClient.get<Book[]>(`${this.baseURL}/isNotPublished`);
  }

  signin(email:any, password:any):Observable<any>
  {

    const params=new HttpParams().set('email',email).set('password',password);
    console.log(params);
    return this.httpClient.get(`${this.baseURL}/login`,{params});
  }
  SortingCost(direction:string,field:string):Observable<Book[]>{
    console.log(direction)
    return this.httpClient.get<Book[]>(`${this.baseURL}/sortByPrice/${direction}?fieldName=${field}`);

  }
  
  SortRating(direction:string,field:string):Observable<Book[]>{
    console.log(direction)
    return this.httpClient.get<Book[]>(`${this.baseURL}/SortByRating/${direction}?fieldName=${field}`);

  }
  SortByOrder(direction:string,feild:string):Observable<Book[]>{
    console.log(direction);
    return this.httpClient.get<Book[]>(`${this.baseURL}/SortByBookName/${direction}?fieldName=${feild}`);
  }
  SortByAuthor(direction:string,feild:string):Observable<Book[]>{
    return this.httpClient.get<Book[]>(`${this.baseURL}/SortByAuthor/${direction}?fieldName=${feild}`);
  }

  getBooksOnCard(id:number):Observable<Book[]>{
    return this.httpClient.get<Book[]>(`${this.baseURL}/getBooks/${id}`);
  }
 
}
import { Injectable } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transaction } from './Transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  baseURL="http://localhost:8080/Transaction.com";
  constructor(private httpClient:HttpClient) { }

  issueBook(userId:any,bookId:number):any{
    console.log(`${this.baseURL}/purchaseBook/${userId}/${bookId}`);
   
     this.httpClient.get(`${this.baseURL}/purchaseBook/${userId}/${bookId}`);

  }

  getOtp(userId:any):Observable<any>{
     return  this.httpClient.get(`${this.baseURL}/getOtp/${userId}`)

  }

  getOtpMobile(userId:any):Observable<any>{
    return this.httpClient.get(`${this.baseURL}/getOtpMobile/${userId}`)
  }
}

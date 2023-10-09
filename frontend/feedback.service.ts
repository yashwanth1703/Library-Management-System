import { Injectable } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http';
import { feedback } from './Feedback';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
private baseURL = "http://localhost:8080/feedback";

  constructor(private httpClient:HttpClient) { }

  addFeedback(Obj:feedback,id:number,userid:number):any{
    return this.httpClient.post(`${this.baseURL}/add/${id}/${userid}`,Obj);

  }
  viewfeedback(id:number):Observable<feedback>{
    return this.httpClient.get<feedback>(`${this.baseURL}/getfeedback/${id}`);
  }
  viewAllFeedbacks():Observable<feedback[]>{
    return this.httpClient.get<feedback[]>(`${this.baseURL}/getAllFeedbacks`);
  }
  deleteFeedback(id:number):Observable<Object>{
    return this.httpClient.delete<Object>(`${this.baseURL}/deleteFeedback/${id}`);
  }
  deleteAllFeedbacks():Observable<any>{
    return this.httpClient.delete(`${this.baseURL}/deleteAllFeedbacks`);
  }
  }


import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private baseUrl = 'http://localhost:8080/loan'; // Your backend URL

  constructor(private http: HttpClient) { }

  getLoanApplications(size: number = 5, page: number = 0): Observable<any> {
    return this.http.get(`${this.baseUrl}/loan-application/page?size=${size}&page=${page}&sort=submittedAt,desc`);
  }

  getCustomer(id: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/customers/${id}`)
  }

}

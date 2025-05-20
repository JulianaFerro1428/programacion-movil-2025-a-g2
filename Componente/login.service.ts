import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/todolist/login';

  constructor(private http: HttpClient) {}
  
  login(email: string, contrasenia: string): Observable<any> {
    const body = new HttpParams()
      .set('email', email)
      .set('contrasenia', contrasenia);

    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded'
    });

    return this.http.post(this.apiUrl, body.toString(), { headers });
  }
}

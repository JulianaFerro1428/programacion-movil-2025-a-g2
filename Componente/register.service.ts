import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';
import { Usuario } from './usuario';

@Injectable({
    providedIn: 'root'
    })
export class RegisterService {
  private urlEndpoint = 'http://localhost:8080/todolist/register';
  constructor(private http: HttpClient) {}

  create(usuario: Usuario): Observable<any> {
    return this.http.post(this.urlEndpoint, usuario, { responseType: 'text' });
  }
}

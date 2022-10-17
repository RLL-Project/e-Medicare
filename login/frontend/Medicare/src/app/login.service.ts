import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { AuthenticationStatus } from './authentication-status/authentication-status.module';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private httpClient: HttpClient){}
  authenticate(
      username: String,
      password: string
  ): Observable<AuthenticationStatus>{
      console.log(username, password);
      let body={
          username: username,
          password: password,
      };
      let headers = new HttpHeaders({
          'content-type': 'application/json',
      });
      return this.httpClient.post<AuthenticationStatus>(
          'http://localhost:8080/api/user',
          body,
          {
              headers: headers,
          }
      );
  }
}

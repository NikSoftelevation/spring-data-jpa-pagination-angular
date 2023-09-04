import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private readonly serverurl: string = 'http://localhost:8087';

  constructor(private http: HttpClient) {}

  // Make call to the Backend API to retrieve page of users

  users$ = (
    name: string = '',
    page: number = 0,
    size: number = 10
  ): Observable<any> =>
    this.http.get<any>(
      `${this.serverurl}/users?name=${name}&page=${page}&size=${size}`
    );

  //   getUser(
  //     name: string = '',
  //     page: number = 0,
  //     size: number = 10
  //   ): Observable<any> {
  //     return this.http.get<any>(
  //       `${this.serverurl}/users?name=${name}&page=${page}&size=${size}`
  //     );
  //   }
}

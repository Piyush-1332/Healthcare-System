import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  isLoggedIn: boolean = false;
  isPatientLoggedIn: boolean = false;
  isAdminLoggedIn: boolean = false;
  constructor(private http: HttpClient) {}

  public register(user: User): Observable<any> {
    return this.http.post(
      'http://localhost:7000/api/v1/user/registration',
      user,
      {
        responseType: 'text',
      }
    );
  }

  user: User = new User();
  public login(userName: string, password: string): Observable<any> {
    this.user.userName = userName;
    this.user.password = password;

    return this.http.post(
      'http://localhost:7000/api/v1/user/login',
      this.user,
      {
        responseType: 'text',
      }
    );
  }

  public viewalluser(): Observable<any> {
    console.log('Am inside service');
    return this.http.get('http://localhost:7000/api/v1/user/viewalluser');
  }
  public viewUser(userName: String): Observable<any> {
    return this.http.get(
      'http://localhost:7000/api/v1/user/getloggedinuser/' + userName
    );
  }

  logout(): Observable<any> {
    console.log('inside  service delete');
    return this.http.get('http://localhost:7070/api/v1/user/user/logout');
  }
}

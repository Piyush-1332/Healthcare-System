import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Test } from '../model/Test';

@Injectable({
  providedIn: 'root',
})
export class TestService {
  test: Test[] = [];

  constructor(private http: HttpClient) {}
  loadTest(): Observable<any> {
    let url = 'http://localhost:7000/view';

    return this.http.get(url);
  }

  createNewTest(test: Test): Observable<any> {
    let url = 'http://localhost:7000/add';

    return this.http.post(url, test, { responseType: 'text' });
  }

  CancelTest(testId: number): Observable<any> {
    let url = 'http://localhost:7000/delete/';
    return this.http.delete(url + testId);
  }
}

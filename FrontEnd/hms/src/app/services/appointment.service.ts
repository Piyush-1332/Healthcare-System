import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from '../model/Appointment';

@Injectable({
  providedIn: 'root',
})
export class AppointmentService {
  constructor(private http: HttpClient) {}

  makeAppointment(appointment: Appointment): Observable<any> {
    const body = JSON.stringify(appointment);
    const headers = { 'content-type': 'application/json' };
    return this.http.post<Appointment>(
      'http://localhost:7000/api/v1/appointment/makeappointment',
      body,
      { headers }
    );
  }
  // readonly appointmentUrl : 'http://localhost:7000/api/v1/appointment';

  // getCenters(): Observable<Center[]> {
  //   return this.http.get<Center[]>('http://localhost:7000/center/getallcenters');
  //   }

  getAllAppointment(): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(
      'http://localhost:7000/api/v1/appointment/viewallappointments'
    );
  }

  // getAllTest(): Observable<Tests[]>
  // {
  //   return this.http.get<Tests[]>('http://localhost:7000/test/getAll');
  // }

  viewAllAppointmentByUserId(): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(
      'http://localhost:7000/api/v1/appointment/viewmyappointment/' +
        sessionStorage.getItem('userId')!
    );
  }
}

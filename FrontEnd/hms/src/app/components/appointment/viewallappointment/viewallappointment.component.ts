import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Appointment } from 'src/app/model/Appointment';
import { AppointmentService } from 'src/app/services/appointment.service';

@Component({
  selector: 'app-viewallappointment',
  templateUrl: './viewallappointment.component.html',
  styleUrls: ['./viewallappointment.component.css']
})
export class ViewallappointmentComponent implements OnInit {

  allAppointment : Appointment[];
  appointment : Appointment;
  appointmentId :any;
  status1 : string = "approved";
  status2 : string = "disapproved";
  baseUrl: string  = "http://localhost:7000/api/v1/appointment/approveappointment";
  disapproveUrl : string = "http://localhost:7000/api/v1/appointment/disapproveappointment";

  constructor(private appointmentService : AppointmentService,private http:HttpClient) { }

  ngOnInit(): void {
    this.showAllAppointment();
  }
  showAllAppointment(){
    return this.appointmentService.getAllAppointment().subscribe(appointment=>{
      this.allAppointment = appointment;
      console.log(this.allAppointment);
      
    })
  }

  approveAppointment(appointmentId:number)
  {
    console.log("approve");
    console.log(appointmentId);
    return this.http.get<Appointment>(this.baseUrl+'/'+appointmentId+'/approved').subscribe((res) =>{
      this.appointment=res
    });
    this.ngOnInit();
  }    

  disapproveAppointment(appointmentId:number)
  {
  
    console.log("disapprove");
    console.log(appointmentId);
    this.http.get<Appointment>(this.disapproveUrl+'/'+appointmentId+'/disapproved').subscribe((res) =>{
      this.appointment = res;
    });
    this.ngOnInit();
  }
}

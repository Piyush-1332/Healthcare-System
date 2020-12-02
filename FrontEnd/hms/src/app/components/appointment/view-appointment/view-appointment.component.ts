import { Component, OnInit } from '@angular/core';
import { Appointment } from 'src/app/model/Appointment';
import { AppointmentService } from 'src/app/services/appointment.service';

@Component({
  selector: 'app-view-appointment',
  templateUrl: './view-appointment.component.html',
  styleUrls: ['./view-appointment.component.css']
})
export class ViewAppointmentComponent implements OnInit {

  allUserAppointment : Appointment[];
  appointment : Appointment;

  constructor(private appointmentService : AppointmentService) { }

  ngOnInit(): void {
    this.showAllUserAppointment();
  }
  showAllUserAppointment(){
    return this.appointmentService.viewAllAppointmentByUserId().subscribe(appointment=>{
      this.allUserAppointment = appointment;
      console.log(this.allUserAppointment);
      
    })
  }

}

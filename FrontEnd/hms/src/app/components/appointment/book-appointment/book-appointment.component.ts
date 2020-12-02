import { Input } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Appointment } from 'src/app/model/Appointment';
import { DiagnosticCentre } from 'src/app/model/diagnostic-centre';
import { AppointmentService } from 'src/app/services/appointment.service';
import { CentreserviceService } from 'src/app/services/centreservice.service';

@Component({
  selector: 'app-book-appointment',
  templateUrl: './book-appointment.component.html',
  styleUrls: ['./book-appointment.component.css'],
})
export class BookAppointmentComponent implements OnInit {
  appointments: Appointment;
  listOfTest = ['RNA', 'Full body Test', 'Blood Test', 'Urine Test'];

  centers: Array<DiagnosticCentre> = [];

  appointmentForm: FormGroup;

  constructor(
    private healthService: AppointmentService,
    private centreService: CentreserviceService,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.appointmentForm = this.fb.group({
      testId: ['', Validators.required],
      centreId: ['', Validators.required],
      date: ['', Validators.required],
      time: ['', Validators.required],
    });

    this.centreService.getCentre().subscribe((data) => {
      this.centers = data;
    });
  }

  get testId() {
    return this.appointmentForm.get('testId');
  }
  get centreId() {
    return this.appointmentForm.get('centreId');
  }
  get date() {
    return this.appointmentForm.get('date');
  }
  get time() {
    return this.appointmentForm.get('time');
  }

  public makeAppointment = (appointmentForm: {
    testId: string;
    centreId: number;
    date: number;
    time: number;
  }) => {
    if (this.appointmentForm.valid) {
      this.executeAppointmentsCreation(appointmentForm);
    }
  };

  private executeAppointmentsCreation = (appointmentForm: {
    testId: string;
    centreId: number;
    date: number;
    time: number;
  }) => {
    this.appointments = {
      // userId:this.token.getUser().username,
      userId: '03',
      // testId:appointmentForm.testId,
      testId: 't103',
      centreId: appointmentForm.centreId.toString(),
      status: 'pending',
      dateTime:
        appointmentForm.date.toString() + ' ' + appointmentForm.time.toString(),
    };
    console.log('Hello', this.appointments);
    this.healthService.makeAppointment(this.appointments).subscribe(
      (Response) => {
        console.log('Success!', Response), alert('Added Successfully');
      },
      (Error) => {
        console.log('Error', Error), alert('The Slot Is Not Available');
      }
    );
  };
}

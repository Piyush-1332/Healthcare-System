import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookAppointmentComponent } from './components/appointment/book-appointment/book-appointment.component';
import { ViewAppointmentComponent } from './components/appointment/view-appointment/view-appointment.component';
import { ViewallappointmentComponent } from './components/appointment/viewallappointment/viewallappointment.component';
import { AppHomeComponent } from './components/shared/home/app-home/app-home.component';

const routes: Routes = [
  {path:'',component:AppHomeComponent},
  {path:'bookAppointment',component:BookAppointmentComponent},
  {path:'viewAppointment',component:ViewAppointmentComponent},
  {path:'viewAllAppointment',component:ViewallappointmentComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

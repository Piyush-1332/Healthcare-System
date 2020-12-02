import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookAppointmentComponent } from './components/appointment/book-appointment/book-appointment.component';
import { ViewAppointmentComponent } from './components/appointment/view-appointment/view-appointment.component';
import { ViewallappointmentComponent } from './components/appointment/viewallappointment/viewallappointment.component';
import { AddCentreComponent } from './components/diagnosticCentre/add-centre/add-centre.component';
import { DeleteCentreComponent } from './components/diagnosticCentre/delete-centre/delete-centre.component';
import { UpdateCentreComponent } from './components/diagnosticCentre/update-centre/update-centre.component';
import { AppHomeComponent } from './components/shared/home/app-home/app-home.component';

const routes: Routes = [
  { path: '', component: AppHomeComponent },
  { path: 'bookAppointment', component: BookAppointmentComponent },
  { path: 'viewAppointment', component: ViewAppointmentComponent },
  { path: 'viewAllAppointment', component: ViewallappointmentComponent },
  { path: 'addCentre', component: AddCentreComponent },
  { path: 'deleteCentre', component: DeleteCentreComponent },
  { path: 'updateCentre', component: UpdateCentreComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

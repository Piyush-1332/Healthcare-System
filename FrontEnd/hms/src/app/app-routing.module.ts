import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppHomeComponent } from './components/shared/home/app-home/app-home.component';

const routes: Routes = [
  {path:'',component:AppHomeComponent}
  // {path:'bookAppointment',component:},
  // {path:'bookAppointment',component:},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

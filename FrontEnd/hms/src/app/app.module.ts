import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppHeaderComponent } from './components/shared/header/app-header/app-header.component';
import { AppFooterComponent } from './components/shared/footer/app-footer/app-footer.component';
import { AppHomeComponent } from './components/shared/home/app-home/app-home.component';
import { DiagnosticCentreComponent } from './components/diagnosticCentre/diagnostic-centre/diagnostic-centre.component';
import { TestComponent } from './components/test/test/test.component';
import { LoginComponent } from './components/userManagement/login/login/login.component';
import { RegisterComponent } from './components/userManagement/register/register/register.component';
import { BookAppointmentComponent } from './components/appointment/book-appointment/book-appointment.component';
import { ViewAppointmentComponent } from './components/appointment/view-appointment/view-appointment.component';
import { AppointmentService } from './services/appointment.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ViewallappointmentComponent } from './components/appointment/viewallappointment/viewallappointment.component';
// import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    AppHeaderComponent,
    AppFooterComponent,
    AppHomeComponent,
    DiagnosticCentreComponent,
    TestComponent,
    LoginComponent,
    RegisterComponent,
    BookAppointmentComponent,
    ViewAppointmentComponent,
    ViewallappointmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [AppointmentService],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppHeaderComponent } from './components/shared/header/app-header/app-header.component';
import { AppFooterComponent } from './components/shared/footer/app-footer/app-footer.component';
import { AppHomeComponent } from './components/shared/home/app-home/app-home.component';
import { AppointmentComponent } from './components/appointment/appointment/appointment.component';
import { DiagnosticCentreComponent } from './components/diagnosticCentre/diagnostic-centre/diagnostic-centre.component';
import { TestComponent } from './components/test/test/test.component';
import { LoginComponent } from './components/userManagement/login/login/login.component';
import { RegisterComponent } from './components/userManagement/register/register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    AppHeaderComponent,
    AppFooterComponent,
    AppHomeComponent,
    AppointmentComponent,
    DiagnosticCentreComponent,
    TestComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

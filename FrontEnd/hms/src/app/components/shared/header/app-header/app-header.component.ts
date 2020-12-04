import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/userservice.service';

@Component({
  selector: 'app-app-header',
  templateUrl: './app-header.component.html',
  styleUrls: ['./app-header.component.css'],
})
export class AppHeaderComponent implements OnInit {
  isLogin: boolean = false;
  isAdmin: boolean = false;
  isPatient: boolean = false;
  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    this.toCheckUserRole();
  }
  toCheckUserRole() {
    if (sessionStorage.getItem('isloggedin') != null) {
      console.log('check user');
      this.isLogin = true;
      if (sessionStorage.getItem('isloggedin') == 'Admin') {
        this.isAdmin = true;
        this.isPatient = false;
      }
      if (sessionStorage.getItem('isloggedin') == 'Patient') {
        this.isAdmin = false;
        this.isPatient = true;
      }
    } else {
      this.isLogin = false;
    }
  }
  logoutUser() {
    sessionStorage.removeItem('isloggedin');
    this.isLogin = false;
    this.isAdmin = false;
    this.isPatient = false;
    alert('Logout sucess..!');
    this.router.navigateByUrl('/');
  }
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/User';
import { UserService } from 'src/app/services/userservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  userName: string = ' ';
  password: string = ' ';
  msg: String;
  errorMsg: string;

  user: User = new User();

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {}
  login() {
    this.userService
      .login(this.userName, this.password)
      .subscribe((response: any) => {
        this.hello(response);
      });

    this.userService.viewUser(this.userName).subscribe((data) => {
      this.user = data;
      sessionStorage.setItem('userId', this.user.userId.toString());
      console.log(this.user);

      sessionStorage.setItem('userId', data.userId.toString());
    });
  }
  hello(response: String) {
    this.msg = response;
    if (this.msg == 'Admin') {
      this.errorMsg = 'Welcome Admin';
      sessionStorage.setItem('isloggedin', 'Admin');
      window.location.reload();
      this.router.navigateByUrl('/');
    } else if (this.msg == 'Patient') {
      sessionStorage.setItem('isloggedin', 'Patient');
      this.errorMsg = 'Welcome patient';
      this.router.navigateByUrl('/');
    } else {
      sessionStorage.setItem('isloggedin', 'No');
      this.userService.isLoggedIn = false;
      this.userService.isAdminLoggedIn = false;
      this.userService.isPatientLoggedIn = false;
      this.errorMsg = 'Wrong credentials';
    }
    console.log(this.msg);
    console.log(this.errorMsg);
  }
}

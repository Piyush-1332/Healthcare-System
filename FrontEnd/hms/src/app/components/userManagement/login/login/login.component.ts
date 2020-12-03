import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {}
  login() {
    console.log(this.userName, this.password);

    this.userService
      .login(this.userName, this.password)
      .subscribe((response: any) => this.hello(response));
  }
  hello(response: String) {
    this.msg = response;
    if (this.msg == 'Admin') {
      this.errorMsg = 'Welcome Admin';
      this.router.navigate(['/admin']);
    } else if (this.msg == 'Patient') {
      this.errorMsg = 'Welcome patient';
      this.router.navigate(['/Patient']);
    } else {
      this.errorMsg = 'Wrong credentials';
      this.router.navigate(['userManagement/login']);
    }
    console.log(this.msg);
    console.log(this.errorMsg);
  }
}

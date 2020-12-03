import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/User';
import { UserService } from 'src/app/services/userservice.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  user: User = new User();
  msg: String;
  errorMsg: String;
  constructor(private userService: UserService) {}

  ngOnInit(): void {}
  register() {
    this.userService.register(this.user).subscribe(
      (data) => {
        console.log('data', data);
        this.msg = data;
        this.errorMsg = undefined;
        this.user = new User();
      },
      (error) => {
        this.errorMsg = JSON.parse(error.error).message;
        console.log(error.error);
        this.msg = undefined;
      }
    );
  }
}

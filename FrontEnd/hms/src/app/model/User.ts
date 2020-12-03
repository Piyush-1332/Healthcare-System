export class User {
  userId: number;
  userName: String;
  password: String;
  email: String;
  contactNumber: number;
  age: number;
  gender: String;

  constructor() {
    this.userId = 0;
    this.userName = ' ';
    this.password = ' ';
    this.email = ' ';
    this.contactNumber = 0;
    this.age = 0;
    this.gender = ' ';
  }
}

import { Component, OnInit } from '@angular/core';
import { Test } from 'src/app/model/Test';
import { TestService } from 'src/app/services/testservice.service';

@Component({
  selector: 'app-add-test',
  templateUrl: './add-test.component.html',
  styleUrls: ['./add-test.component.css'],
})
export class AddTestComponent implements OnInit {
  test: Test = new Test();

  constructor(private testservice: TestService) {}

  ngOnInit(): void {}
  public addTest(): void {
    this.testservice.createNewTest(this.test).subscribe(
      (data) => {
        alert('Test Added' + ' ' + this.test.testName);
      },
      (error) => {
        alert('Test is Invalid');
        console.log('error occured ', error);
      }
    );
  }
}

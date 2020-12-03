import { Component, OnInit } from '@angular/core';
import { Test } from 'src/app/model/Test';
import { TestService } from 'src/app/services/testservice.service';

@Component({
  selector: 'app-view-test',
  templateUrl: './view-test.component.html',
  styleUrls: ['./view-test.component.css'],
})
export class ViewTestComponent implements OnInit {
  test: Test[] = [];
  public popoverTitle: String = 'Confirmation';
  public popoverMessage: String = 'Are You Sure You Want to Remove';
  public confirmClicked: boolean = false;
  public cancelClicked: boolean = false;

  constructor(private testservice: TestService) {}

  ngOnInit(): void {
    this.testservice.loadTest().subscribe(
      (data) => {
        this.test = data;
      },
      (error) => {
        console.log('error occured ', error);
      }
    );
  }

  cancel(testId: number) {
    this.testservice.CancelTest(testId).subscribe(
      (data) => {
        alert('Test cancelled  ._.');
      },

      (error) => {
        location.reload();
        alert('Test cancelled  <. _ .>');
        console.log('error occured', error);
      }
    );
  }
}

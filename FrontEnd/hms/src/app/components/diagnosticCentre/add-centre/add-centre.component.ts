import { Component, OnInit } from '@angular/core';
import { DiagnosticCentre } from 'src/app/model/diagnostic-centre';
import { CentreserviceService } from 'src/app/services/centreservice.service';

@Component({
  selector: 'app-add-centre',
  templateUrl: './add-centre.component.html',
  styleUrls: ['./add-centre.component.css'],
})
export class AddCentreComponent implements OnInit {
  /*************************
   * creating centre instance for every time manupulate the data
   *************************/

  centre: DiagnosticCentre = new DiagnosticCentre();

  /***************************
   * creating centres array of DiagnosticCentre type to store the centre detail 
  /***************************/

  centres: DiagnosticCentre[];

  /***************************
   * creating centreList array of DiagnosticCentre type to store the centre detail 
  /***************************/

  centreList: Array<DiagnosticCentre> = [];

  /*************************
   * creating msg and errorMsg of string type to pass exception
   ************************/
  msg: string;
  errorMsg: string;

  constructor(private centreService: CentreserviceService) {}

  /***********************
   * Method: ngOnInit is life cycle hook called by angular at first
   * Description: ngOnInit first check the flag value if it is true then check
   *              and loads all the centre in the starting and it is
   *              checking if centre array length is zero then load centre
   *              and set the centre into the current array
   * Created Date: 27 Nov 2020
   * Author: Jaspret Singh
   ************************/

  ngOnInit(): void {
    console.log('inside ngOninit centre component');

    this.centreService.getCentre().subscribe((data) => {
      this.centres = data;
    });
  }

  /****************************
   * Method: addCentre
   * params: centre
   * return: msg based on action
   * Description: this method call service addCentre method and add centres every time
   *              and routes the page to display all centre detail after adding
   * Created Date: 27 Nov 2020
   * Author: Jaspreet Singh
   ****************************/

  addCentre() {
    this.centreService.addCentre(this.centre).subscribe(
      (data) => {
        console.log('data', data);
        this.msg = data;

        this.centre = new DiagnosticCentre();
      },

      (error) => {
        this.errorMsg = JSON.parse(error.error).message;
        console.log(error.error);
      }
    );
    alert('Added successfully');
    this.ngOnInit();
  }

  val: Boolean = false;
  showDetails() {
    this.val = !this.val;
    this.centreList.forEach((element) => {
      console.log(
        element.centreId +
          ' ' +
          element.centreName +
          ' ' +
          element.centreContactNumber +
          ' ' +
          element.centreAddress
      );
    });
  }

  ngOnDestroy() {
    this.centreList.slice();
  }
}

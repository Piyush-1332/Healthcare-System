import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { DiagnosticCentre } from 'src/app/model/diagnostic-centre';
import { CentreserviceService } from 'src/app/services/centreservice.service';

@Component({
  selector: 'app-update-centre',
  templateUrl: './update-centre.component.html',
  styleUrls: ['./update-centre.component.css'],
})
export class UpdateCentreComponent implements OnInit {
  /*************************
   * creating centre instance for every time manupulate the data
   *************************/

  centre: DiagnosticCentre = new DiagnosticCentre();

  /***************************
   * initializing centreId of number type 
  /***************************/

  centreId: number;

  /***************************
   * initializing updateId of number type 
  /***************************/

  updateId: number;

  /*************************
   * creating errorInfo and info of string type to pass exception
   ************************/

  errorInfo: string = undefined;
  info: string = undefined;

  constructor(
    private centreService: CentreserviceService,
    private router: Router
  ) {}

  /***********************
   * Method: ngOnInit is life cycle hook called by angular at first
   * Description: ngOnInit first check the flag value if it is true then check
   *              and loads all the centre in the starting and it is
   *              checking if centre array length is zero then load centre
   *              and set the centre into the current array
   * Created Date: 30 Nov 2020
   * Author: Jaspreet Singh
   ************************/

  ngOnInit() {
    this.updateId = this.centreService.IdToUpdate;
    this.centreService
      .findById(this.updateId)
      .subscribe((data) => (this.centre = data));
  }

  /***********************
   * Method: updateCentre()
   * params: centreId
   * return:
   * Description: this method is updating the centre
   * Created Date: 30 Nov 2020
   * Author: Jaspreet Singh
   ************************/

  updateCentre() {
    console.log('Centre  Details Updated!!');
    this.centreService.updateCentre(this.centre).subscribe(
      (data) => {
        // this.centre = data;
        //this.info = data;
        //this.errorInfo = undefined;
        console.log('data', data);
        this.centre = new DiagnosticCentre();
      },
      (error) => {
        this.errorInfo = JSON.stringify(error.error.text);
      }
    );

    // alert('Updated successfully');
  }
}

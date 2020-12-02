import { Component, OnInit } from '@angular/core';

import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { DiagnosticCentre } from 'src/app/model/diagnostic-centre';
import { CentreserviceService } from 'src/app/services/centreservice.service';

@Component({
  selector: 'app-delete-centre',
  templateUrl: './delete-centre.component.html',
  styleUrls: ['./delete-centre.component.css'],
})
export class DeleteCentreComponent implements OnInit {
  /*************************
   * creating centre instance for every time manupulate the data
   *************************/

  centre: DiagnosticCentre = new DiagnosticCentre();

  /***************************
   * creating centres array of DiagnosticCentre type to store the centre detail 
  /***************************/

  centres: DiagnosticCentre[] = [];

  /***************************
   * initializing centreId of number type 
  /***************************/

  centreId: number;

  /***************************
   * creating centreList array of DiagnosticCentre type to store the centre detail 
  /***************************/

  centreList: Array<DiagnosticCentre> = [];

  /*************************
   * creating msg and errorMsg of string type to pass exception
   ************************/

  msg: string;
  errorMsg: string;

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
   * Created Date: 27 APR 2020
   * Author: Princy Pandey
   ************************/

  ngOnInit(): void {
    console.log('inside ngOninit centre component');

    this.centreService.getCentre().subscribe((data) => {
      this.centres = data;
    });
  }

  /***********************
   * Method: deleteCentre
   * params: centreId
   * return: void
   * Description: this method collecting the value from service deleteCentre method
   *              and delete the specific centre
   *
   * Created Date: 28 APR 2020
   * Author: Princy Pandey
   ************************/

  deleteCentre(centreId: number) {
    this.centreService.deleteCentre(centreId).subscribe(
      (data) => {
        console.log(data);
        this.router.navigateByUrl('/delete-centre');
      },
      (error) => console.log(error)
    );
    console.log('Row Deleted!!');
    this.ngOnInit();
    // alert('Deleted successfully');
  }

  /***********************
   * Method: update
   * params: centreId
   * return: centreId
   * Description: this method collecting the value of centreId
   * Created Date: 28 APR 2020
   * Author: Princy Pandey
   ************************/

  update(centreId: number) {
    this.centreService.IdToUpdate = centreId;
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

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DiagnosticCentre } from '../model/diagnostic-centre';

/****************************
 * @author             Jaspreet Singh Ahuja
 * Description:        It is a service class that process action for adding,
 *                     removing and displaying centre,test,user and appointments
 * Version             1.0
 * Created             Date 22-Nov-2020
 ****************************/

@Injectable({
  providedIn: 'root',
})
export class CentreserviceService {
  successInfo: string;
  IdToUpdate: number;

  getSuccessInfo(): string {
    return this.successInfo;
  }

  setSuccessInfo(msg: string) {
    this.successInfo = msg;
  }

  constructor(private http: HttpClient) {}

  /***********************
   * Method: getCentre
   * return: Observable
   * Description: this method is hitting json file
   ************************/

  public getCentre(): Observable<any> {
    console.log('get centre');
    return this.http.get('http://localhost:7000/api/v1/diagnostic/getCentre');
  }

  /***********************
   * Method: addCentre
   * params: centre
   * Description: this method pushing the data using centre instance
   ************************/

  public addCentre(centre: DiagnosticCentre): Observable<any> {
    console.log('add centre call');
    return this.http.post(
      'http://localhost:7000/api/v1/diagnostic/addCentre',
      centre,
      {
        responseType: 'text',
      }
    );
  }

  /***********************
   * Method: deleteCentre
   * params: centreId
   * return: DiagnosticCentre[]
   * Description: this method is deleting the value which we not need
   ************************/

  public deleteCentre(centreId: number): Observable<any> {
    console.log('deleted');
    //let endpoint=centreId;
    return this.http.delete<DiagnosticCentre>(
      'http://localhost:7000/api/v1/diagnostic/deleteCentre' + '/' + centreId
    );
  }

  /***********************
   * Method: updateCentre
   * params: centreId
   * return: DiagnosticCentre[]
   * Description: this method is updating the value
   ************************/

  public updateCentre(centre: DiagnosticCentre): Observable<any> {
    console.log('updated');
    let end = centre.centreId;
    return this.http.put<DiagnosticCentre>(
      'http://localhost:7000/api/v1/diagnostic/updateCentre/' + end,
      centre
    );
  }

  /***********************
   * Method: findById
   * params: centreId
   * return: DiagnosticCentre[]
   * Description: this method is updating the value
   ************************/

  public findById(centreId: number): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-type': 'application/json' }),
    };
    let endpoint = centreId;
    return this.http.get(
      'http://localhost:7000/api/v1/diagnostic/viewcentrebyid/' + endpoint,
      httpOptions
    );
  }

  /***********************
   * Method: getUser
   * return: Observable
   * Description: this method is hitting json file
   ************************/

  public getUser(): Observable<any> {
    console.log('get user');
    return this.http.get('http://localhost:7000/api/v1/diagnostic/getUser');
  }
}

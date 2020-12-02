import { TestBed } from '@angular/core/testing';

import { CentreserviceService } from './centreservice.service';

describe('CentreserviceService', () => {
  let service: CentreserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CentreserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

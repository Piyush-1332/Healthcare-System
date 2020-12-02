import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiagnosticCentreComponent } from './diagnostic-centre.component';

describe('DiagnosticCentreComponent', () => {
  let component: DiagnosticCentreComponent;
  let fixture: ComponentFixture<DiagnosticCentreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DiagnosticCentreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DiagnosticCentreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

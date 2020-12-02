import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteCentreComponent } from './delete-centre.component';

describe('DeleteCentreComponent', () => {
  let component: DeleteCentreComponent;
  let fixture: ComponentFixture<DeleteCentreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteCentreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteCentreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

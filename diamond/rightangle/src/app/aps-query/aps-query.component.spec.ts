import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApsQueryComponent } from './aps-query.component';

describe('ApsQueryComponent', () => {
  let component: ApsQueryComponent;
  let fixture: ComponentFixture<ApsQueryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApsQueryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApsQueryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

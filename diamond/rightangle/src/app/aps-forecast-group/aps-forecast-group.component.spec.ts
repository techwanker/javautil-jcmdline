import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApsForecastGroupComponent } from './aps-forecast-group.component';

describe('ApsForecastGroupComponent', () => {
  let component: ApsForecastGroupComponent;
  let fixture: ComponentFixture<ApsForecastGroupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApsForecastGroupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApsForecastGroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

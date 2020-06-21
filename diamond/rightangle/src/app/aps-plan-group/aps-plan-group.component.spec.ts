import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApsPlanGroupComponent } from './aps-plan-group.component';

describe('ApsPlanGroupComponent', () => {
  let component: ApsPlanGroupComponent;
  let fixture: ComponentFixture<ApsPlanGroupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApsPlanGroupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApsPlanGroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApsPortalComponent } from './aps-portal.component';

describe('ApsPortalComponent', () => {
  let component: ApsPortalComponent;
  let fixture: ComponentFixture<ApsPortalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApsPortalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApsPortalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectedPositionComponent } from './projected-position.component';

describe('ProjectedPositionComponent', () => {
  let component: ProjectedPositionComponent;
  let fixture: ComponentFixture<ProjectedPositionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectedPositionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectedPositionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

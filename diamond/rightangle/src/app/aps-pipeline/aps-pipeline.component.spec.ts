import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApsPipelineComponent } from './aps-pipeline.component';

describe('ApsPipelineComponent', () => {
  let component: ApsPipelineComponent;
  let fixture: ComponentFixture<ApsPipelineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApsPipelineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApsPipelineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

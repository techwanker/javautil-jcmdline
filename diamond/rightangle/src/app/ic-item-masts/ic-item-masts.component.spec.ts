import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IcItemMastsComponent } from './ic-item-masts.component';

describe('IcItemMastsComponent', () => {
  let component: IcItemMastsComponent;
  let fixture: ComponentFixture<IcItemMastsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IcItemMastsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IcItemMastsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

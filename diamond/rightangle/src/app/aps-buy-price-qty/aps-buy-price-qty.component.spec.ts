import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApsBuyPriceQtyComponent } from './aps-buy-price-qty.component';

describe('ApsBuyPriceQtyComponent', () => {
  let component: ApsBuyPriceQtyComponent;
  let fixture: ComponentFixture<ApsBuyPriceQtyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApsBuyPriceQtyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApsBuyPriceQtyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

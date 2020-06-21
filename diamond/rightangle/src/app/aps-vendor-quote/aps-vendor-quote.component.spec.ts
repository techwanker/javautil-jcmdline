import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApsVendorQuoteComponent } from './aps-vendor-quote.component';

describe('ApsVendorQuoteComponent', () => {
  let component: ApsVendorQuoteComponent;
  let fixture: ComponentFixture<ApsVendorQuoteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApsVendorQuoteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApsVendorQuoteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

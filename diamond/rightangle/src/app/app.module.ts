import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ApsPortalComponent } from './aps-portal/aps-portal.component';
import { ApsQueryComponent } from './aps-query/aps-query.component';
import { ApsPipelineComponent } from './aps-pipeline/aps-pipeline.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { IcItemMastsComponent } from './ic-item-masts/ic-item-masts.component';
import { ApsPlanGroupComponent } from './aps-plan-group/aps-plan-group.component';
import { NullIfZero } from './NullIfZero.pipe';
import { ApsForecastGroupComponent } from './aps-forecast-group/aps-forecast-group.component';
import { ApsVendorQuoteComponent } from './aps-vendor-quote/aps-vendor-quote.component';
import { ApsBuyPriceQtyComponent } from './aps-buy-price-qty/aps-buy-price-qty.component';
import { ProjectedPositionComponent } from './projected-position/projected-position.component';

@NgModule({
  declarations: [
    AppComponent,
    ApsPortalComponent,
    ApsQueryComponent,
    ApsPipelineComponent,
    IcItemMastsComponent,
    ApsPlanGroupComponent,
    NullIfZero,
    ApsForecastGroupComponent,
    ApsVendorQuoteComponent,
    ApsBuyPriceQtyComponent,
    ProjectedPositionComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

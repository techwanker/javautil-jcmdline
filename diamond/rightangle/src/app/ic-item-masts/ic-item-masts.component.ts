import { Component, OnInit } from '@angular/core';
import { ApsDataService } from '../services/ApsDataService';

@Component({
  selector: 'app-ic-item-masts',
  templateUrl: './ic-item-masts.component.html',
  styleUrls: ['./ic-item-masts.component.css']
})
export class IcItemMastsComponent implements OnInit {

  dataService = new ApsDataService();

  icItemMasts = this.dataService.getIcItemMasts();

  constructor() { }

  ngOnInit() {
  }

}

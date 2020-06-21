import { Component, OnInit } from '@angular/core';
import { ApsDataService } from '../services/ApsDataService';
import { ForecastGroupLines } from '../dto/ForecastGroupLines';

@Component({
  selector: 'app-aps-forecast-group',
  templateUrl: './aps-forecast-group.component.html',
  styleUrls: ['./aps-forecast-group.component.css']
})
export class ApsForecastGroupComponent implements OnInit {

  constructor() { }

  dataService = new ApsDataService();

  forecastGroupLines = this.dataService.getForecastGroupLines();

  bucketNames = this.forecastGroupLines.bucketNames;

  ngOnInit() {
  }

}

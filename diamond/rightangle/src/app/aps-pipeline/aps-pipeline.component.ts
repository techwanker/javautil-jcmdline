import { Component, OnInit } from '@angular/core';
import { ApsDataService } from '../services/ApsDataService';

@Component({
  selector: 'app-aps-pipeline',
  templateUrl: './aps-pipeline.component.html',
  styleUrls: ['./aps-pipeline.component.css']
})
export class ApsPipelineComponent implements OnInit {

  constructor() { }

  dataService = new ApsDataService();

  pipeline  = this.dataService.getPipeLine();

  unitMeasurePrecision = "1.0-0";  // TODO should switch based on part number being displayed

  ngOnInit() {
  }

}

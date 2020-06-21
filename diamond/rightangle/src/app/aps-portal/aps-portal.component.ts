import { Component, OnInit } from '@angular/core';
import { ApsDataService } from '../services/ApsDataService';

@Component({
  selector: 'app-aps-portal',
  templateUrl: './aps-portal.component.html',
  styleUrls: ['./aps-portal.component.css']
})
export class ApsPortalComponent implements OnInit {

  dataService = new ApsDataService();

  reports = this.dataService.getReports();

  constructor() { }

  ngOnInit() {
  }

}

import { Component, OnInit } from '@angular/core';
import { ApsDataService } from '../services/ApsDataService';
import { ProjectedPositions} from '../dto/ProjectedPositions';

@Component({
  selector: 'app-projected-position',
  templateUrl: './projected-position.component.html',
  styleUrls: ['./projected-position.component.css']
})
export class ProjectedPositionComponent implements OnInit {
  dataService = new ApsDataService();

  positions: ProjectedPositions = this.dataService.getProjectedPositions();
  constructor() { }

  ngOnInit() {
  }

}

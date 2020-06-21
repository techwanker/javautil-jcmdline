import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-of-values',
  templateUrl: './list-of-values.component.html',
  styleUrls: ['./list-of-values.component.css']
})
export class ListOfValuesComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  /*   // TODO this needs to be restored
		console.log("Entering app definition");
		var app = angular.module('listOfValuesApp', []);
		console.log("app has been assigned");
		console.log("about to call with 'fcst_grp'");
		app.controller('listOfValuesCtrl', function($scope, $http) {
			key = $('#searchKey').val();
			console.log('key is ' + key);
			$http.get("listOfValues?queryName=fcst_grp&key=" + key).then(
					function(response) {
						$scope.values = response.data;
					});
		});
		console.log("app.controller assigned");
	*/
}

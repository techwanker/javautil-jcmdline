import { PIPELINE } from '../mock-data/mock-pipeline';
import { REPORTS } from '../mock-data/mock-reports';
import { ICITEMMASTS } from '../mock-data/mock-icItemMasts';
import { FORECAST_GROUP_LINES } from '../mock-data/mock-forecast-group-lines';
import { FORECAST_GROUPS } from '../mock-data/mock-fcst-grp';
import { IC_CATEGORIES } from '../mock-data/mock-ic-category';
import { PROJECTED_POSITIONS } from '../mock-data/mock-projected-positions';
import { PROJECTED_POSITIONS_SUM } from '../mock-data/mock-projected-positions-summary';

/**
 * Mock data service, to be replace with calls to the spring REST services
 */
export class ApsDataService {
    getProjectedPositions() {
         return PROJECTED_POSITIONS_SUM;
    }

    getPipeLine() {
        return PIPELINE;
    }

    getReports() {
        return REPORTS;
    }

    public getIcItemMasts() {
        return ICITEMMASTS;
    }

    public getForecastGroupLines() {
        return FORECAST_GROUP_LINES;
    }

    public getListOfValues(queryName: string) {
      switch (queryName) {
        case 'fcst_grp':
          return FORECAST_GROUPS;
        case 'ic_category':
          return IC_CATEGORIES;
        default:
            // should throw exception TODO
          return null;
        }
    }

}

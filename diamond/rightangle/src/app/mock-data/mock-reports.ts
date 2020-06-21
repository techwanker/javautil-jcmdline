import { Report } from '../dto/report';

export const REPORTS: Report[] = [
  {
    id: 1,
    reportUrl: 'https://reportService',
    reportName: 'CUST_OPEN_RFQ',
    description: 'Open Customer Request for Quotation',
    quantity: 370,
    amount: null,
    help: 'How to prioritize?'
  },
  {
    id: 2,
    reportUrl: 'https://reportService',
    reportName: 'JIT_SHORTAGE',
    description: 'Projected shortage for JIT item  within lead time',
    quantity: 312,
    amount: 183327.27,
    help: 'JIT or SLA projected shortages within lead time'
  },
  {
    id: 3,
    reportUrl: 'https://reportService',
    reportName: 'NEED_VND_RFQ',
    description: 'Items that need to be purchased still requiring Vendor Quotes',
    quantity: 137,
    amount: 37325824.43,
    help: 'Items requiring vendor quotes'
  },
 {
    id: 4,
    reportUrl: 'https://reportService',
    reportName: 'VND_RFQ_NORESP',
    description: 'Requests to Vendors for quote that have not been quoted',
    quantity: 117,
    amount: null,
    help: null
  },
  {
    id: 5,
    reportUrl: 'https://reportService',
    reportName: 'REQ_RQR_APPRV',
    description: 'Requisitions requiring approval',
    quantity: 7,
    amount: 7325824.43,
    help: null
  }
];

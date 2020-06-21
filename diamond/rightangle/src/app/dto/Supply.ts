export class Supply {
    identifier: string;
    facility: string;
    apsSplySubPoolId: number;
    mfrId: number;
    availDate: Date;
    icItemMastId: number;
    certCds: string[];
    isOnhand: boolean;
    isWorkorder: boolean;
    isPurchaseOrder: boolean;
    cntryCdOfOrigin: string;
    dateOfManufacture: Date;
    lotExpirationDate: Date;
    lotNbr: number;
    availQty: number;
    lotCost: number;
    itemNbrs: number[];
    minimumDemandDate: Date;
    grossAvailQty: number;
    // IcLotMast
    // plannedTransferNumber: number;
}

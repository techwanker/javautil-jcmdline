package com.pacificdataservices.diamond.planning.filter;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.IcCertCd;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;

public class CertTest
		extends AbstractSupplyEligibilityTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private boolean trace = true;
	@Override
	public boolean isSupplyEligibleForDemand(Supply supply, Demand demand, PlanningData planningData) {
		checkArguments(supply, demand, planningData);

		Boolean isOk = null;

		List<IcCertCd> demandCerts = demand.getIcCertCds();

		Map<String, IcCertCd> supplyCerts = supply.getIcCertCds();
		if (demandCerts == null || demandCerts.isEmpty()) {
			if (true) {
				logger.info("True -> No demand certs");
			}
			isOk = true;
		} else if (supplyCerts == null || supplyCerts.isEmpty()) {
			if (trace) {
				logger.info("False -> No supply certs");
			}
			// addIneligibleReason("supply has no certs - demand does");
			isOk = false;
		} else {
			if (trace) {
				logger.info("looking for cert in demandsCerts " + demandCerts.size());
			}
			for (IcCertCd cert : demandCerts) {
				if (supplyCerts.get(cert.getCertCd()) == null) {
					isOk = Boolean.FALSE;
					break;
				}
				if (cert.getCertSrcId().equals("Q")) {
					if ("X".equals(cert.getCertCd())) {
						isOk = Boolean.FALSE;
						break;
					} else {
						isOk = Boolean.TRUE;
					}
				} else {
					logger.info("cert is " + cert);
				}
			}
			// logger.info("checking certs for demand " +
			// this.getDemand().toString() + " " + demandCerts);

		}
		if (isOk == null) {
			throw new IllegalStateException("invalid code path, logic error");
		}
		return isOk;

	}

}

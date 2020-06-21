package com.pacificdataservices.diamond.planning.supply.priority;

import java.util.Collection;

import org.javautil.core.text.StringUtils;

import com.pacificdataservices.diamond.models.IcCertCd;
import com.pacificdataservices.diamond.planning.EligibleSupply;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.supply.Supply;


/**
 * TODO this should be used somewher
 * @author jjs
 *
 */
public class CertValueRank implements EligibleSupplyPriorityRanker{

	@Override
	public String getPriority(EligibleSupply eligibleSupply,
			PlanningData planningData) {
				
		Supply supply = eligibleSupply.getSupply();
		Collection<IcCertCd> certs = supply.getIcCertCds().values();
		int sumValue = 0;
		for (IcCertCd cert : certs) {
			sumValue += cert.getCertValue();
		}
		String sumValueText = Integer.toString(sumValue);
		String retval = StringUtils.leftPadWithChar(sumValueText, 6, "0");
		return retval;		        
	}

}

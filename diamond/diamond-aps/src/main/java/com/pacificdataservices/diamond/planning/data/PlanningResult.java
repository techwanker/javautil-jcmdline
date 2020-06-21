package com.pacificdataservices.diamond.planning.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.pacificdataservices.diamond.models.ApsAllocOnhandFc;
import com.pacificdataservices.diamond.models.ApsAllocOnhandOo;
import com.pacificdataservices.diamond.models.ApsAllocOnhandSs;
import com.pacificdataservices.diamond.models.ApsAllocOnhandWo;
import com.pacificdataservices.diamond.models.ApsAllocReplenFc;
import com.pacificdataservices.diamond.models.ApsAllocReplenOo;
import com.pacificdataservices.diamond.models.ApsAllocReplenSs;
import com.pacificdataservices.diamond.models.ApsAllocReplenWo;
import com.pacificdataservices.diamond.models.ApsAllocWoFc;
import com.pacificdataservices.diamond.models.ApsAllocWoOo;
import com.pacificdataservices.diamond.models.ApsAllocWoSs;
import com.pacificdataservices.diamond.models.ApsAllocWoWo;
import com.pacificdataservices.diamond.models.ApsResultDtlDmd;

/**
 * @author jjs
 * 
 */
public class PlanningResult implements Serializable {
	// Input data
	private List<ApsAllocOnhandFc> apsAllocOnhandFcs = new ArrayList<>();
	private List<ApsAllocOnhandOo> apsAllocOnhandOos = new ArrayList<>();
	private List<ApsAllocOnhandSs> apsAllocOnhandSss = new ArrayList<>();
	private List<ApsAllocOnhandWo> apsAllocOnhandWos = new ArrayList<>();
	private List<ApsAllocReplenFc> apsAllocReplenFcs = new ArrayList<>();
	private List<ApsAllocReplenOo> apsAllocReplenOos = new ArrayList<>();
	private List<ApsAllocReplenSs> apsAllocReplenSss = new ArrayList<>();
	private List<ApsAllocReplenWo> apsAllocReplenWos = new ArrayList<>();
	private List<ApsAllocWoFc> apsAllocWoFcs = new ArrayList<>();
	private List<ApsAllocWoOo> apsAllocWoOos = new ArrayList<>();
	private List<ApsAllocWoSs> apsAllocWoSss = new ArrayList<>();
	private List<ApsAllocWoWo> apsAllocWoWos = new ArrayList<>();

	/**
	 * 
	 */
	private static final long serialVersionUID = -3110347699532651715L;

	/**
	 * All data that should be populated from the database are set to empty lists in
	 * case this is populated from another source and there is no corresponding
	 * data.
	 * 
	 * @return
	 */
	private Collection<Integer> itemNumbers;
	private ArrayList<ApsResultDtlDmd> apsResultDtlDmds;
	/**
	 * @return the apsAllocOnhandFcs
	 */
	public List<ApsAllocOnhandFc> getApsAllocOnhandFcs() {
		return apsAllocOnhandFcs;
	}

	/**
	 * @param apsAllocOnhandFcs the apsAllocOnhandFcs to set
	 */
	public void setApsAllocOnhandFcs(List<ApsAllocOnhandFc> apsAllocOnhandFcs) {
		this.apsAllocOnhandFcs = apsAllocOnhandFcs;
	}

	/**
	 * @return the apsAllocOnhandOos
	 */
	public List<ApsAllocOnhandOo> getApsAllocOnhandOos() {
		return apsAllocOnhandOos;
	}

	/**
	 * @param apsAllocOnhandOos the apsAllocOnhandOos to set
	 */
	public void setApsAllocOnhandOos(List<ApsAllocOnhandOo> apsAllocOnhandOos) {
		this.apsAllocOnhandOos = apsAllocOnhandOos;
	}

	/**
	 * @return the apsAllocOnhandSss
	 */
	public List<ApsAllocOnhandSs> getApsAllocOnhandSss() {
		return apsAllocOnhandSss;
	}

	/**
	 * @param apsAllocOnhandSss the apsAllocOnhandSss to set
	 */
	public void setApsAllocOnhandSss(List<ApsAllocOnhandSs> apsAllocOnhandSss) {
		this.apsAllocOnhandSss = apsAllocOnhandSss;
	}

	/**
	 * @return the apsAllocOnhandWos
	 */
	public List<ApsAllocOnhandWo> getApsAllocOnhandWos() {
		return apsAllocOnhandWos;
	}

	/**
	 * @param apsAllocOnhandWos the apsAllocOnhandWos to set
	 */
	public void setApsAllocOnhandWos(List<ApsAllocOnhandWo> apsAllocOnhandWos) {
		this.apsAllocOnhandWos = apsAllocOnhandWos;
	}

	/**
	 * @return the apsAllocReplenFcs
	 */
	public List<ApsAllocReplenFc> getApsAllocReplenFcs() {
		return apsAllocReplenFcs;
	}

	/**
	 * @param apsAllocReplenFcs the apsAllocReplenFcs to set
	 */
	public void setApsAllocReplenFcs(List<ApsAllocReplenFc> apsAllocReplenFcs) {
		this.apsAllocReplenFcs = apsAllocReplenFcs;
	}

	/**
	 * @return the apsAllocReplenOos
	 */
	public List<ApsAllocReplenOo> getApsAllocReplenOos() {
		return apsAllocReplenOos;
	}

	/**
	 * @param apsAllocReplenOos the apsAllocReplenOos to set
	 */
	public void setApsAllocReplenOos(List<ApsAllocReplenOo> apsAllocReplenOos) {
		this.apsAllocReplenOos = apsAllocReplenOos;
	}

	/**
	 * @return the apsAllocReplenSss
	 */
	public List<ApsAllocReplenSs> getApsAllocReplenSss() {
		return apsAllocReplenSss;
	}

	/**
	 * @param apsAllocReplenSss the apsAllocReplenSss to set
	 */
	public void setApsAllocReplenSss(List<ApsAllocReplenSs> apsAllocReplenSss) {
		this.apsAllocReplenSss = apsAllocReplenSss;
	}

	/**
	 * @return the apsAllocReplenWos
	 */
	public List<ApsAllocReplenWo> getApsAllocReplenWos() {
		return apsAllocReplenWos;
	}

	/**
	 * @param apsAllocReplenWos the apsAllocReplenWos to set
	 */
	public void setApsAllocReplenWos(List<ApsAllocReplenWo> apsAllocReplenWos) {
		this.apsAllocReplenWos = apsAllocReplenWos;
	}

	/**
	 * @return the apsAllocWoFcs
	 */
	public List<ApsAllocWoFc> getApsAllocWoFcs() {
		return apsAllocWoFcs;
	}

	/**
	 * @param apsAllocWoFcs the apsAllocWoFcs to set
	 */
	public void setApsAllocWoFcs(List<ApsAllocWoFc> apsAllocWoFcs) {
		this.apsAllocWoFcs = apsAllocWoFcs;
	}

	/**
	 * @return the apsAllocWoOos
	 */
	public List<ApsAllocWoOo> getApsAllocWoOos() {
		return apsAllocWoOos;
	}

	/**
	 * @param apsAllocWoOos the apsAllocWoOos to set
	 */
	public void setApsAllocWoOos(List<ApsAllocWoOo> apsAllocWoOos) {
		this.apsAllocWoOos = apsAllocWoOos;
	}

	/**
	 * @return the apsAllocWoSss
	 */
	public List<ApsAllocWoSs> getApsAllocWoSss() {
		return apsAllocWoSss;
	}

	/**
	 * @param apsAllocWoSss the apsAllocWoSss to set
	 */
	public void setApsAllocWoSss(List<ApsAllocWoSs> apsAllocWoSss) {
		this.apsAllocWoSss = apsAllocWoSss;
	}

	/**
	 * @return the apsAllocWoWos
	 */
	public List<ApsAllocWoWo> getApsAllocWoWos() {
		return apsAllocWoWos;
	}

	/**
	 * @param apsAllocWoWos the apsAllocWoWos to set
	 */
	public void setApsAllocWoWos(List<ApsAllocWoWo> apsAllocWoWos) {
		this.apsAllocWoWos = apsAllocWoWos;
	}

	public  Collection<Integer> getItemNumbers() {
		return itemNumbers;
	}
	
	public void setItemNumbers(Collection<Integer> itemNumbers) {
		this.itemNumbers = itemNumbers;
	}

	public ArrayList<ApsResultDtlDmd> getApsResultDtlDmds() {
		return apsResultDtlDmds;
	}

	public void setApsResultDtlDmds(ArrayList<ApsResultDtlDmd> ardds) {
		apsResultDtlDmds = ardds;
	}
	
}

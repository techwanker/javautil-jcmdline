package org.javautil.exceptionprocessing.dto;

// Generated Jun 7, 2009 8:20:16 PM by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;

/**
 * UtDataLocation generated by hbm2java
 */
public class UtDataLocation implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UtDataLocationId id;
	private Set<UtTableRule> utTableRules = new HashSet<UtTableRule>(0);
	private Set<UtQuery> utQueries = new HashSet<UtQuery>(0);
	private Set<UtTableRuleHist> utTableRuleHists = new HashSet<UtTableRuleHist>(
			0);

	public UtDataLocation() {
	}

	public UtDataLocation(final UtDataLocationId id) {
		this.id = id;
	}

	public UtDataLocation(final UtDataLocationId id,
			final Set<UtTableRule> utTableRules, final Set<UtQuery> utQueries,
			final Set<UtTableRuleHist> utTableRuleHists) {
		this.id = id;
		this.utTableRules = utTableRules;
		this.utQueries = utQueries;
		this.utTableRuleHists = utTableRuleHists;
	}

	public UtDataLocationId getId() {
		return this.id;
	}

	public void setId(final UtDataLocationId id) {
		this.id = id;
	}

	public Set<UtTableRule> getUtTableRules() {
		return this.utTableRules;
	}

	public void setUtTableRules(final Set<UtTableRule> utTableRules) {
		this.utTableRules = utTableRules;
	}

	public Set<UtQuery> getUtQueries() {
		return this.utQueries;
	}

	public void setUtQueries(final Set<UtQuery> utQueries) {
		this.utQueries = utQueries;
	}

	public Set<UtTableRuleHist> getUtTableRuleHists() {
		return this.utTableRuleHists;
	}

	public void setUtTableRuleHists(final Set<UtTableRuleHist> utTableRuleHists) {
		this.utTableRuleHists = utTableRuleHists;
	}

}
package org.javautil.exceptionprocessing.dto;

// Generated Jun 7, 2009 8:20:16 PM by Hibernate Tools 3.2.2.GA

/**
 * UtProcessLogId generated by hbm2java
 */
public class UtProcessLogId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer utProcessStatusNbr;
	private Integer logSeqNbr;

	public UtProcessLogId() {
	}

	public UtProcessLogId(final Integer utProcessStatusNbr,
			final Integer logSeqNbr) {
		this.utProcessStatusNbr = utProcessStatusNbr;
		this.logSeqNbr = logSeqNbr;
	}

	public Integer getUtProcessStatusNbr() {
		return this.utProcessStatusNbr;
	}

	public void setUtProcessStatusNbr(final Integer utProcessStatusNbr) {
		this.utProcessStatusNbr = utProcessStatusNbr;
	}

	public Integer getLogSeqNbr() {
		return this.logSeqNbr;
	}

	public void setLogSeqNbr(final Integer logSeqNbr) {
		this.logSeqNbr = logSeqNbr;
	}

}
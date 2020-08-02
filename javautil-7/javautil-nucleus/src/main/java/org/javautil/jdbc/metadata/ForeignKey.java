package org.javautil.jdbc.metadata;

import java.util.ArrayList;

public interface ForeignKey {

	void addColumn(final ForeignKeyColumn col);

	/**
	 * @return the columns
	 */
    ArrayList<ForeignKeyColumn> getColumns();

	/**
	 * @return the deleteRule
	 */
    DeleteRule getDeleteRule();

	/**
	 * @return the fkName
	 */
    String getFkName();

	/**
	 * @return the fktableCat
	 */
    String getFktableCat();

	/**
	 * @return the fktableName
	 */
    String getFktableName();

	/**
	 * @return the fktableSchem
	 */
    String getFktableSchem();

	String getId();

	// /**
	// * @return the keySeq
	// */
	// public short getKeySeq() {
	// return keySeq;
	// }
	// /**
	// * @param keySeq the keySeq to set
	// */
	// public void setKeySeq(short keySeq) {
	// this.keySeq = keySeq;
	// }
	/**
	 * @return the pkName
	 */
    String getPkName();

	/**
	 * @return the pktableCat
	 */
    String getPktableCat();

	/**
	 * @return the pktableName
	 */
    String getPktableName();

	/**
	 * @return the pktableSchem
	 */
    String getPktableSchem();

	/**
	 * @return the updateRule
	 */
    short getUpdateRule();

	/**
	 * @param columns the columns to set
	 */
    void setColumns(final ArrayList<ForeignKeyColumn> columns);

	/**
	 * @param deleteRule the deleteRule to set
	 */
    void setDeleteRule(final short deleteRule);

	/**
	 * @param fkName the fkName to set
	 */
    void setFkName(final String fkName);

	/**
	 * @param fktableCat the fktableCat to set
	 */
    void setFktableCat(final String fktableCat);

	/**
	 * @param fktableName the fktableName to set
	 */
    void setFktableName(final String fktableName);

	/**
	 * @param fktableSchem the fktableSchem to set
	 */
    void setFktableSchem(final String fktableSchem);

	/**
	 * @param pkName the pkName to set
	 */
    void setPkName(final String pkName);

	/**
	 * @param pktableCat the pktableCat to set
	 */
    void setPktableCat(final String pktableCat);

	/**
	 * @param pktableName the pktableName to set
	 */
    void setPktableName(final String pktableName);

	/**
	 * @param pktableSchem the pktableSchem to set
	 */
    void setPktableSchem(final String pktableSchem);

	/**
	 * @param updateRule the updateRule to set
	 */
    void setUpdateRule(final short updateRule);

}